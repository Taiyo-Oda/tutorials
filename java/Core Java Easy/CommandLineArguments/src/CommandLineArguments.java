
public class CommandLineArguments {

	public static void main(String[] args) {
		//配列の長さを取得する
		int length = args.length;
		if (length == 0) {
			System.out.println("No Inputs Provided");
		} else {
			System.out.println("list Of Arguments");
			for (int i=0; i<length; i++) {
				System.out.println(args[i]);
			}
		}
	}

}
