import java.time.LocalDate;

import javax.javax.persistence.Column;
import javax.javax.persistence.Id;
import javax.javax.persistence.Table;

@Table(name = "customer_pending_item")
public class CustomerPendingItem extends BaseEntity {
	@Id
	private Integer id;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "qty")
	private int quantity;
	@Column(name = "date")
	private LocalDate PendingItemDate;
	
	Item item;
	
	public CustomerPendingItem(int customerId, int itemId, int quantity) {
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
		PendingItemDate = LocalDate.now();
		//item = 
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getPendingItemDate() {
		return PendingItemDate;
	}

	public void setPendingItemDate(LocalDate pendingItemDate) {
		PendingItemDate = pendingItemDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
