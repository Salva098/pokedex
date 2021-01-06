package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Pokemon;

public class PokemonDAO extends BDDAO {

	public static Pokemon getPokemonDAO(int idpokemon) {
		Pokemon pk = null;
		String tipos = "";
		boolean next = false;
		try {
			ResultSet rs = stmt.executeQuery("select * from pokemon where n_pokemon = " + idpokemon);
			next = rs.next();
			if (next) {

				pk = new Pokemon(idpokemon, rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getFloat(5),
						rs.getString(6), rs.getString(7), null);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			ResultSet rs = stmt.executeQuery(
					"select tipo from tipos,pokemon_tipos where tipos.idTipos = pokemon_tipos.idTipos and n_pokemon="
							+ idpokemon);
			int ntipos = 0;
			if (next) {

				while (rs.next()) {
					ntipos++;
					if (ntipos == 1) {
						tipos = rs.getString(1);
					} else {
						tipos = rs.getString(1) + ", " + tipos;
					}
				}

				pk.setTipo(tipos);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return pk;
	}

	public static boolean haySiguiente(int idpokemon) {
		try {
			ResultSet rs = stmt.executeQuery("select * from pokemon where n_pokemon = " + idpokemon);

			return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;

	}

	public static boolean NewPokimon(Pokemon pokimon) {
		String[] tipos;
		try {
			PreparedStatement poke = conn.prepareStatement(
					"INSERT INTO pokemon (n_pokemon, Nombre, Altura, Categoria, Peso, Descripcion, Habilidad) VALUES (?,?,?,?,?,?,?)");
			poke.setInt(1, pokimon.getId_pokemon());
			poke.setString(2, pokimon.getNombre());
			poke.setFloat(3, pokimon.getAltura());
			poke.setString(4, pokimon.getCategoria());
			poke.setFloat(5, pokimon.getPeso());
			poke.setString(6, pokimon.getDescripcion());
			poke.setString(7, pokimon.getHabilidad());
			poke.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			tipos = pokimon.getTipo().split(", ");
			for (int i = 0; i < tipos.length; i++) {
				ResultSet n_tipo = stmt.executeQuery("SELECT idTipos FROM tipos WHERE  Tipo like '" + tipos[i] + "'");
				if (n_tipo.next()) {
					tipos[i] = n_tipo.getString(1);
				}else {
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

	public static int cuantosPokemonHay() {
		ResultSet rs;
		try {
			rs = stmt.executeQuery("select count(*) from pokemon");
			if (rs.next()) {

				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
