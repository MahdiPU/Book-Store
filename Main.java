import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Main {
	private JFrame frmBookStoreSystem;
	private JTextField FindItemTxtField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private Connection con;
	private PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmBookStoreSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {

		frmBookStoreSystem = new JFrame();
		frmBookStoreSystem.getContentPane().setBackground(Color.WHITE);
		frmBookStoreSystem.getContentPane().setLayout(null);
		Connect();
		JButton btnNewButton = new JButton("New Item");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItem nw = new AddItem();
				nw.NewScreen();

			}
		});

		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer nw = new AddCustomer();
				nw.NewScreen1();
			}
		});
		btnNewCustomer.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewCustomer.setBackground(Color.LIGHT_GRAY);
		btnNewCustomer.setBounds(1158, 144, 145, 33);
		frmBookStoreSystem.getContentPane().add(btnNewCustomer);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 19));
		textField_1.setColumns(10);
		textField_1.setBounds(946, 144, 202, 33);
		frmBookStoreSystem.getContentPane().add(textField_1);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(612, 148, 118, 33);
		frmBookStoreSystem.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Find Item : ");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(302, 148, 118, 33);
		frmBookStoreSystem.getContentPane().add(lblNewLabel);

		JLabel lblFindCustomer = new JLabel("Find Customer :");
		lblFindCustomer.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblFindCustomer.setBounds(806, 143, 145, 33);
		frmBookStoreSystem.getContentPane().add(lblFindCustomer);

		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setForeground(new Color(255, 255, 255));
		lblLibraryManagementSystem.setBackground(Color.GRAY);
		lblLibraryManagementSystem.setFont(new Font("Arial", Font.BOLD, 45));
		lblLibraryManagementSystem.setBounds(467, 42, 710, 49);
		frmBookStoreSystem.getContentPane().add(lblLibraryManagementSystem);

		JButton btnNewButton_2 = new JButton("Pending Items");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_2.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnNewButton_2.setBackground(Color.DARK_GRAY);
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(0, 301, 268, 72);
		frmBookStoreSystem.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("Purchase Invoice");
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_4.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnNewButton_4.setBackground(Color.DARK_GRAY);
			}
		});
		btnNewButton_4.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setBounds(0, 371, 268, 82);
		frmBookStoreSystem.getContentPane().add(btnNewButton_4);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 268, 782);
		frmBookStoreSystem.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Quick Sales");
		btnNewButton_1.setBounds(0, 220, 268, 82);
		panel.add(btnNewButton_1);

		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_1.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnNewButton_1.setBackground(Color.DARK_GRAY);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(Color.DARK_GRAY);

		JButton btnNewButton_3 = new JButton("Sales Report");
		btnNewButton_3.setBounds(0, 451, 268, 82);
		panel.add(btnNewButton_3);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_3.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnNewButton_3.setBackground(Color.DARK_GRAY);
			}
		});
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(Color.DARK_GRAY);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(267, 0, 1103, 223);
		frmBookStoreSystem.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(130, 148, 202, 33);

		comboBox.setUI(new BasicComboBoxUI() {
			protected JButton createArrowButton() {
				return new JButton() {
					public int getWidth() {
						return 0;
					}
				};
			}
		});

		FindItemTxtField = new JTextField();
		FindItemTxtField.setBounds(130, 148, 202, 33);
		panel_1.add(FindItemTxtField);
		panel_1.add(comboBox);
		/*Component[] comps = comboBox.getComponents();
		for (int i = 0; i < comps.length; i++) {
			comps[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					FindItemTxtField.setText((String) comboBox.getSelectedItem());
					displayItem((FindItemTxtField.getText()));
				}
			});
		}*/
		FindItemTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				comboBox.removeAllItems();
				String s = FindItemTxtField.getText();
				if(key.getKeyChar() > 31 && key.getKeyChar() < 112) {//make sure that the typed char is not backspace or escape or etc.
				s = FindItemTxtField.getText()+key.getKeyChar();	
				}//key.getKeyChar() is added since The related document for the text field has not been updated at the time the keyTyped event is generated.
				if (s.length() > 2) {
					try {
						pst = con.prepareStatement("select Item_Name from item where Item_Name like ? or Barcode = ?");
						pst.setString(1, "%" + s + "%");
						pst.setString(2, s);
						ResultSet result = pst.executeQuery();
						while (result.next()) {
							comboBox.addItem(result.getString("Item_Name"));
						}
						comboBox.setPopupVisible(comboBox.getSelectedIndex() != -1);
					} catch (SQLException e) {
					}
				} else {
					comboBox.hidePopup();
				}
			}

			int index = 0;

			public void keyPressed(KeyEvent key) {
				comboBox.setPopupVisible(comboBox.getSelectedIndex() != -1);
				if (index >= comboBox.getItemCount())
					index = 0;
				if (key.getKeyCode() == KeyEvent.VK_DOWN && index < comboBox.getItemCount() - 1) {
					comboBox.setSelectedIndex(++index);
					FindItemTxtField.setText((String) comboBox.getSelectedItem());
				} else if (key.getKeyCode() == KeyEvent.VK_UP && index > 0) {
					comboBox.setSelectedIndex(--index);
					FindItemTxtField.setText((String) comboBox.getSelectedItem());
				} else if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					comboBox.hidePopup();
					String s = FindItemTxtField.getText();
					displayItem(s);
				}

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 279, 814, 389);
		frmBookStoreSystem.getContentPane().add(scrollPane);

		table_2 = new JTable();
		scrollPane.setViewportView(table_2);

		table_2.setRowSelectionAllowed(false);
		table_2.setFont(new Font("Arial", Font.PLAIN, 16));
		table_2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Barcode", "Item Name", "Price", "Qnt", "Sale", "Total" }));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(178);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(415);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(15);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(50);
		table_2.setRowHeight(30);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "Receipts" }));
		table_3.setBounds(1352, 481, -90, -241);
		frmBookStoreSystem.getContentPane().add(table_3);

		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(1003, 249, 27, 23);
		frmBookStoreSystem.getContentPane().add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBackground(Color.WHITE);
		checkBox_1.setBounds(1038, 249, 27, 23);
		frmBookStoreSystem.getContentPane().add(checkBox_1);

		JTextArea txtrStopAt = new JTextArea();
		txtrStopAt.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrStopAt.setText("Stop on:");
		txtrStopAt.setBounds(947, 252, 54, 18);
		frmBookStoreSystem.getContentPane().add(txtrStopAt);

		JTextArea txtrTotalPrice = new JTextArea();
		txtrTotalPrice.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtrTotalPrice.setText("Total:");
		txtrTotalPrice.setBounds(683, 679, 54, 33);
		frmBookStoreSystem.getContentPane().add(txtrTotalPrice);

		JTextArea txtrSub = new JTextArea();
		txtrSub.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrSub.setText("Subtotal:");
		txtrSub.setBounds(316, 681, 83, 33);
		frmBookStoreSystem.getContentPane().add(txtrSub);

		JTextArea txtrDiscount = new JTextArea();
		txtrDiscount.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrDiscount.setText("Discount:");
		txtrDiscount.setBounds(501, 681, 86, 33);
		frmBookStoreSystem.getContentPane().add(txtrDiscount);

		textField_2 = new JTextField();
		textField_2.setBounds(405, 683, 86, 20);
		frmBookStoreSystem.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(587, 683, 86, 20);
		frmBookStoreSystem.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(744, 683, 86, 20);
		frmBookStoreSystem.getContentPane().add(textField_4);

		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(1050, 682, 89, 23);
		frmBookStoreSystem.getContentPane().add(btnPrint);

		frmBookStoreSystem.setBackground(Color.WHITE);
		frmBookStoreSystem.setBounds(100, 100, 1405, 811);
		frmBookStoreSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void displayItem(String ItemNameOrBarcode) {
		if (ItemNameOrBarcode != null) {
			try {
				pst = con.prepareStatement("select * from item where Item_Name = ? or Barcode = ?");
				pst.setString(1, ItemNameOrBarcode);
				pst.setString(2, ItemNameOrBarcode);
				ResultSet result = pst.executeQuery();

				if (result.next()) {
					AddItem n = new AddItem();
					n.btnNewButton.setVisible(false);
					n.txtBarcode.setText(result.getString("Barcode"));
					n.txtItemName.setText(result.getString("Item_Name"));
					n.txtItemPrice.setText(result.getString("Price"));
					n.txtQty.setText(result.getString("Qty"));
					n.txtBarcode.setEditable(false);
					n.txtItemName.setEditable(false);
					n.txtItemPrice.setEditable(false);
					n.txtQty.setEditable(false);
					n.NewScreen();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?" + "user=root&password=123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
