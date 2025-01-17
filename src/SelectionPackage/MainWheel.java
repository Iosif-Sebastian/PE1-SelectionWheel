package SelectionPackage;

import javax.swing.*;
import java.util.*;

/**
 * The MainWheel class serves as the entry point for the Selection application.
 * It manages the initialization and execution of the main program logic.
 * <p>This class demonstrates core functionalities, including wheel selection
 *  and user interaction processing.</p>
 */
public class MainWheel {

	// Class-level variables for labels
	private static JLabel lblSelection;
	private static JLabel lblAngle;
	private static JLabel lblSpeed;

	/**
	 * The main method is the starting point of the SelectionWheel application.
	 * It orchestrates the setup, execution, and display of the selected wheel.
	 */
	public static void main(String[] args) {

		int width = 1000, height = 1000;

		// Initialize frame and wheel
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<String> list = importListOfItems();
		SelectionWheel wheel = new SelectionWheel(list);
		wheel.hasBorders(true);
		wheel.setBounds(10, 10, 700, 700);

		// Initialize the main window with labels
		initMainWindow(frame, wheel, width, height);

		// Update the initial values of the labels
		updateLabels(wheel);

		// Main loop to keep updating values while wheel is spinning
		while (true) {
			// Wait for action to start spinning
			waitForSpinning(wheel);

			// Update labels while the wheel is spinning
			while (wheel.isSpinning()) {
				updateLabels(wheel);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// Update final speed label
			lblSpeed.setText(Double.toString(wheel.getSpinSpeed()));
			// Show the final selection in a dialog box
			JOptionPane.showMessageDialog(frame, "Selection: " + wheel.getSelectedString());
		}
	}

	// Initializes the main window with labels and sets the frame visible
	private static void initMainWindow(JFrame frame, SelectionWheel wheel, int width, int height) {
		JLabel lbl1 = new JLabel("Selection: ");
		JLabel lbl2 = new JLabel("Angle: ");
		JLabel lbl3 = new JLabel("Speed: ");

		lblSelection = new JLabel("(selection)");
		lblAngle = new JLabel("(angle)");
		lblSpeed = new JLabel("(speed)");

		lbl1.setBounds(720, 10, 100, 20);
		lblSelection.setBounds(830, 10, 150, 20);
		lbl2.setBounds(720, 30, 100, 20);
		lblAngle.setBounds(830, 30, 150, 20);
		lbl3.setBounds(720, 50, 100, 20);
		lblSpeed.setBounds(830, 50, 150, 20);

		frame.add(wheel);
		frame.add(lbl1);
		frame.add(lblSelection);
		frame.add(lbl2);
		frame.add(lblAngle);
		frame.add(lbl3);
		frame.add(lblSpeed);

		frame.setSize(width, height);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	// Updates the labels with current wheel data
	private static void updateLabels(SelectionWheel wheel) {
		lblSelection.setText(wheel.getSelectedString());
		lblAngle.setText(Double.toString(wheel.getRotationAngle()));
		lblSpeed.setText(Double.toString(wheel.getSpinSpeed()));
	}

	// Waits for the spinning action to begin
	private static void waitForSpinning(SelectionWheel wheel) {
		while (true) {
			updateLabels(wheel);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (wheel.isSpinning()) break;
		}
	}

	private static ArrayList<String> importListOfItems() {
		return getStrings();
	}

	private static ArrayList<String> getStrings() {
		return ContentReader.importListOfItems();
	}
}
