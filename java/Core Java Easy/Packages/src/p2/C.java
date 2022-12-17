package p2;

//異なるパッケージのクラスを使用するにはimportする必要がある
import p1.A;

public class C {
	
	public static void main(String[] args) {
		
		A.a1();
		
		A aObject = new A();
		aObject.a2();
		
	}

}
