// 異なるデータ型を取ることができるGenericクラス
public class MyGenericClass<T> {
	
	// Generic型のフィールドを定義する
	T obj;
	
	MyGenericClass(T obj) {
		this.obj = obj;
	}
	
	public void displayObjectDetails() {
		System.out.println("The type of object: " + obj.getClass().getName());
	}
	
	public T getObject() {
		return obj;
	}

}
