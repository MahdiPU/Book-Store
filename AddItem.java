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

public class AddItem {
	private JFrame frmNewItem;
	protected JTextField txtBarcode;
	protected JTextField txtItemName;
	protected JTextField txtItemPrice;
	protected JTextField txtQty;
	protected JButton btnNewButton; 

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNewItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddItem() {
		initialize();
	
		frmNewItem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmNewItem.dispose();

	}


	PreparedStatement pst;

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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

		btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(309, 230, 90, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String barcode = txtBarcode.getText();
				String item_Name = txtItemName.getText();
				Double price = Double.parseDouble(txtItemPrice.getText());
				Integer quantity = Integer.parseInt(txtQty.getText());

				try {
					pst = DBC.getConnection().prepareStatement("insert into item(Barcode,Item_Name,Price,Qty)values(?,?,?,?)");
					pst.setString(1, barcode);
					pst.setString(2, item_Name);
					pst.setDouble(3, price);
					pst.setInt(4, quantity);
					pst.executeUpdate();
					DBC.disConnect();
					
				} catch (SQLException e) {
					 	
					JOptionPane.showMessageDialog(null, "Barcode or Item Name already exist");
					
				}

			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		frmNewItem.getContentPane().add(btnNewButton);

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
