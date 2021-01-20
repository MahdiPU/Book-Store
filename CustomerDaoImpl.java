import java.util.ArrayList;
import java.util.List;

import javax.daoTemplate.dao.GenericDaoImpl;

public class CustomerDaoImpl extends GenericDaoImpl<Integer, Customer> {
	public CustomerDaoImpl() {
		super(Customer.class, new MyDataSource());
	}
	
	/* Define additional method */
	public Customer getCustomerByName(String name) throws Exception {
		 return getSingleEntity("Customer_Name=?", name);
	}
	public Customer getCustomerById(int id) throws Exception {
		 return getSingleEntity("ID=?", id);
	}
	
	public List<Customer> getCustomersLikeName(String name) throws Exception {
		String suggestion = "%" + name + "%";
		return getList("Customer_Name like ?", suggestion);
	}
	
}
