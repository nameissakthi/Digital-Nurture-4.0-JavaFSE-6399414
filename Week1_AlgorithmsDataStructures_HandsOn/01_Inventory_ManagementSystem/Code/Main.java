public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(1, "Laptop", 100, 40000));
        inventory.addProduct(new Product(2, "Mouse", 400, 700));
        inventory.addProduct(new Product(3, "Keyboard", 700, 800));
        inventory.addProduct(new Product(4, "Pendrive", 500, 600));
        inventory.addProduct(new Product(5, "Ex SSD", 700, 5000));

        inventory.displayProduct();
        System.out.println();

        inventory.updateProduct(new Product(5, "RAM", 500, 3000));

        inventory.displayProduct();
        System.out.println();

        inventory.removeProduct(5);

        inventory.displayProduct();
    }
}
