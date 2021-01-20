import java.util.List;

import javax.daoTemplate.dao.GenericDaoImpl;

public class ItemDaoImpl extends GenericDaoImpl<Integer, Item> {
	public ItemDaoImpl() {
		super(Item.class, new MyDataSource());
	}
	
	/* Define additional method */
	public Item getItemByName(String name) throws Exception {
		 return getSingleEntity("Item_Name=?", name);
	}
	
	public Item getItemById(int id) throws Exception {
		 return getSingleEntity("ID=?", id);
	}
	
	public Item getItemByBarcode(String barcode) throws Exception {
		 return getSingleEntity("Barcode=?", barcode);
	}
	
	public List<Item> getItemsLikeName(String name) throws Exception {
		String suggestion = "%" + name + "%";
		return getList("Item_Name like ?", suggestion);
	}
	

}
