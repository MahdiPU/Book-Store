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
import javax.swing.JTextField;

public class AddItem {
	private JFrame frmNewItem;
	private JTextField txtBarcode;
	private JTextField txtItemName;
	private JTextField txtItemPrice;
	private JTextField txtQty;

	/**
	 * Launch the application.
	 */
	public  static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem window = new AddItem();
					window.frmNewItem.setVisible(true);
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
		Connect();
		frmNewItem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmNewItem.dispose();
		
	}
	 Connection con;
	 PreparedStatement pst;
	
	public void Connect(){
		try {
			System.out.println("3");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?" + "user=root&password=123");
			System.out.println("4");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block 
			System.out.println("1");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("2");
			e.printStackTrace();
		}
	}

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
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 45, 78, 23);
		frmNewItem.getContentPane().add(lblNewLabel);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(125, 44, 298, 28);
		frmNewItem.getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setFont(new Font("Arial", Font.PLAIN, 16));
		lblItemName.setBounds(10, 92, 107, 23);
		frmNewItem.getContentPane().add(lblItemName);
		
		JLabel lblItemPrice = new JLabel("Item Price :");
		lblItemPrice.setFont(new Font("Arial", Font.PLAIN, 16));
		lblItemPrice.setBounds(10, 141, 78, 23);
		frmNewItem.getContentPane().add(lblItemPrice);
		
		JLabel lblQuantity = new JLabel("Qty in Stock :");
		lblQuantity.setFont(new Font("Arial", Font.PLAIN, 16));
		lblQuantity.setBounds(10, 191, 107, 23);
		frmNewItem.getContentPane().add(lblQuantity);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String barcode = txtBarcode.getText();
				String item_Name = txtItemName.getText();
				Double price = Double.parseDouble(txtItemPrice.getText());
				Integer quantity = Integer.parseInt(txtQty.getText()); 
				
				try {
					System.out.println("hello");
					pst = con.prepareStatement("insert into item(Barcode,Item_Name,Price,Qty)values(?,?,?,?)");
					pst.setString(1, barcode);
					pst.setString(2, item_Name);
					pst.setDouble(3, price);
					pst.setInt(4, quantity);
					int k = pst.executeUpdate();
					System.out.println(k);
	
					
				} catch (SQLException e) {
					System.out.println("no");
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(309, 230, 90, 37);
		frmNewItem.getContentPane().add(btnNewButton);
		
		txtItemName = new JTextField();
		txtItemName.setColumns(10);
		txtItemName.setBounds(125, 91, 297, 28);
		frmNewItem.getContentPane().add(txtItemName);
		
		txtItemPrice = new JTextField();
		txtItemPrice.setColumns(10);
		txtItemPrice.setBounds(125, 140, 118, 28);
		frmNewItem.getContentPane().add(txtItemPrice);
		
		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(126, 190, 117, 28);
		frmNewItem.getContentPane().add(txtQty);
	}
}
