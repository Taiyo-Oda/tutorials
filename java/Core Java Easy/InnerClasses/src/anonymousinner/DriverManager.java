package anonymousinner;

public class DriverManager {
	
	static Connection getConnection() {
		//匿名の内部クラス
		Connection con = new Connection() {
			@Override
			public void createStatement() {
				System.out.println("Anonymous Inner classes method");
			}
		};
		
		return con;
	}

}
