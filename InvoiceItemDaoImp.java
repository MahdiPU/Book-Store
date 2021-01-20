import javax.daoTemplate.dao.GenericDaoImpl;


public class InvoiceItemDaoImp extends GenericDaoImpl<Integer, InvoiceItem>{

	public InvoiceItemDaoImp() {
		super(InvoiceItem.class, new MyDataSource());
	}
	
}
