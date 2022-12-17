import java.util.ArrayList;

public class WildcardParams {

	public static void main(String[] args) {
		WildcardParams wcp = new WildcardParams();
		wcp.myMethod(new ArrayList<A>());
	}

	// wildcardはGenericに?を指定する
	public void myMethod(ArrayList<? super B> l) {
		// wildcardで?のみを使用した場合、null値のみが許容される
		l.add(null);
		//l.add(new MyClass());
		l.add(new B());
	}
}
