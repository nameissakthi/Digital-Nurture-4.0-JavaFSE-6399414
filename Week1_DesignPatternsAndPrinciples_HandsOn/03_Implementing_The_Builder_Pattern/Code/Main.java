public class Main {
    public static void main(String[] args) {
        
        System.out.println("Builder Pattern");
        System.out.println("---------------");

        Computer.Builder builder = new Computer.Builder();
        builder.setCPU("Intel i5");
        builder.setRAM("16GB SKhynix");
        builder.setSTORAGE("512GB WD SSD");

        System.out.println(builder.build());

        System.out.println();

        builder = new Computer.Builder();
        builder.setCPU("AMD Ryzen 7");
        builder.setRAM("8GB SKhynix");
        builder.setSTORAGE("512GB Zebronics SSD");

        System.out.println(builder.build());
    }
}