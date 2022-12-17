
public class CompileTimeBinding {
	
	
	void add(int a, int b){
		int result = a + b;
		System.out.println("Result is " + result);
	}
	
	void add(int a, int b, int c){
		int result = a + b + c;
		System.out.println("Result is " + result);
	}
	
	void add(float a, float b){
		float result = a + b;
		System.out.println("Result is " + result);
	}
	
	public static void main(String[] args) {
		CompileTimeBinding c = new CompileTimeBinding();
		c.add(10, 20);
		c.add(30, 40, 50);
		c.add(60f, 70f);
		
		/*
		 * Result is 30
		 * Result is 120
		 * Result is 130.0
		 * 
		 * パラメータの種類に応じて、適切なメソッドを呼び出す。
		 * Static binding(コンパイル時ポリモーフィズム)
		 */
	}

}
