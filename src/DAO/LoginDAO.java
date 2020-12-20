package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public static boolean login(String usuario, String contrasena) {

		try (
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pokedex?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "pokemonapp", "Cajamar123.");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from login where usuario like '"+usuario+"' and contrasena like '"+contrasena+"'"))
		{

			// loop through the result set
				return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}
	// no se pueden anadir entrenadores
//	public static boolean register(String usuario, String contrasena) {
//
//		String consulta= "INSERT INTO `pokedex`.`login` (`usuario`, `contrasena`) VALUES ('"+usuario+"', '"+contrasena+"')";
//		try (
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pokedex?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "pokemonapp", "Cajamar123.");
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeUpdate(consulta))
//		{
//
//			// loop through the result set
//				return rs.next();
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//		return false;
//	}
}
