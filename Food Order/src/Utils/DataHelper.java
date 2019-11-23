package Utils;

public class DataHelper {

	public String itemName;
	public int rate, quantity, total;

	public DataHelper(String itemName, int rate, int quantity, int total) {
		super();
		this.itemName = itemName;
		this.rate = rate;
		this.quantity = quantity;
		this.total = total;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
