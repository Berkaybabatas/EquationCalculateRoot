package ECR;

public class Main {

	public static void main(String[] args) {
		// Window Settings
		EquationCalculateRoot ecr = new EquationCalculateRoot();
		WindowButton wb = new WindowButton();
		ecr.addWindowListener(wb);
		ecr.setSize(1000, 250);
		ecr.setVisible(true);

	}

}
