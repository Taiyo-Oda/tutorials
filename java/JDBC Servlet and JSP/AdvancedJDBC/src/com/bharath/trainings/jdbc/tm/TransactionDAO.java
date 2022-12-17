package com.bharath.trainings.jdbc.tm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "taiyou03");
			Statement stmt = con.createStatement();
			// commitメソッドまでのSQLを一つのトランザクションとして実行する
			con.setAutoCommit(false);
			stmt.executeUpdate("update account set bal=bal-500 where accno=2");
			stmt.executeUpdate("update account set bal=bal+500 where accno=1");
			// 前回のコミット/ロールバック以降のすべての変更を永続化し、この Connection オブジェクトが現在保持しているデータベースロックをすべて解放する
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
				// 現在のトランザクションで行われたすべての変更を取り消し、この Connection オブジェクトによって現在保持されているすべてのデータベース ロックを解放する
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}
}
