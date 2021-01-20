import javax.javax.persistence.Column;
import javax.javax.persistence.Id;
import javax.javax.persistence.Table;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.swing.JOptionPane;
//
//public class Customer {
//
//private String name;
//private String phone;
//
//public static Customer RetrieveCustomer(String CustomerName) {
//	PreparedStatement pst;
//	ResultSet result;
//	try {
//		pst = DBC.getConnection().prepareStatement("select * from item where Customer_Name = ?");
//		pst.setString(1, CustomerName);
//		result = pst.executeQuery();	
//		result.next();
//		Customer m = new Customer(result.getString("Customer_Name"),result.getString("Phone_Number"));
//		DBC.disConnect();
//		return m;
//	} catch (SQLException e) {
//		JOptionPane.showMessageDialog(null, "Item " + CustomerName + " does not exist");
//		return null;
//	}
//}
//
//public static Customer addCustomer(String name, String phone) {
//	PreparedStatement pst;
//	
//	try {
//		pst = DBC.getConnection().prepareStatement("insert into customer(Customer_Name,Phone_Number)values(?,?)");
//		pst.setString(1, name);
//		pst.setString(2, phone);
//		pst.executeUpdate();
//		DBC.disConnect();
//		
//	} catch (SQLException e) {
//		 	
//		JOptionPane.showMessageDialog(null, "Customer phone number already exist");
//		return null;
//	}
//	
//		return new Customer(name, phone);
//
//}
//
//public Customer(String name, String phone) {
//	this.name = name;
//	this.phone = phone;
//}
//public String getName() {
//	return name;
//}
//public void setName(String name) {
//	this.name = name;
//}
//public String getPhone() {
//	return phone;
//}
//public void setPhone(String phone) {
//	this.phone = phone;
//}
//
//
//}

@Table(name = "customer")
public class Customer extends BaseEntity {

	public Customer() {
	}

	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Id
	private Integer id;
	@Column(name = "Customer_Name")
	private String name;
	@Column(name = "Phone_Number")
	private String phoneNumber;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}