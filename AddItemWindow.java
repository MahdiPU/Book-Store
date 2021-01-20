import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddItemWindow extends ItemWindow{
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemWindow window = new AddItemWindow();
					window.frmNewItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AddItemWindow() {
		initialize();
	
		frmNewItem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmNewItem.dispose();
	}
	
	
	
	public void initialize() {
		
	JButton SaveButton;
	SaveButton = new JButton("SAVE");
	SaveButton.setBounds(309, 230, 90, 37);
	SaveButton.addActionListener(new ActionListener() {	// SAVE button action to add the item to the database by calling the addItem method located in Item class
		public void actionPerformed(ActionEvent arg0) {
			
			String barcode = txtBarcode.getText();
			String item_Name = txtItemName.getText();
			Double price = Double.parseDouble(txtItemPrice.getText());
			Integer quantity = Integer.parseInt(txtQty.getText());
			Item item = new Item(barcode, item_Name, price, quantity);
			ItemDaoImpl dao = new ItemDaoImpl();
			try {
				dao.save(item);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Item Already Exist");
				e.printStackTrace();
			}
		}
	});
	SaveButton.setBackground(Color.LIGHT_GRAY);
	SaveButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	frmNewItem.getContentPane().add(SaveButton);
}
}