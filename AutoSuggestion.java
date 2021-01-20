import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AutoSuggestion<T extends BaseEntity> {
	JTextField field;
	JComboBox<ComboBoxDisplayItem> comboBox;
	Function<Integer, Boolean> onKeyPressed;
	
	public AutoSuggestion(JTextField fld, JComboBox<ComboBoxDisplayItem> cmbox, Function<Integer, Boolean> onKeyPressed) {
		field = fld;
		comboBox = cmbox;
		this.onKeyPressed = onKeyPressed;
	}
	
	public void enable(String CustomerOrItemName, Function<String, List<T>> getData) {
//		field.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                AutoSuggestion.con = DBC.getConnection();
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                DBC.disConnect();
//            }
//        });
		field.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyTyped(KeyEvent key) {
				
				comboBox.removeAllItems();
				String s = field.getText();
				if(key.getKeyChar() > 31 && key.getKeyChar() < 130) {//make sure that the key typed is an actual character.
				s = field.getText()+key.getKeyChar();	
				}//key.getKeyChar() is added since The related document for the text field has not been updated at the time the keyTyped event is generated.
				if (s.length() > 2) {
					try {
						
//						pst = con.prepareStatement("select " + CustomerOrItemName + " from " + tableName + " where " + CustomerOrItemName + " like ? or " + CustomerIDOrItemBarcode + " = ?");
//						pst.setString(1, "%" + s + "%");
//						pst.setString(2, s);
						

			//			ResultSet result = pst.executeQuery();
						List<T> result = getData.apply(s);
						if(result != null) {
							for(T i : result) {
								ComboBoxDisplayItem display = new ComboBoxDisplayItem(i.getId(), Helper.get(i, CustomerOrItemName));
								comboBox.addItem(display);
								//comboBox.addItem(Helper.get(i, CustomerOrItemName));
							}	
						}
						
//						while (result.next()) {
//							comboBox.addItem(result.getString(CustomerOrItemName));
//						}
						comboBox.setPopupVisible(comboBox.getSelectedIndex() != -1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					comboBox.hidePopup();
					
				}
				
			}
			
			int index = 0;

			public void keyPressed(KeyEvent key) {
				comboBox.setPopupVisible(comboBox.getSelectedIndex() != -1);	//Set pop up visible if the combo box has items
				if (index >= comboBox.getItemCount())
					index = 0;
				if (key.getKeyCode() == KeyEvent.VK_DOWN && index < comboBox.getItemCount() - 1) {
					comboBox.setSelectedIndex(++index);
					field.setText((String) comboBox.getSelectedItem().toString());
				} else if (key.getKeyCode() == KeyEvent.VK_UP && index > 0) {
					comboBox.setSelectedIndex(--index);
					field.setText((String) comboBox.getSelectedItem().toString());
				} else if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					
					int selectedItemId = Helper.get(comboBox.getSelectedItem(), "value");
					onKeyPressed.apply(selectedItemId);
					comboBox.hidePopup();
//					String s = field.getText();
//					DisplayItemWindow a = new DisplayItemWindow(s);
					//a.NewScreen();
				}

			}
		});
		/*Component[] comps = comboBox.getComponents();
		for (int i = 0; i < comps.length; i++) {
			comps[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					field.setText((String) comboBox.getSelectedItem());
					Item.RetrieveItem((field.getText()));
				}
			});
		}*/
	}
	
	
}
