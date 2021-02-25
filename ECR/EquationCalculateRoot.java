package ECR;

import java.awt.*;
import java.awt.event.*;

class EquationCalculateRoot extends Frame implements ActionListener {
	// ax^2 + bx + c Equation
	// Labels
	Label A = new Label("a:");
	Label B = new Label("b:");
	Label C = new Label("c:");

	// TextFields
	TextField aValue = new TextField(10);
	TextField bValue = new TextField(10);
	TextField cValue = new TextField(10);
	TextField lastPrint = new TextField(20);
	TextField lastDet = new TextField(20);

	Button calculate = new Button("Calculate");

	EquationCalculateRoot() {
		super("Equation Calculate Root"); // Window Name
		setLayout(new GridLayout(4, 4, 10, 10)); // Layout

		// TextField Settings
		lastPrint.setEditable(false);
		lastDet.setEditable(false);
		lastPrint.setText("Result:");
		lastDet.setText("Delta:");

		// Adding Component
		add(A);
		add(B);
		add(C);
		add(aValue);
		add(bValue);
		add(cValue);
		add(calculate);
		add(lastDet);
		add(lastPrint);

		calculate.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		double Atemp = 0, Btemp = 0, Ctemp = 0, Delta; // Temporary Equation Values
		double rootOne, rootTwo; // Equation Root
		String text;

		text = aValue.getText();
		Atemp = Double.parseDouble(text);
		text = bValue.getText();
		Btemp = Double.parseDouble(text);
		text = cValue.getText();
		Ctemp = Double.parseDouble(text);

		// Diskriminant Calculation
		Delta = Math.pow(Btemp, 2) - 4 * Atemp * Ctemp;
		String deltaText = "Delta: " + Double.toString(Delta);
		if (Delta > 0) {
			rootOne = ((-1 * Btemp) - Math.sqrt(Delta)) / (2 * Atemp);
			rootTwo = ((-1 * Btemp) + Math.sqrt(Delta)) / (2 * Atemp);
			text = "X1= " + Double.toString(rootOne) + " X2= " + Double.toString(rootTwo);
		}
		if (Delta < 0) {
			text = "No Real Root Found";
		}
		if (Delta == 0) {
			rootOne = (-1 * Btemp) / (2 * Atemp);
			text = "X1= " + Double.toString(rootOne);
		}
		lastDet.setText(deltaText);
		lastPrint.setText(text);
		repaint();
	}

}
// Window Control Buttons
class WindowButton extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
