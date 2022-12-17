package abstractionIssue;

//抽象クラスを継承
public class DELLNotebook extends DELL{
	
	//抽象クラスのインスタンスは作成できない。
	//継承したメソッドのオーバーライドは可能
	@Override
	public void click() {
		System.out.println("Inside DELLNotebook click");
	}

}
