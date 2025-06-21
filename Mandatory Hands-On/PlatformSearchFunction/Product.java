package PlatformSearchFunction;

public class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String cat) {
        productId = id;
        productName = name;
        category = cat;
    }

    public void display() {
        System.out.println("Product ID: " + productId + ", Name: " + productName + ", Category: " + category);
    }

    public static Product linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                return products[i];
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product(101, "Camera", "Electronics");
        products[1] = new Product(102, "Laptop", "Electronics");
        products[2] = new Product(103, "Shoes", "Footwear");
        products[3] = new Product(104, "T-Shirt", "Apparel");
        products[4] = new Product(105, "Watch", "Accessories");

        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, "Shoes");
        if (result1 != null) result1.display();
        else System.out.println("Product not found.");

        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j].productName.compareToIgnoreCase(products[j + 1].productName) > 0) {
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }

        System.out.println("Binary Search:");
        Product result2 = binarySearch(products, "Shoes");
        if (result2 != null) result2.display();
        else System.out.println("Product not found.");
    }
}

