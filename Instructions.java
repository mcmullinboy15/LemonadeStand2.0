package lemonadeStand;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Component;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * 
 * @author Cory Britton
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class Instructions extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static Instructions dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new Instructions();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the instruction dialog panel.
	 */
	public Instructions() {
		setBounds(300, 300, 550, 350);
		setTitle("Lemonade Stand Instructions");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPanel.setBackground(UIManager.getColor("List.background"));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JTextArea txtInstructions = createInstructionWindow();
			contentPanel.add(txtInstructions);
		}

		JPanel buttonPane = createButtonPane();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	private JPanel createButtonPane() {
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(255, 255, 204));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		{
			JButton okButton = new JButton("PLAY");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		return buttonPane;
	}

	private JTextArea createInstructionWindow() {
		JTextArea txtInstructions = new JTextArea();
		txtInstructions.setEditable(false);
		txtInstructions.setBackground(UIManager.getColor("List.background"));
		txtInstructions.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		txtInstructions.setText("We will give you $10 to start with.\nEach cup of lemonade costs $1.00 to make.\n"
				+ "Each cup will sell for $2.00.\n\nThe kicker is you never know how many people will\n"
				+ "show up to buy your delicious beverage.\n\nAlso, for each person that shows up that you can't provide a\n"
				+ "glass of lemonade, you will need to reimburse them $1.00 for\nwaiting in this crazy heat.\n\n"
				+ "Watch out for an incoming storm and keep an eye out for\nthose bullys!");
		return txtInstructions;
	}

}
