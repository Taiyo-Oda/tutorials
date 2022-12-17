
public class ArraysDemo {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		
		arr[0] = 10;
		arr[1] = new Integer(20);
		arr[2] = 30;
		
		System.out.println("Elements of the array : ");
		for(int element : arr) {
			System.out.println(element);
		}
	}

}
