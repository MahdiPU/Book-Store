import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ItemWindow {
	protected JFrame frmNewItem;
	protected JTextField txtBarcode;
	protected JTextField txtItemName;
	protected JTextField txtItemPrice;
	protected JTextField txtQty;

	/**
	 * Launch the application.
	 */

	protected ItemWindow() {
		Initialize();
		frmNewItem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmNewItem.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void Initialize() {
		frmNewItem = new JFrame();
		frmNewItem.getContentPane().setBackground(Color.GRAY);
		frmNewItem.setTitle("New Item");
		frmNewItem.setBounds(100, 100, 449, 317);
		frmNewItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewItem.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Barcode :");
		lblNewLabel.setBounds(10, 45, 78, 23);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		frmNewItem.getContentPane().add(lblNewLabel);

		txtBarcode = new JTextField();
		txtBarcode.setBounds(125, 44, 298, 28);
		frmNewItem.getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setBounds(10, 92, 107, 23);
		lblItemName.setFont(new Font("Arial", Font.PLAIN, 16));
		frmNewItem.getContentPane().add(lblItemName);

		JLabel lblItemPrice = new JLabel("Item Price :");
		lblItemPrice.setBounds(10, 141, 78, 23);
		lblItemPrice.setFont(new Font("Arial", Font.PLAIN, 16));
		frmNewItem.getContentPane().add(lblItemPrice);

		JLabel lblQuantity = new JLabel("Qty in Stock :");
		lblQuantity.setBounds(10, 191, 107, 23);
		lblQuantity.setFont(new Font("Arial", Font.PLAIN, 16));
		frmNewItem.getContentPane().add(lblQuantity);

		txtItemName = new JTextField();
		txtItemName.setBounds(125, 91, 297, 28);
		txtItemName.setColumns(10);
		frmNewItem.getContentPane().add(txtItemName);

		txtItemPrice = new JTextField();
		txtItemPrice.setBounds(125, 140, 118, 28);
		txtItemPrice.setColumns(10);
		frmNewItem.getContentPane().add(txtItemPrice);

		txtQty = new JTextField();
		txtQty.setBounds(126, 190, 117, 28);
		txtQty.setColumns(10);
		frmNewItem.getContentPane().add(txtQty);

	}
}
