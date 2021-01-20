import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class InvoiceTable {
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollPane;
	private Invoice invoice;
	InvoiceItem currentInvoiceItem;
	ArrayList<Integer> invoiceItemIds;
	JFrame frame;
	private JTextField txtSubtotal;
	private JTextField txtDiscount;
	private JTextField txtTotal;
	JCheckBox checkBox;
	JCheckBox checkBox_1;
	JLabel Namelbl;
	JLabel Phonelbl;
	JLabel Datelbl;
	private JTable invoicesTable;
	public InvoiceTable() {
		model = new DefaultTableModel();
		this.invoiceItemIds = new ArrayList<Integer>();
		table = new JTable(model);
		invoice = new Invoice();
		InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
		try {
			invoice = invoiceDao.save(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public InvoiceTable(int customerId) {
		this.invoiceItemIds = new ArrayList<Integer>();
		model = new DefaultTableModel();
		table = new JTable(model);
		invoice = new Invoice(customerId);
		InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
		try {
			invoice = invoiceDao.save(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Item addItem(String barcode) throws Exception {
		ItemDaoImpl dao = new ItemDaoImpl();
		Item item = dao.getItemByBarcode(barcode);
		item.setQty(item.getQty()-1);
		dao.update(item);
		currentInvoiceItem = new InvoiceItem(invoice.getId(), item.getId(), 1, item.getPrice(), item);
		InvoiceItemDaoImp invoiceItemDao = new InvoiceItemDaoImp();
		currentInvoiceItem = invoiceItemDao.save(currentInvoiceItem); 
		this.invoice.getInvoiceItems().add(currentInvoiceItem);
		
		//invoiceItemIds.add(currentInvoiceItem.getId(), table.getSelectedRow());
		return item;
	}

	public void newRow() {
		model.addRow(new Object[] { null, null, null, null, null, null });
	}

	public void setRow(Item item, int row) {
		model.setValueAt(item.getBarcode(), row, 0);
		model.setValueAt(item.getName(), row, 1);
		model.setValueAt(item.getPrice(), row, 2);
		model.setValueAt(1, row, 3);
		model.setValueAt(0, row, 4);
		model.setValueAt(item.getPrice(), row, 5);
	}
	public void updateRow(InvoiceItem item, int row) {
		model.setValueAt(item.getQuantity()*item.getItem().getPrice()*(100-item.getSale())/100, row, 5);
	}
	public void updateTotal() {
		double total = 0;
		for(InvoiceItem item : invoice.InvoiceItems) {
			total+=item.getAmount();
			System.out.println(total);
		}
		txtSubtotal.setText(Double.toString(total));
		invoice.setSubTotalAmount(total);
		total = total*((100-Double.parseDouble(txtDiscount.getText()))/100);
		txtTotal.setText(Double.toString(total));
		InvoiceDaoImpl dao = new InvoiceDaoImpl();
		try {
			dao.update(invoice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("serial")
	public void initTable(JFrame frame) {
		
		txtSubtotal = new JTextField();
		txtSubtotal.setBounds(405, 683, 86, 20);
		txtSubtotal.setColumns(10);
		txtSubtotal.setText("0");
		
		txtDiscount = new JTextField();
		txtDiscount.setBounds(587, 683, 86, 20);
		txtDiscount.setColumns(10);
		txtDiscount.setText("0");
		
		txtTotal = new JTextField();
		txtTotal.setBounds(744, 683, 86, 20);
		txtTotal.setColumns(10);
		txtTotal.setText("0");
		checkBox = new JCheckBox("");
		checkBox.setBounds(1003, 249, 27, 23);
		checkBox.setBackground(Color.WHITE);

		checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(1038, 249, 27, 23);
		checkBox_1.setBackground(Color.WHITE);

		JTextArea txtStopOn = new JTextArea();
		txtStopOn.setBounds(947, 252, 54, 18);
		txtStopOn.setFont(new Font("Arial", Font.PLAIN, 13));
		txtStopOn.setText("Stop on:");

		JTextArea txtrTotalPrice = new JTextArea();
		txtrTotalPrice.setBounds(686, 680, 54, 33);
		txtrTotalPrice.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtrTotalPrice.setText("Total:");

		JTextArea txtrSub = new JTextArea();
		txtrSub.setBounds(316, 681, 83, 33);
		txtrSub.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrSub.setText("Subtotal:");

		JTextArea txtrDiscount = new JTextArea();
		txtrDiscount.setBounds(501, 681, 86, 33);
		txtrDiscount.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrDiscount.setText("Discount:");
		
	

		/*JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(1050, 682, 89, 23);*/
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(316, 279, 814, 389);

		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSelectionBackground(Color.GRAY);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		Font font = new Font("Arial", Font.PLAIN, 16);
		table.setFont(font);
		model = new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Barcode", "Item Name", "Price", "Qnt", "Sale", "Total" });
		table.setModel(model);
		JTextField textField = new JTextField();
		textField.setFont(font);
		DefaultCellEditor dce = new DefaultCellEditor(textField);

		table.getTableHeader().setBackground(new Color(255, 255, 255));
		table.getTableHeader().setFont(font);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(178);
		table.getColumnModel().getColumn(0).setCellEditor(dce);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setCellEditor(dce);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setCellEditor(dce);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setCellEditor(dce);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(25);
		table.getColumnModel().getColumn(4).setCellEditor(dce);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setCellEditor(dce);
		table.setRowHeight(30);
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(316, 231, 46, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(543, 237, 56, 16);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(730, 237, 56, 16);
		frame.getContentPane().add(lblDate);
		
		Namelbl = new JLabel("");
		Namelbl.setBounds(358, 237, 180, 16);
		frame.getContentPane().add(Namelbl);
		
		Phonelbl = new JLabel("");
		Phonelbl.setBounds(591, 237, 127, 16);
		frame.getContentPane().add(Phonelbl);
		
		Datelbl = new JLabel("");
		Datelbl.setBounds(771, 237, 91, 16);
		frame.getContentPane().add(Datelbl);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(txtStopOn);
		frame.getContentPane().add(checkBox);
		frame.getContentPane().add(checkBox_1);
		frame.getContentPane().add(txtrSub);
		frame.getContentPane().add(txtSubtotal);
		frame.getContentPane().add(txtrDiscount);
		frame.getContentPane().add(txtDiscount);
		frame.getContentPane().add(txtrTotalPrice);
		frame.getContentPane().add(txtTotal);
		//frame.getContentPane().add(btnPrint);
		Datelbl.setText(invoice.getInvoiceDate().toString());
		tableLive();
	}
	public void reInitTable(int id) {
		invoice = new Invoice(id);
		InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		try {
			invoice = invoiceDao.save(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.setRowCount(0);
		newRow();
		txtDiscount.setText("0");
		txtSubtotal.setText("0");
		txtTotal.setText("0");
		Customer cust = new Customer();
		try {
			cust = customerDao.getCustomerById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String phone = cust.getPhoneNumber();
		String name = cust.getName();
		Namelbl.setText(name);
		Phonelbl.setText(phone);
		Datelbl.setText(invoice.getInvoiceDate().toString());
		tableLive();
	}
	public void tableLive() {
		InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap am = table.getActionMap();

		KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

		im.put(enterKey, "Action.enter");
		am.put("Action.enter", new AbstractAction() {
			public void actionPerformed(ActionEvent evt) {
				
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				TableCellEditor editor = table.getCellEditor();
				if (editor != null) {
					if (!editor.stopCellEditing())
						editor.cancelCellEditing();
				}
				//table.changeSelection(row, column, false, false);
				if (table.getSelectedColumn() == 0) {
				
					
					String barcode = (String) table.getValueAt(row, 0);
					try {
						Item item = addItem(barcode);
						setRow(item, row);
						if (row == table.getRowCount() - 1)
							newRow();
						if(checkBox.isSelected())
							table.changeSelection(row, 3, false, false);
						else if(checkBox_1.isSelected())
							table.changeSelection(row, 4, false, false);
						else
							table.changeSelection(row + 1, column, false, false);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Item does not Exist");
					}
				}
				else if(table.getSelectedColumn() == 3) {
					int qty = Integer.parseInt((String)	table.getValueAt(row, 3));
					currentInvoiceItem = invoice.getInvoiceItems().get(row);
					int oldqty = currentInvoiceItem.getQuantity();
					currentInvoiceItem.setQuantity(qty);
					currentInvoiceItem.getItem().setQty(currentInvoiceItem.getItem().getQty()-qty+oldqty);
					currentInvoiceItem.setAmount(qty*currentInvoiceItem.getItem().getPrice()*(100-currentInvoiceItem.getSale())/100);
					updateRow(currentInvoiceItem, row);
					InvoiceItemDaoImp dao = new InvoiceItemDaoImp();
					ItemDaoImpl itemDao = new ItemDaoImpl();
					try {
						itemDao.update(currentInvoiceItem.getItem());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						dao.update(currentInvoiceItem);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(checkBox_1.isSelected())
						table.changeSelection(row, 4, false, false);
					else if (row < table.getRowCount() - 1)
					table.changeSelection(row + 1, 0, false, false);
				}
				else if(table.getSelectedColumn() == 4) {
					double sale = Double.parseDouble((String)	table.getValueAt(row, 4));
					currentInvoiceItem = invoice.getInvoiceItems().get(row);
					currentInvoiceItem.setSale(sale);
					currentInvoiceItem.setAmount(currentInvoiceItem.getQuantity()*currentInvoiceItem.getItem().getPrice()*(100-currentInvoiceItem.getSale())/100);
					updateRow(currentInvoiceItem, row);
					InvoiceItemDaoImp dao = new InvoiceItemDaoImp();
					try {
						dao.update(currentInvoiceItem);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (row < table.getRowCount() - 1)
						table.changeSelection(row + 1, 0, false, false);
				}
				updateTotal();
			}
		});
		txtDiscount.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyPressed(KeyEvent key) {
				if(key.getKeyCode() == KeyEvent.VK_ENTER) {
					invoice.setDiscount(Double.parseDouble(txtDiscount.getText()));
					InvoiceDaoImpl dao = new InvoiceDaoImpl();
					try {
						dao.update(invoice);
					} catch (Exception e) {
						e.printStackTrace();
					}
					double subTotal = invoice.getSubTotalAmount();
					double discount = invoice.getDiscount();
					double total = subTotal*(100-discount)/100;
					txtTotal.setText(Double.toString(total));
				}
			}
		});
	}
	public void initInvoicesTable(JFrame frame) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(1175, 276, 200, 392);
		frame.getContentPane().add(scrollPane);
		invoicesTable = new JTable();
		Font font = new Font("Arial", Font.PLAIN, 16);
		invoicesTable.setFont(font);
		
		JTextField textField = new JTextField();
		textField.setFont(font);
		DefaultCellEditor dce = new DefaultCellEditor(textField);

		table.getTableHeader().setBackground(new Color(255, 255, 255));
		table.getTableHeader().setFont(font);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setCellEditor(dce);
		table.setIntercellSpacing(new Dimension(0, 0));
		DefaultTableModel model1 = new DefaultTableModel(
				new Object[][] {
					{null},
				},
				new String[] {
					"Invoices"
				}
			);
		invoicesTable.setModel(model1);
		scrollPane.setViewportView(invoicesTable);
		invoicesTable.setRowHeight(30);
		/*InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
		List<Invoice> list = new ArrayList<>();
		try {
			list = invoiceDao.getInvoicesByCustomerId(invoice.getCostumerId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Invoice inv : list) {
			model1.setValueAt(inv.getInvoiceDate(), model.getRowCount(), 0);
			model1.addRow(new Object[] {null});
		}*/
	}
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
