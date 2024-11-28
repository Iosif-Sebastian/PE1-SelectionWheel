package SelectionPackage;

import javax.swing.*;
import java.util.*;

/**
 * The MainWhell class serves as the entry point for the Selection application.
 * It manages the initialization and execution of the main program logic
 * <p>This class demonstrates core functionalities, including wheel selection
 *  and user interaction processing.</p>
 */
public class MainWheel {
	/**
	 * The main method is the starting point of the SelectionWheel application
	 * It orchestrates the setup, execution, and display of the selected wheel.
	 */
	public static void main(String[] args) throws Exception {
		
		int width = 1000, height = 1000;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Avatar");
		list.add("The Lord of the Rings: The Return of the King");
		list.add("Pirates of the Caribbean: Dead Man's Chest");
		list.add("The Dark Knight");
		list.add("Harry Potter and the Philosopher's Stone");
		list.add("Pirates of the Caribbean: At World's End");
		list.add("Harry Potter and the Order of the Phoenix");
		list.add("Harry Potter and the Half-Blood Prince");
		list.add("The Lord of the Rings: The Two Towers");
		list.add("Shrek 2");
		list.add("Harry Potter and the Goblet of Fire");
		list.add("Spider-Man 3");
		list.add("Ice Age: Dawn of the Dinosaurs");
		list.add("Harry Potter and the Chamber of Secrets");
		list.add("The Lord of the Rings: The Fellowship of the Ring");
		list.add("Finding Nemo");
		list.add("Star Wars: Episode III - Revenge of the Sith");
		list.add("Transformers: Revenge of the Fallen");
		list.add("Spider-Man");
		list.add("Shrek the Third");
		
		SelectionWheel wheel = new SelectionWheel(list);
		wheel.hasBorders(true);
		wheel.setBounds(10, 10, 700, 700);
		
		JLabel lbl1 = new JLabel("Selection: ");
		JLabel lbl2 = new JLabel("Angle: ");
		JLabel lbl3 = new JLabel("Speed: ");
		JLabel lblsel = new JLabel("(selection)");
		JLabel lblang = new JLabel("(angle)");
		JLabel lblsp = new JLabel("(speed)");
		lbl1.setBounds(720, 10, 100, 20);
		lblsel.setBounds(830, 10, 150, 20);
		lbl2.setBounds(720, 30, 100, 20);
		lblang.setBounds(830, 30, 150, 20);
		lbl3.setBounds(720, 50, 100, 20);
		lblsp.setBounds(830, 50, 150, 20);
		frame.add(wheel);
		frame.add(lbl1);
		frame.add(lblsel);
		frame.add(lbl2);
		frame.add(lblang);
		frame.add(lbl3);
		frame.add(lblsp);
		frame.setSize(width, height);
		frame.setLayout(null);
		frame.setVisible(true);
		
		lblsel.setText(wheel.getSelectedString());
		lblang.setText(Double.toString(wheel.getRotationAngle()));
		lblsp.setText(Double.toString(wheel.getSpinSpeed()));
		
		//wheel.setShape(Wheel.Shape.UMBRELLA);
		// This line sets the Shape of wheel object to "UMBRELLA"
		
		while(true) {
			// wait for action to start spinning
			while(true)
			{
				lblsel.setText(wheel.getSelectedString());
				lblang.setText(Double.toString(wheel.getRotationAngle()));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(wheel.isSpinning())
					break;
			}
			// Update labels while the wheel is spinning
			while(wheel.isSpinning())
			{
				lblsel.setText(wheel.getSelectedString());
				lblang.setText(Double.toString(wheel.getRotationAngle()));
				lblsp.setText(Double.toString(wheel.getSpinSpeed()));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lblsp.setText(Double.toString(wheel.getSpinSpeed()));
			// shows the final selection in a dialog box
			JOptionPane.showMessageDialog(frame, "Selection: " + wheel.getSelectedString());
		}
	}
}