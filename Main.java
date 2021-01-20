import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
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

import javax.swing.JComboBox;

public class Main {
	private JFrame frmBookStoreSystem;
	private JTextField FindItemTxtField;
	private JTextField FindCustomerTxtField;


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

	public Main() throws Exception {
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() throws Exception {

		frmBookStoreSystem = new JFrame();
		frmBookStoreSystem.getContentPane().setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 270, 764);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);

		JButton btnNewInvoice = new JButton("New Invoice");

		btnNewInvoice.setBounds(0, 223, 268, 82);
		panel.add(btnNewInvoice);

		btnNewInvoice.setBorderPainted(false);
		btnNewInvoice.setFocusPainted(false);
		btnNewInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewInvoice.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnNewInvoice.setBackground(Color.DARK_GRAY);
			}
		});
		btnNewInvoice.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnNewInvoice.setForeground(new Color(255, 255, 255));
		btnNewInvoice.setBackground(Color.DARK_GRAY);

		JButton btnPurchaseInvoice = new JButton("Purchase Invoice");
		btnPurchaseInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPurchaseInvoice.setBounds(0, 384, 268, 82);
		panel.add(btnPurchaseInvoice);
		btnPurchaseInvoice.setBorderPainted(false);
		btnPurchaseInvoice.setFocusPainted(false);
		btnPurchaseInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnPurchaseInvoice.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPurchaseInvoice.setBackground(Color.DARK_GRAY);
			}
		});
		btnPurchaseInvoice.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnPurchaseInvoice.setForeground(new Color(255, 255, 255));
		btnPurchaseInvoice.setBackground(Color.DARK_GRAY);

		JButton btnSalesReport = new JButton("Sales Report");
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalesReport.setBounds(0, 465, 268, 82);
		panel.add(btnSalesReport);
		btnSalesReport.setBorderPainted(false);
		btnSalesReport.setFocusPainted(false);
		btnSalesReport.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSalesReport.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSalesReport.setBackground(Color.DARK_GRAY);
			}
		});
		btnSalesReport.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnSalesReport.setForeground(new Color(255, 255, 255));
		btnSalesReport.setBackground(Color.DARK_GRAY);

		JButton btnPendingItems = new JButton("Pending Items");
		btnPendingItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPendingItems.setBounds(0, 304, 268, 82);
		panel.add(btnPendingItems);
		btnPendingItems.setBorderPainted(false);
		btnPendingItems.setFocusPainted(false);
		btnPendingItems.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnPendingItems.setBackground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPendingItems.setBackground(Color.DARK_GRAY);
			}
		});
		btnPendingItems.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnPendingItems.setForeground(new Color(255, 255, 255));
		btnPendingItems.setBackground(Color.DARK_GRAY);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(270, 0, 1115, 224);
		panel_1.setBackground(Color.GRAY);

		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setBounds(265, 48, 710, 49);
		lblLibraryManagementSystem.setForeground(new Color(255, 255, 255));
		lblLibraryManagementSystem.setBackground(Color.GRAY);
		lblLibraryManagementSystem.setFont(new Font("Arial", Font.BOLD, 40));

		/*
		 * JScrollPane scrollPane = new JScrollPane();
		 * scrollPane.setBackground(Color.WHITE); scrollPane.setBounds(316, 279, 814,
		 * 389);
		 * 
		 * table_2 = new JTable(); table_2.setGridColor(Color.WHITE);
		 * scrollPane.setViewportView(table_2);
		 * 
		 * table_2.setRowSelectionAllowed(false); table_2.setFont(new Font("Arial",
		 * Font.PLAIN, 16)); table_2.setModel(new DefaultTableModel( new Object[][] {
		 * {null, null, null, null, null, null}, {null, null, null, null, null, null},
		 * }, new String[] { "Barcode", "Item Name", "Price", "Qnt", "Sale", "Total" }
		 * )); table_2.getColumnModel().getColumn(0).setResizable(false);
		 * table_2.getColumnModel().getColumn(0).setPreferredWidth(178);
		 * table_2.getColumnModel().getColumn(1).setResizable(false);
		 * table_2.getColumnModel().getColumn(1).setPreferredWidth(415);
		 * table_2.getColumnModel().getColumn(2).setResizable(false);
		 * table_2.getColumnModel().getColumn(2).setPreferredWidth(50);
		 * table_2.getColumnModel().getColumn(3).setResizable(false);
		 * table_2.getColumnModel().getColumn(3).setPreferredWidth(15);
		 * table_2.getColumnModel().getColumn(4).setResizable(false);
		 * table_2.getColumnModel().getColumn(4).setPreferredWidth(25);
		 * table_2.getColumnModel().getColumn(5).setResizable(false);
		 * table_2.getColumnModel().getColumn(5).setPreferredWidth(50);
		 * table_2.setRowHeight(30);
		 */
		InvoiceTable table = new InvoiceTable();
		table.initTable(frmBookStoreSystem);
		table.initInvoicesTable(frmBookStoreSystem);
		btnNewInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.reInitTable(table.getInvoice().getCostumerId());// need to make it better
			}
		});


		frmBookStoreSystem.getContentPane().setLayout(null);
		frmBookStoreSystem.getContentPane().add(panel);
		frmBookStoreSystem.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblLibraryManagementSystem);
		FindItemTxtField = new JTextField();
		FindItemTxtField.setFont(new Font("Dialog", Font.PLAIN, 15));
		FindItemTxtField.setBounds(131, 148, 202, 33);
		panel_1.add(FindItemTxtField);

		FindCustomerTxtField = new JTextField();
		FindCustomerTxtField.setBounds(675, 145, 202, 33);
		panel_1.add(FindCustomerTxtField);
		FindCustomerTxtField.setFont(new Font("Dialog", Font.PLAIN, 15));
		FindCustomerTxtField.setColumns(10);

		/*
		 * FindItemTxtField.addKeyListener(new KeyAdapter() {
		 * 
		 * @Override public void keyTyped(KeyEvent key) {
		 * 
		 * comboBox.removeAllItems(); String s = FindItemTxtField.getText();
		 * if(key.getKeyChar() > 31 && key.getKeyChar() < 130) {//make sure that the
		 * typed char is not backspace or escape or etc. s =
		 * FindItemTxtField.getText()+key.getKeyChar(); }//key.getKeyChar() is added
		 * since The related document for the text field has not been updated at the
		 * time the keyTyped event is generated. if (s.length() > 2) { try { pst = con.
		 * prepareStatement("select Item_Name from item where Item_Name like ? or Barcode = ?"
		 * ); pst.setString(1, "%" + s + "%"); pst.setString(2, s); ResultSet result =
		 * pst.executeQuery(); while (result.next()) {
		 * comboBox.addItem(result.getString("Item_Name")); }
		 * comboBox.setPopupVisible(comboBox.getSelectedIndex() != -1); } catch
		 * (SQLException e) { } } else { comboBox.hidePopup();
		 * 
		 * }
		 * 
		 * }
		 * 
		 * int index = 0;
		 * 
		 * public void keyPressed(KeyEvent key) {
		 * comboBox.setPopupVisible(comboBox.getSelectedIndex() != -1); if (index >=
		 * comboBox.getItemCount()) index = 0; if (key.getKeyCode() == KeyEvent.VK_DOWN
		 * && index < comboBox.getItemCount() - 1) { comboBox.setSelectedIndex(++index);
		 * FindItemTxtField.setText((String) comboBox.getSelectedItem()); } else if
		 * (key.getKeyCode() == KeyEvent.VK_UP && index > 0) {
		 * comboBox.setSelectedIndex(--index); FindItemTxtField.setText((String)
		 * comboBox.getSelectedItem()); } else if (key.getKeyCode() ==
		 * KeyEvent.VK_ENTER) { comboBox.hidePopup(); String s =
		 * FindItemTxtField.getText();
		 * 
		 * DisplayItemWindow a = new DisplayItemWindow(s);
		 * 
		 * }
		 * 
		 * } });
		 */

		JComboBox<ComboBoxDisplayItem> comboBoxItem = new JComboBox<>();
		comboBoxItem.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxItem.setBounds(131, 148, 202, 33);
		panel_1.add(comboBoxItem);
		comboBoxItem.setBackground(Color.WHITE);
		comboBoxItem.setUI(new BasicComboBoxUI() {
			protected JButton createArrowButton() {
				return new JButton() {
					public int getWidth() {
						return 0;
					}
				};
			}
		});

//						AutoSuggestion.enable(FindItemTxtField, comboBox, "item", "Item_Name", "Barcode",(String s) -> {
//							CustomerDaoImpl dao = new CustomerDaoImpl();
//							try {
//								return dao.GetCustomersByName(s);
//							} catch (Exception e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							return null;
//						});
		AutoSuggestion<Item> ItemAutoSuggestion = new AutoSuggestion<Item>(FindItemTxtField, comboBoxItem,
				(Integer id) -> {
					DisplayItemWindow a = new DisplayItemWindow(id);
					a.NewScreen();
					return true;
				});
		ItemAutoSuggestion.enable("name", (String s) -> {
			ItemDaoImpl dao = new ItemDaoImpl();
			try {
				return dao.getItemsLikeName(s);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		});

		JComboBox<ComboBoxDisplayItem> comboBoxCustomer = new JComboBox<>();
		comboBoxCustomer.setBackground(Color.WHITE);
		comboBoxCustomer.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxCustomer.setBounds(675, 145, 202, 33);

		panel_1.add(comboBoxCustomer);

		AutoSuggestion<Customer> customerAutoSuggestion = new AutoSuggestion<Customer>(FindCustomerTxtField,
				comboBoxCustomer, (Integer id) -> {
					table.reInitTable(id);
					return true;
				});

		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.setBounds(887, 144, 145, 33);
		panel_1.add(btnNewCustomer);
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerWindow nw = new AddCustomerWindow();
				nw.NewScreen();
			}
		});
		btnNewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewCustomer.setBackground(Color.LIGHT_GRAY);

		JLabel lblFindCustomer = new JLabel("Find Customer :");
		lblFindCustomer.setBounds(536, 145, 145, 33);
		panel_1.add(lblFindCustomer);
		lblFindCustomer.setFont(new Font("Dialog", Font.PLAIN, 18));
		JButton btnNewItem = new JButton("New Item");
		btnNewItem.setBounds(343, 149, 118, 33);
		panel_1.add(btnNewItem);
		btnNewItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItemWindow a = new AddItemWindow();
				a.NewScreen();
			}
		});
		btnNewItem.setBackground(Color.LIGHT_GRAY);

		JLabel lblFindItem = new JLabel("Find Item : ");
		lblFindItem.setBounds(37, 147, 118, 33);
		panel_1.add(lblFindItem);
		lblFindItem.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		
		customerAutoSuggestion.enable("name", (String s) -> {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			try {
				return dao.getCustomersLikeName(s);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		});
		frmBookStoreSystem.setBackground(Color.WHITE);
		frmBookStoreSystem.setBounds(100, 100, 1405, 811);
		frmBookStoreSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
