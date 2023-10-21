///usr/bin/env jbang "$0" "$@" ; exit $?

package io.eng.parsa.db_connection;

import static java.lang.System.*;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.nio.charset.*;
import java.util.*;

/**
 * This program tests that the database and the JDBC driver are correctly configured
 */

public class TestDB {
	public static void main(String args[]) throws IOException {

		try {
			runTest();
		} catch (SQLException e) {
			for (Throwable t : e)
				t.printStackTrace();
		}
	}

	/**
	 * Runs a test by: 
	 * (1) creating a table, 
	 * (2) adding a value, 
	 * (3) showing the table contents, 
	 * (4) and removing the table
	 */

	public static void runTest() throws SQLException, IOException {

		try (Connection conn = getConnection(); Statement stat = conn.createStatement()) {

			stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
			stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, Database programming')");

			try (ResultSet result = stat.executeQuery("SELECT * FROM Greetings")) {

				if (reuslt.next())
					System.out.println(result.getString(1));
			}

			stat.executeUpdate("DROP TABLE Greetings");
		}
	}

	/**
	 * <p>Gets a connection from the properties specified in the file "database.properties"</p>
	 *
	 * @return the database connection
	 */

	public static Connection getConnection() throws SQLException, IOException {

		var props = new Properties();
		try (Reader in = Files.newBufferedReader(Path.of("database.properties"), StandardCharsets.UTF_8)) {

			String drivers = props.getProperty("jdbc.drivers");
			if (drivers != null) 
				System.setProperty("jdbc.drivers", drivers);

			String url = props.getProperty("jdbc.drivers");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			return DriverManager.getConnection(url, username, password)
		}
	}
}
