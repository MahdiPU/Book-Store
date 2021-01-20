import java.util.List;

import javax.daoTemplate.dao.GenericDaoImpl;

public class InvoiceDaoImpl extends GenericDaoImpl<Integer, Invoice> {

	public InvoiceDaoImpl() {
		super(Invoice.class, new MyDataSource());
	}
	public List<Invoice> getInvoicesByCustomerId(Integer id) throws Exception{
		return getList("Customer_Id=?", id);
	}
}
