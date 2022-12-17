package abstractionIssue;

public abstract class HP implements TouchScreenLapTop {

	@Override
	public void scroll() {
		System.out.println("Inside HP Scroll");
	}

}
