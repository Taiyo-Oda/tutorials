
public class ObjectAndString {

	public static void main(String[] args) {
		long x = 1000;
		//プリミティブ型　→　ラッパー型
		Long y = Long.valueOf(x);
		//ラッパー型　→　文字列型
		String s = y.toString();
		//文字列型　→　ラッパー型
		Long z = Long.valueOf(s);
		
	}

}
