package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BDDAO {

	protected static Connection conn = Connection();
	protected static Statement stmt = Statement();
	
	
	private static Connection Connection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://bvrp7p5nq78vomv3rqqa-mysql.services.clever-cloud.com:3306/bvrp7p5nq78vomv3rqqa",
					"uib0crkjr2wfmixk", "cKdtzqt03ek2w81mh4H2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	private static Statement Statement() {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
}
