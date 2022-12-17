
public class FlowControl {

	public static void main(String[] args) {
		
		//while loop
		int x = 100;
		int y = 0;
		while(y<=x) {
			if (y == 99) {
				break;
			} else if (y%10 == 9) {
				y += 2;
			} else {
				y++;
			}
			System.out.println(y);
		}
		
		//dowhile loop
		int z = 0;
		do {
			z++;
			if (z%10 == 0) {
				continue;
			}
			System.out.println(z);
		} while (z<=98);
		
		//for loop
		for (int i = 0; i <= 99; i++) {
			if (i%10 == 0) {
				continue;
			}
			System.out.println(i);
		}
		
		/*
		for(int i = 20; i >= 1; i--) {
			
			boolean primeFlag = true;
			
			if(i%2==0) {
				primeFlag = false;
			}
			if(primeFlag) {
				System.out.println("Prime No");
			} else {
				System.out.println("Not a Prime No");
			}
		}
		*/
	}

}
