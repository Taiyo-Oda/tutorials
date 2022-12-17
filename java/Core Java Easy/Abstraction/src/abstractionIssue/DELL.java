package abstractionIssue;
//抽象クラス
public abstract class DELL implements TouchScreenLapTop {

	//抽象クラスでは実装を持つことができる
	@Override
	public void scroll() {
		System.out.println("Inside Dell Scroll");
	}
	
}
