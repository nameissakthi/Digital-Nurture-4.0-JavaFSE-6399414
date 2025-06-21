public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("Groww", 100.0);

        MobileApp mobileApp = new MobileApp("mobile");
        WebApp webApp = new WebApp("web");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        System.out.println("Updating Stock Price.....");
        stockMarket.setStockPrice(105.0);

        stockMarket.deregister(mobileApp);

        System.out.println();

        System.out.println("Updating Stock Price.....");
        stockMarket.setStockPrice(110.0);
    }    
}
