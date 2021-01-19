package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Pokemon;

public class PokemonDAO extends BDDAO {

	public Pokemon getPokemonDAO(int idpokemon) {
		Pokemon pk = null;
		String tipos = "";
		boolean next = false;
		try {
			ResultSet pokemon = stmt.executeQuery("select * from pokemon where n_pokemon = " + idpokemon);
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

	public boolean haySiguiente(int idpokemon) {
		try {
			ResultSet rs = stmt.executeQuery("select * from pokemon where n_pokemon = " + idpokemon);

			return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;

	}

	public boolean NewPokimon(Pokemon pokimon) {
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
		
		return añadirTipos(pokimon);
	}
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
	public boolean añadirTipos(Pokemon pokimon) {
		String[] tipos;
		try {
			tipos = pokimon.getTipo().split(", ");
			for (int i = 0; i < tipos.length; i++) {
				ResultSet n_tipo = stmt.executeQuery("SELECT idTipos FROM tipos WHERE  Tipo like '" + tipos[i] + "'");
				if (n_tipo.next()) {
					tipos[i] = n_tipo.getString(1);
				} else {
					return false;
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
		return true;
	}

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

	public int cuantosPokemonHay() {
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
	public void borrarPokemon(int id) {
		try {
			stmt.executeUpdate("DELETE FROM pokemon_tipos WHERE n_pokemon = " + id);
			stmt.executeUpdate("DELETE FROM pokemon WHERE n_pokemon = " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

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
			añadirTipos(Poke);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertarPokemonimagenysonido(String imagen, String gif, String sonido, int idpokemon) {
		try {
			PreparedStatement edit = conn.prepareStatement("UPDATE pokemon SET ImgPoke = ?, IcoPoke = ?, SonidoPoke = ? WHERE (n_pokemon = ?)");
			edit.setString(1,imagen);
			edit.setString(2,gif);
			edit.setString(3,sonido);
			edit.setInt(4, idpokemon);
			edit.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
