
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
        System.out.println("Product Added Successfully");
    }

    public void updateProduct(Product product) {
        for(Product prod : products){
            if(prod.getProductId()==product.getProductId()){
                prod.setProductName(product.getProductName());
                prod.setQuantity(product.getQuantity());
                prod.setPrice(product.getPrice());
                return;
            }
        }

        System.out.println("No product found");
    }

    public void removeProduct(int productId){
        for(Product product : products){
            if(product.getProductId() == productId){
                products.remove(product);
                return;
            }
        }

        System.out.println("No Product Found");
    }

    public void displayProduct(){
        for(Product product : products){
            System.out.println(product);
        }
    }
}
