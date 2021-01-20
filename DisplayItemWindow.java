
import java.awt.EventQueue;

import javax.swing.JFrame;

public class DisplayItemWindow extends ItemWindow {

	Item item;
	public DisplayItemWindow(int id) {
		ItemDaoImpl dao = new ItemDaoImpl();
		try {
			item = dao.getItemById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
		frmNewItem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmNewItem.dispose();
	

	}
	
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

	public void initialize() {

		txtBarcode.setText(item.getBarcode());
		txtItemName.setText(item.getName());
		txtItemPrice.setText(Double.toString(item.getPrice()));
		txtQty.setText(Integer.toString(item.getQty()));
		txtBarcode.setEditable(false);
		txtItemName.setEditable(false);
		txtItemPrice.setEditable(false);
		txtQty.setEditable(false);
		

}
}

