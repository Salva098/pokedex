package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Pokemon;

public class PokemonDAO extends BDDAO {

	/**
	 * Devuelve un objeto pokemon mediante la id
	 * @param idpokemon numero del pokemon que se va a devolver
	 * @return un Pokemon
	 */
	public Pokemon getPokemonDAO(int idpokemon) {
		Pokemon pk = null;
		String tipos = "";
		boolean next = false;
		try {
			ResultSet pokemon = stmt.executeQuery("select * from pokemon where n_pokemon = "+idpokemon);
			next = pokemon.next();
			if (next) {

				pk = new Pokemon(idpokemon, pokemon.getString(2), pokemon.getFloat(3), pokemon.getString(4),
						pokemon.getFloat(5), pokemon.getString(6), pokemon.getString(7), null,pokemon.getString(8),pokemon.getString(9),pokemon.getString(10));
			}

			ResultSet tipo = stmt.executeQuery(
					"select tipo from tipos,pokemon_tipos where tipos.idTipos = pokemon_tipos.idTipos and n_pokemon="
							+ idpokemon);
			int ntipos = 0;
			if (next) {

				while (tipo.next()) {
					ntipos++;
					if (ntipos == 1) {
						tipos = tipo.getString(1);
					} else {
						tipos = tipo.getString(1) + ", " + tipos;
					}
				}

				pk.setTipo(tipos);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return pk;
	}

	/**
	 * Comprueba si existe un pokemon con esa id
	 * @param idpokemon pokemon que se va a comprobar
	 * @return true si existe
	 */
	public boolean hayPokemon(int idpokemon) {
		try {
			ResultSet rs = stmt.executeQuery("select * from pokemon where n_pokemon = " + idpokemon);
				return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;

	}
	
	/**
	 * Devuelve las id de los pokemons que no existen
	 * @return Arraylist de las id de los pokemon que no existen
	 */
	public ArrayList<Integer> pokemonNoExisten(){
		ArrayList<Integer> idPokemon=new ArrayList<Integer>();
		for (int i = 1; i < ultimoPokemon(); i++) {
			if (!hayPokemon(i)) {
				idPokemon.add(i);
			}
		}
		idPokemon.add(ultimoPokemon()+1);
		return idPokemon;
	}

	/**
	 * Inserta un pokemon a la base de datos
	 * @param pokimon pokemon que se va a insertar
	 */
	public void NewPokimon(Pokemon pokimon) {
		try {
			PreparedStatement poke = conn.prepareStatement(
					"INSERT INTO pokemon (n_pokemon, Nombre, Altura, Categoria, Peso, Descripcion, Habilidad, ImgPoke, IcoPoke, SonidoPoke) VALUES (?,?,?,?,?,?,?,?,?,?)");
			poke.setInt(1, pokimon.getId_pokemon());
			poke.setString(2, pokimon.getNombre());
			poke.setFloat(3, pokimon.getAltura());
			poke.setString(4, pokimon.getCategoria());
			poke.setFloat(5, pokimon.getPeso());
			poke.setString(6, pokimon.getDescripcion());
			poke.setString(7, pokimon.getHabilidad());
			poke.setString(8, pokimon.getImagen());
			poke.setString(9, pokimon.getGif());
			poke.setString(10, pokimon.getSonido());
			
			poke.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		anadirTipos(pokimon);
	}
	
	/**
	 * Array con los nombres de los tipos
	 * @return Array de Stirng con los tipos
	 */
	public String[] arrTipos() {
		ArrayList<String> tipos= new ArrayList<String>();
		try {
			ResultSet rsTodosTipos=stmt.executeQuery("select tipo from tipos");
			while (rsTodosTipos.next()) {
				tipos.add(rsTodosTipos.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String [] finalTipos = new String[tipos.size()];
		return tipos.toArray(finalTipos);
		
	}
	
	/**
	 * Devuelve un array con los indices de los tipos que tiene un pokemon
	 * @param Poke pokemon que se va a buscar los tipos
	 * @return array de indices de los tipos de un pokemon
	 */
	public int[] arrTipoSelecionado(Pokemon Poke) {
		ArrayList<Integer> tiposDelPokemon= new ArrayList<Integer>();
		try {
			ResultSet rsTodosTipos=stmt.executeQuery("select idtipos from pokemon_tipos where n_pokemon = "+Poke.getId_pokemon());
				while (rsTodosTipos.next()) {
					tiposDelPokemon.add(rsTodosTipos.getInt(1));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tiposDelPokemon.stream().mapToInt(i->i).toArray();
		
	}
	
	/**
	 * Anyade los tipos a un pokemon 
	 * @param pokimon pokemon que se le va a anyadir los tipos
	 */
	public void anadirTipos(Pokemon pokimon) {
		String[] tipos;
		try {
			tipos = pokimon.getTipo().split(", ");
			for (int i = 0; i < tipos.length; i++) {
				ResultSet n_tipo = stmt.executeQuery("SELECT idTipos FROM tipos WHERE  Tipo like '" + tipos[i] + "'");
				if (n_tipo.next()) {
					tipos[i] = n_tipo.getString(1);
					}
			}
			
			for (int i = 0; i < tipos.length; i++) {
				PreparedStatement tipoBD = conn
						.prepareStatement("INSERT INTO pokemon_tipos (n_pokemon, idTipos) VALUES (?, ?)");
				tipoBD.setInt(1, pokimon.getId_pokemon());
				tipoBD.setString(2, tipos[i]);
				tipoBD.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Comprueba si existe los tipos de los pokemons
	 * @param poke pokemon para comparar si existe esos tipos
	 * @return true si existe esos tipos
	 */
	public boolean existeTipo(Pokemon poke) {
		String tipos[] = poke.getTipo().split(", ");
		try {
			for (int i = 0; i < tipos.length; i++) {
				ResultSet n_tipo = stmt.executeQuery("SELECT idTipos FROM tipos WHERE  Tipo like '" + tipos[i] + "'");
				if (!n_tipo.next()) {
					return false;
				}
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Devuelve la imagen del tipo
	 * @param tipo nombre del tipo que se quiere la imagen
	 * @return la url de la imagen
	 */
	public String geticonoTipo(String tipo) {
		try {
			ResultSet rs = stmt.executeQuery("select tipoico from tipos where tipo like '" + tipo + "'");
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * Obtiene el primer id de la base de dato
	 * @return el primer valor de la base de datos
	 */
	public int primerPokemon() {
		try {
			ResultSet rs = stmt.executeQuery("select min(n_pokemon) from pokemon ");
			if (rs.next()) {

				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * Devuelve el ultimo valor de la base de datos
	 * @return el ultimo valor de la base de datos
	 */
	public int ultimoPokemon() {
		try {
			ResultSet rs = stmt.executeQuery("select max(n_pokemon) from pokemon ");
			if (rs.next()) {

				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Borra el pokemon con la id  
	 * @param id del pokemon
	 */
	public void borrarPokemon(int id) {
		try {
			stmt.executeUpdate("DELETE FROM pokemon_tipos WHERE n_pokemon = " + id);
			stmt.executeUpdate("DELETE FROM pokemon WHERE n_pokemon = " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Edita el pokemon en la base de datos
	 * @param Poke pokemon que se va a cambiar los valores en la base de datos
	 */
	public void editPokemon(Pokemon Poke) {
		try {
			PreparedStatement edit = conn.prepareStatement("UPDATE pokemon SET Nombre = ?, Altura = ?, Categoria = ?, Peso = ?, Descripcion = ?, Habilidad = ? WHERE (n_pokemon = ?)");
			edit.setString(1, Poke.getNombre());
			edit.setFloat(2, Poke.getAltura());
			edit.setString(3, Poke.getCategoria());
			edit.setFloat(4, Poke.getPeso());
			edit.setString(5, Poke.getDescripcion());
			edit.setString(6, Poke.getHabilidad());
			edit.setInt(7, Poke.getId_pokemon());
			edit.executeUpdate();
			
			stmt.executeUpdate("DELETE FROM pokemon_tipos WHERE n_pokemon = " + Poke.getId_pokemon());
			anadirTipos(Poke);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve en un Arraylist con los pokemons en la busqueda por nombre
	 * @param Pokemon texto que se va a buscar en la base de datos
	 * @return Arraylist con los pokemon 
	 */
	public ArrayList<Pokemon> buscarPorNombre(String Pokemon) {
		ArrayList<Pokemon> Resultado=new ArrayList<Pokemon>();
		
		try {
			Statement stmt1=conn.createStatement();
			ResultSet res = stmt1.executeQuery("select n_pokemon from pokemon where nombre like '%"+Pokemon+"%' order by n_pokemon");
			while (res.next()) {
				Resultado.add(getPokemonDAO(res.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return Resultado;
		
	}
	
	/**
	 * Devuelve en un Arraylist con los pokemons en la busqueda por tipos
	 * @param Tipos texto que se va a buscar en la base de datos
	 * @return Arraylist con los pokemon
	 */
	public ArrayList<Pokemon> buscarPorTipo(ArrayList<String>Tipos) {
		ArrayList<Pokemon> Resultado=new ArrayList<Pokemon>();
		String tipos="";
		for (int i = 0; i < Tipos.size() ; i++) {
			if (i == 0) {
				tipos = "'"+Tipos.get(i)+"'";
			} else {
				tipos = "'"+Tipos.get(i)+"'" + ", " + tipos;
			}
		}
		try {
			Statement stmt1=conn.createStatement();
			ResultSet res = stmt1.executeQuery("select n_pokemon from pokemon_tipos,tipos where pokemon_tipos.idTipos=tipos.idTipos and Tipo in ("+tipos+") order by n_pokemon");
			while (res.next()) {
				Resultado.add(getPokemonDAO(res.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Resultado;
		
	}

}
