import javax.daoTemplate.dao.GenericDaoImpl;


public class CustomerPendingItemDaoImpl extends GenericDaoImpl<Integer, CustomerPendingItem>{

	public CustomerPendingItemDaoImpl() {
		super(CustomerPendingItem.class, new MyDataSource());
	}

}
