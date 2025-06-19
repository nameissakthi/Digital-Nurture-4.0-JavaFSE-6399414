public class Cart {
    private Order[] orders = new Order[10];

    public void shuffleOrders() {
        orders[0] = new Order(1, "sakthivel", 2043);
        orders[1] = new Order(2, "jhon", 2442);
        orders[2] = new Order(3, "leo", 1333);
        orders[3] = new Order(4, "steve", 8984);
        orders[4] = new Order(5, "nancy", 4545);
        orders[5] = new Order(6, "william", 7954);
        orders[6] = new Order(7, "shakespere", 2312);
        orders[7] = new Order(8, "nolan", 9535);
        orders[8] = new Order(9, "wick", 8972);
        orders[9] = new Order(10, "potter", 2411);
    }

    public Order[] getOrders(){
        return orders;
    }

    public void displayOrders(Order[] orders){
        for(Order order : orders){
            System.out.printf("Id : %d | Customer Name : %s | Total Price : %d\n", order.getOrderId(), order.getCustomerName(), order.getTotalPrice());
        }
    }

    public void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private int partition(Order[] orders, int low, int high) {
        int pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
