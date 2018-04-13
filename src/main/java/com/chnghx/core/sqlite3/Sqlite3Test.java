package com.chnghx.core.sqlite3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sqlite3Test {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");

		Connection conn = null;

		try {
//			Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:"); //使用内存数据库
			conn = DriverManager.getConnection("jdbc:sqlite:chnghx.db");//使用物理数据库
			Statement st = conn.createStatement();
			st.setQueryTimeout(30); // set timeout to 30 sec.
			st.executeUpdate("drop table if exists person");
			st.executeUpdate("create table person (id integer, name string)");
			st.executeUpdate("insert into person values(1, 'leo')");
			st.executeUpdate("insert into person values(2, 'yui')");
			ResultSet rs = st.executeQuery("select * from person");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
