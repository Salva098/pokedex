package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO extends BDDAO {

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

	public void register(String usuario, String contrasena) {

		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO login (usuario,contrasena) VALUES (?,?)");
			stmt.setString(1, usuario);
			stmt.setString(2, contrasena);
			stmt.executeUpdate();

			// loop through the result set

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
