package p2;

//p1パッケージのAクラスをインポート
import p1.A;

//importしたAclassを継承
public class C extends A{
	
	public static void main(String[] args) {
		A aObject = new A();
		//public
		System.out.println(aObject.d);
		
		C cObject = new C();
		//protected
		System.out.println(cObject.c);
		//public
		System.out.println(cObject.d);
	}

}
