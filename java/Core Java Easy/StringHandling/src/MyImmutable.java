
public class MyImmutable {

	int x;

	public MyImmutable(int x) {
		this.x = x;
	}

	public MyImmutable change(int x) {
		if(this.x == x) {
			return this;
		} else {
			return new MyImmutable(x);
		}
	}

	public static void main(String[] args) {
		MyImmutable m1 = new MyImmutable(10);
		MyImmutable m2 = m1.change(10);
		//値を変更しなければ、ストリングプールの同じメモリ位置が共有される
		System.out.println(m1 == m2);
		MyImmutable m3 = m1.change(20);
		//値を変更すると、メモリ上に新しい値が作成され、新しいメモリ位置が割り当てられる
		System.out.println(m1 == m3);
	}

}
