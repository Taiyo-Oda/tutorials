
public class LabelledBlock {

	public static void main(String[] args) {
		int x = 20;
		
		//ラベル付きブロック
		li : {
			System.out.println("Block Bigins");
			
			if(x == 20) {
				break li;
			}
			System.out.println("Block Ends");
		}
		System.out.println("Outside the Block");
	}

}
