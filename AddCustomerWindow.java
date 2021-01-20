import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AddCustomerWindow {

	private JFrame frmNewCustomer;
	private JTextField txtCustomerName;
	private JTextField txtPhoneNumber;

	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerWindow window = new AddCustomerWindow();
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
	public AddCustomerWindow() {
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

		txtCustomerName = new JTextField();
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(149, 46, 173, 28);
		frmNewCustomer.getContentPane().add(txtCustomerName);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(152, 125, 173, 28);
		frmNewCustomer.getContentPane().add(txtPhoneNumber);

		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(335, 176, 89, 33);
		frmNewCustomer.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				
				String customerName = txtCustomerName.getText();
				String phoneNumber = txtPhoneNumber.getText();
				
				Customer customer = new Customer(customerName, phoneNumber);
				CustomerDaoImpl dao = new CustomerDaoImpl();
				try {
					dao.save(customer);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Customer Already Exist");
					e.printStackTrace();
				}

			}
		});
	}

}
