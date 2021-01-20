import javax.javax.persistence.Column;
import javax.javax.persistence.Id;
import javax.javax.persistence.Table;
import javax.javax.persistence.Transient;

@Table(name = "Invoice_Item")
public class InvoiceItem extends BaseEntity {
	@Id
	private Integer id;
	@Column(name = "Invoice_Id")
	private int invoiceId;
	@Column(name = "Item_Id")
	private int itemId;
	@Column(name = "Qty")
	private int quantity;
	@Column(name = "Sale")
	private double sale;
	@Column(name = "Amount")
	private double amount;
	@Transient
	private Item item;
	
	public InvoiceItem(int invoiceId, int itemId, int quantity, double amount, Item item) {
		this.invoiceId = invoiceId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.amount = amount;
		this.item = item;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double unitPrice) {
		this.amount = unitPrice;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	
}
