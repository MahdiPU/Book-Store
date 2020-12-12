import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AddCustomer {

	private JFrame frmNewCustomer;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void NewScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer window = new AddCustomer();
					window.frmNewCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddCustomer() {
		initialize();
		frmNewCustomer.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmNewCustomer.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewCustomer = new JFrame();
		frmNewCustomer.setTitle("New Customer");
		frmNewCustomer.getContentPane().setBackground(Color.GRAY);
		frmNewCustomer.setBounds(100, 100, 450, 259);
		frmNewCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewCustomer.getContentPane().setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCustomerName.setBounds(13, 48, 129, 23);
		frmNewCustomer.getContentPane().add(lblCustomerName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(13, 126, 129, 23);
		frmNewCustomer.getContentPane().add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(149, 46, 173, 28);
		frmNewCustomer.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 125, 173, 28);
		frmNewCustomer.getContentPane().add(textField_1);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(335, 176, 89, 33);
		frmNewCustomer.getContentPane().add(btnSave);
	}

}
