package mainPackage;

public class Product {
	private int productId; 
	private String productName; 
	private String category;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Product(int productId, String productName, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
	}
	
	
	public Product() {
		super();
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + "]";
	} 
	
	
}
