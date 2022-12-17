import java.util.ArrayList;
import java.util.List;

public class B {
	
	// 引数に指定した警告を非表示にする
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args) {
		A a = new A();
		
		System.out.println(a);
		a.myMethod();
		a.myMethod2();
		
		List list = new ArrayList();
		System.out.println(list);
	}
	
}
