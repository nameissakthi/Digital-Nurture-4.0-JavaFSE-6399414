public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Order[] orders = cart.getOrders();
        
        cart.shuffleOrders();
        cart.displayOrders(orders);

        System.out.println();

        System.out.println("Quick Sort : ");
        cart.quickSort(orders, 0, orders.length-1);
        cart.displayOrders(orders);

        System.out.println();
        cart.shuffleOrders();

        System.out.println("Bubble Sort : ");
        cart.bubbleSort(orders);
        cart.displayOrders(orders);
    }
}
