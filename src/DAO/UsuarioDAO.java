package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO extends BDDAO {

	
	/**
	 * Metodo para comprobar el usuario y contrasena
	 * @param usuario que se va a comprobar
	 * @param contrasena del usuario que se va a comprobar
	 * @return true si existe el usuario
	 */
	public boolean login(String usuario, String contrasena) {

		try  {
			ResultSet rs = stmt.executeQuery("select * from login where usuario like '" + usuario
						+ "' and contrasena like '" + contrasena + "'");

			// loop through the result set
			return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	/**
	 * Metodo para comrpobar si existe el usuario para no duplicar
	 * @param usuario para comprobar si existe
	 * @return true si existe
	 */
	public boolean comprobarUsuarios(String usuario) {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from login where usuario like '"+ usuario+ "'");

			return rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Registra un usuario en la base de datos 
	 * @param usuario que va a anadir
	 * @param contrasena del usuario que se va a registrar
	 */
	public void register(String usuario, String contrasena) {

		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO login (usuario,contrasena) VALUES (?,?)");
			stmt.setString(1, usuario);
			stmt.setString(2, contrasena);
			stmt.executeUpdate();


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
