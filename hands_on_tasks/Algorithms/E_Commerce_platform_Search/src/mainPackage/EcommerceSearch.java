package mainPackage;

public class EcommerceSearch {

    public static void main(String[] args) {

        // Array for Linear Search
        Product[] products = {

                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Fashion"),
                new Product(109, "Mobile", "Electronics"),
                new Product(102, "Watch", "Accessories"),
                new Product(108, "Headphones", "Electronics")

        };

        // Sorted Array for Binary Search
        Product[] sortedProducts = {

                new Product(101, "Shoes", "Fashion"),
                new Product(102, "Watch", "Accessories"),
                new Product(105, "Laptop", "Electronics"),
                new Product(108, "Headphones", "Electronics"),
                new Product(109, "Mobile", "Electronics")

        };

        int searchId = 108;

        System.out.println("Searching Product ID : " + searchId);

        System.out.println("\n========== Linear Search ==========");

        Product linearResult = SearchAlgorithms.linearSearch(products, searchId);

        if (linearResult != null) {
            System.out.println("Product Found!");
            System.out.println(linearResult);
        } else {
            System.out.println("Product Not Found!");
        }

        System.out.println("\n========== Binary Search ==========");

        Product binaryResult = SearchAlgorithms.binarySearch(sortedProducts, searchId);

        if (binaryResult != null) {
            System.out.println("Product Found!");
            System.out.println(binaryResult);
        } else {
            System.out.println("Product Not Found!");
        }

        System.out.println("\n========== Time Complexity Analysis ==========");

        System.out.println("Linear Search:");
        System.out.println("Best Case    : O(1)");
        System.out.println("Average Case : O(n)");
        System.out.println("Worst Case   : O(n)");

        System.out.println();

        System.out.println("Binary Search:");
        System.out.println("Best Case    : O(1)");
        System.out.println("Average Case : O(log n)");
        System.out.println("Worst Case   : O(log n)");

        System.out.println();

        System.out.println("Conclusion:");
        System.out.println("Binary Search is more efficient for large datasets because");
        System.out.println("it repeatedly divides the search space into halves.");
        System.out.println("However, Binary Search requires the array to be sorted.");
        System.out.println("Linear Search can work on both sorted and unsorted data.");
    }
}