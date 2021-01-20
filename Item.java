import javax.javax.persistence.Column;
import javax.javax.persistence.Id;
import javax.javax.persistence.Table;

/*import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Item {
private String barcode;
private String name;
private double price;
private int qty;

public Item(String barcode, String name, double price, int qty) {
	setBarcode(barcode);
	setName(name);
	setPrice(price);
	setQty(qty);
}

public static Item RetrieveItem(String ItemNameOrBarcode) {
	PreparedStatement pst;
	ResultSet result;
	try {
		pst = DBC.getConnection().prepareStatement("select * from item where Item_Name = ? or Barcode = ?");
		pst.setString(1, ItemNameOrBarcode);
		pst.setString(2, ItemNameOrBarcode);
		result = pst.executeQuery();	
		result.next();
		Item m = new Item(result.getString("Barcode"),result.getString("Item_Name"), result.getDouble("Price"), result.getInt("Qty"));
		DBC.disConnect();
		return m;
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Item " + ItemNameOrBarcode + " does not exist");
		return null;
	}
	
	
}



public static Item addItem(String barcode, String name, double price, int qty) {
	PreparedStatement pst;
	
	try {
		pst = DBC.getConnection().prepareStatement("insert into item(Barcode,Item_Name,Price,Qty)values(?,?,?,?)");
		pst.setString(1, barcode);
		pst.setString(2, name);
		pst.setDouble(3, price);
		pst.setInt(4, qty);
		pst.executeUpdate();
		DBC.disConnect();
		
	} catch (SQLException e) {
		 	
		JOptionPane.showMessageDialog(null, "Barcode or Item Name already exist");
		return null;
	}
	
		return new Item(barcode, name, price, qty);

}

public String getBarcode() {
	return barcode;
}

public void setBarcode(String barcode) {
	this.barcode = barcode;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}
}
*/
@Table(name = "item")
public class Item extends BaseEntity{
	
	public Item() {}
	
	public Item(String barcode, String name, double price, int qty) {
		this.name = name;
		this.barcode = barcode;
		this.price = price;
		this.qty = qty;
	}
	
	@Id
	private Integer id;
	@Column(name = "Barcode")
	private String barcode;
	@Column(name = "Item_Name")
	private String name;
	@Column(name = "Price")
	private double price;
	@Column(name = "Qty")
	private int qty;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
