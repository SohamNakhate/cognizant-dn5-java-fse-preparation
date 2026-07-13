package mainPackage;

public class SearchAlgorithms {
	public static Product linearSearch(Product[] products, int productId) {
		for(Product product: products) {
			if(product.getProductId() == productId) {
				return product; 
			}
		}
		return null; 
	}
	
	public static Product binarySearch(Product[] product, int productId) {
		int left = 0; 
		int right = product.length - 1; 
		
		while(left <= right) {
			int mid = left + (right - left) / 2 ; 
			
			if(product[mid].getProductId() == productId) {
				return product[mid]; 
			}
			else if(product[mid].getProductId() < productId) {
				left = mid + 1; 
			}
			else right = mid - 1; 
			
		}
		return null; 
	}
}
