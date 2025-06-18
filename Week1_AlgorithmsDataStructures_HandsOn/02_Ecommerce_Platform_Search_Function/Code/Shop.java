public class Shop {    

    Product[] products = new Product[10];

    public void storeProducts(){
        products[0] = new Product(1, "Phone", "Electronics");
        products[1] = new Product(2, "Laptop", "Electronics");
        products[2] = new Product(3, "Shirt", "Fashion");
        products[3] = new Product(4, "Shoes", "Fashion");
        products[4] = new Product(5, "Stove", "Kitchen");
        products[5] = new Product(6, "Bat", "Sports");
        products[6] = new Product(7, "Football", "Sports");
        products[7] = new Product(8, "Maida", "Grocery");
        products[8] = new Product(9, "Kadalai", "Grocery");
        products[9] = new Product(10, "Fan", "Electronics");
    }

    public int linearSearch(int productId){
        for (int i = 0; i < products.length; i++) {
            if(products[i].getProductId() == productId){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int productId){
        int low = 0;
        int high = products.length-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(products[mid].getProductId()==productId){
                return mid;
            }else if(products[mid].getProductId()>productId){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public void displayProduct(int productId){

        if(productId==-1)
            System.out.println("Product Not Found");

        System.out.println("Name : "+products[productId].getProductName()+" Category : "+products[productId].getCategory());
    }
}