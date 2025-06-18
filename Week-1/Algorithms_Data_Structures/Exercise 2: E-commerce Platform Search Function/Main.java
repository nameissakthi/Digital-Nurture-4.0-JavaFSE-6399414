public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        long start, end;
        int productId;


        shop.storeProducts();



        System.out.println("Linear Search :");
        start = System.nanoTime();
        productId = shop.linearSearch(8);
        end = System.nanoTime();
        shop.displayProduct(productId);
        System.out.println("Time Taken : "+(end - start));


        System.out.println("--------------------------------------");


        System.out.println("Binary Search :");
        start = System.nanoTime();
        productId = shop.binarySearch(8);
        end = System.nanoTime();
        shop.displayProduct(productId);
        System.out.println("Time Taken : "+(end - start));
    }    
}
