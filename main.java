import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("Laundry Assistant Room Cleaning Calculator");
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null); // center the window on the screen

		JTabbedPane tabbedPane = new JTabbedPane();

		// Tab 1
		JPanel panel1 = new JPanel(new GridLayout(4, 2, 10, 10));

		JLabel label1 = new JLabel("Enter total rooms to be cleaned:");
		label1.setFont(new Font("Arial", Font.BOLD, 14));

		final JTextField textField1 = new JTextField();
		textField1.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton button1 = new JButton("Calculate");
		button1.setFont(new Font("Arial", Font.BOLD, 14));

		final JLabel resultLabel1 = new JLabel();
		resultLabel1.setFont(new Font("Arial", Font.BOLD, 14));

		panel1.add(label1);
		panel1.add(textField1);
		panel1.add(button1);
		panel1.add(resultLabel1);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalRooms = Integer.parseInt(textField1.getText());
					float hours = totalRooms / 8.0f;
					int rooms = 0;
					if (hours <= 7) {
						rooms = (int) ((7 - hours) * 2);
					}
					resultLabel1.setText("Rooms the laundry assistant can clean: " + rooms);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
				}
			}
		});

		// Tab 2
		JPanel panel2 = new JPanel(new GridLayout(4, 2, 10, 10));

		JLabel label2 = new JLabel("Enter total rooms:");
		label2.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel label3 = new JLabel("Enter total number of maids:");
		label3.setFont(new Font("Arial", Font.BOLD, 14));

		final JTextField textField2 = new JTextField();
		textField2.setFont(new Font("Arial", Font.PLAIN, 14));

		final JTextField textField3 = new JTextField();
		textField3.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton button2 = new JButton("Calculate");
		button2.setFont(new Font("Arial", Font.BOLD, 14));

		final JLabel resultLabel2 = new JLabel();
		resultLabel2.setFont(new Font("Arial", Font.BOLD, 14));

		panel2.add(label2);
		panel2.add(textField2);
		panel2.add(label3);
		panel2.add(textField3);
		panel2.add(button2);
		panel2.add(resultLabel2);

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalRooms = Integer.parseInt(textField2.getText());
					int totalMaids = Integer.parseInt(textField3.getText());
					int roomsPerMaid = calculateRoomsPerMaid(totalRooms, totalMaids);
					resultLabel2.setText("Rooms each maid can clean: " + roomsPerMaid);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
				}
			}
		});

		tabbedPane.addTab("Laundry Assistant", panel1);
		tabbedPane.addTab("Room Distribution", panel2);

		frame.add(tabbedPane);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private static int calculateRoomsPerMaid(int totalRooms, int totalMaids) {
		return totalRooms / totalMaids;
	}
}
