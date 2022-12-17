
public class SingleInheritance {
	
	void m1() {
		System.out.println("Inside m1");
	}
	
	public static void main(String[] args) {
		SingleInheritance s = new SingleInheritance();
		
		s.m1();
		//スーパークラスを暗黙のうちに継承しているので、定義していないオプフェクトを使用できる
		s.hashCode();
		s.getClass();
	}

}
