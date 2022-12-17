package customExceptions;

public class Test {

	public static void main(String[] args) throws CheckedCustomException {
		//throw new UnCheckedCustomException("Business Expantion acccured");
		throw new CheckedCustomException("Business Expantion acccured");
	}

}
