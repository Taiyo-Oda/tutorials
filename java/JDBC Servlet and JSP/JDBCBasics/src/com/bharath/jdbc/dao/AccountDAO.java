package com.bharath.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {

		// tryブロックのリソースセクションに記述することで明示的にcloseする必要がなくなる
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "taiyou03");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * form account");) {
			// 論理ポインタ（レコード領域を移動するカーソル）を移動させる（次のカラムを取得する）
			while (rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
