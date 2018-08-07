package com.healthec.generic.utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseConnector {

	private static String databaseURLQA = "jdbc:sqlserver://192.168.6.113\\HEALTHECDEMO;";
	private static String databaseURLSIT1 = "jdbc:sqlserver://192.168.4.136\\HECSTG;";
	private static String databaseURLSIT2 = "jdbc:sqlserver://192.168.8.52";
	private static String dbusername = "AkashMahato";
	private static String dbpassword = "H3C$@$17";
    public static Logger log = Logger.getLogger("devpinoyLogger");

	public static String executeSQLQuery(String testEnv, String DBName, String sqlQuery) {
	    Connection connection;
        ResultSet rs;
        String connectionUrl = "";
		String resultValue = "";

		if (testEnv.equalsIgnoreCase("QA")) {
			connectionUrl = databaseURLQA;
			dbusername = "AkashMahato";
			dbpassword = "H3C$@$17";
		}
		// To connect with Stage Database
		else if (testEnv.equalsIgnoreCase("SIT1")) {
			connectionUrl = databaseURLSIT1;
			dbusername = "AkashMahato";
			dbpassword = "H3C$@$17";
		}
		else if (testEnv.equalsIgnoreCase("SIT2")) {
			connectionUrl = databaseURLSIT2;
			dbusername = "AkashMahato";
			dbpassword = "H3C$@$17";
		}

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            //Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(connectionUrl + "databaseName=" + DBName, dbusername, dbpassword);

			System.out.println(connectionUrl + "databaseName=" + DBName);
			if (connection != null) {
				System.out.println();
				System.out.println("Connected to " + DBName + " database in " + testEnv + " Environment");
				System.out.println();
			} else {
				System.out.println("Database connection failed to " + testEnv + " Environment");
			}
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sqlQuery);
			rs.last();
			int totalRow = rs.getRow();
			System.out.println("Total Row size: " + totalRow);
			rs.beforeFirst();

			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			System.out.println("Total Column size: " + columnCount);

			System.out.println();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = metadata.getColumnName(i);
				System.out.print(" " + columnName + " == ");

				try {
					while (rs.next()) {
						// System.out.println();

						resultValue = rs.getObject(i) + ",";
						System.out.print(" " + resultValue);

					}
					rs.beforeFirst();
					System.out.println();
					System.out.println();
				} catch (SQLException e) {
					e.getMessage();
				} catch (NullPointerException err) {
					System.out.println("No Records obtained for this specific query");
					err.getMessage();
				}
			}

			connection.close();

		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception11:" + sqlEx.getMessage());
		}
		// System.out.println(resultValue);
		return resultValue;
	}

	public static void main(String[] args) {
		String query = executeSQLQuery("QA", "PROVIDERADMIN", "select * from edw.cdr.profile");
		// System.out.println(query);
		//select * from edw.cdr.phr_user_labtest_result where labtest_id in"
		//+ "(Select LABTEST_ID from edw.cdr.PHR_USER_LABTEST where order_id in "
	//	+ "(select order_id from edw.cdr.ORDER_INFO where hospitalization_id in"
		//+ "(select hospitalization_id from edw.cdr.PHR_USER_HOSPITALIZATION where healthrecordkey='156261' a"
		//+ "nd cast(created_date as date)='2017-10-27')))

	}
}
