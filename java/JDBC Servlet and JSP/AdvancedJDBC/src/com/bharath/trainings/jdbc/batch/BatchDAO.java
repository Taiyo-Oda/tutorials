package com.bharath.trainings.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "taiyou03");
				Statement stmt = con.createStatement();) {
			// 指定されたSQLコマンドを、このStatementオブジェクトの現在のコマンドリストに追加する
			// このリストのコマンドは、executeBatch メソッドを呼び出すことにより、バッチとして実行することができる
			stmt.addBatch("insert into account values(1,'clinton','bill',10000)");
			stmt.addBatch("insert into account values(2,'clinton','hillary',20000)");
			// コマンドのバッチをデータベースに送信して実行させ、すべてのコマンドが正常に実行された場合、更新回数の配列を返す
			int[] result = stmt.executeBatch();

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
