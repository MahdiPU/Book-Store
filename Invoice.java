
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.javax.persistence.Column;
import javax.javax.persistence.Id;
import javax.javax.persistence.Table;
import javax.javax.persistence.Transient;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@Table(name = "invoice")
public class Invoice extends BaseEntity {
	
	@Id
	private Integer id;
	@Transient
	ArrayList<InvoiceItem> InvoiceItems;
	
	@Column(name = "Customer_Id")
	private int customerId;
	@Column(name = "Discount")
	private double discount;
	@Column(name = "SubTotal_Amount")
	private double subTotalAmount;
	@Column(name = "Date")
	private LocalDate InvoiceDate;
	
	
	
	public Invoice() {
		customerId = -1; //For quick sales
		InvoiceDate = LocalDate.now();
		discount = 0;
		subTotalAmount = 0;
		InvoiceItems = new ArrayList<>();
	}

	public Invoice(int costumerId) {
		this.customerId = costumerId;
		InvoiceDate = LocalDate.now();
		discount = 0;
		subTotalAmount = 0;
		InvoiceItems = new ArrayList<>();
	}

	public Invoice(int costumerId, double discount, double total, ArrayList<InvoiceItem> list) {
		this.customerId = costumerId;
		InvoiceDate = LocalDate.now();
		this.discount = discount;
		subTotalAmount = total;
		InvoiceItems = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCostumerId() {
		return customerId;
	}

	public void setCostumerId(int costumerId) {
		this.customerId = costumerId;
	}

	public double getSubTotalAmount() {
		return subTotalAmount;
	}

	public void setSubTotalAmount(double totalAmount) {
		this.subTotalAmount = totalAmount;
	}

	public LocalDate getInvoiceDate() {
		return InvoiceDate;
	}

	public void setInvoiceDate(LocalDate InvoiceDate) {
		this.InvoiceDate = InvoiceDate;
	}

	public ArrayList<InvoiceItem> getInvoiceItems() {
		return InvoiceItems;
	}

	public void setInvoiceItems(ArrayList<InvoiceItem> items) {
		this.InvoiceItems = items;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	

}
