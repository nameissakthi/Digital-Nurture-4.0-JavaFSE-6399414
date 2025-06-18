public class Computer {
    private String CPU;
    private String RAM;
    private String STORAGE;

    private Computer(Builder builder){
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.STORAGE = builder.STORAGE;

        System.out.println("Computer Created");
    }

    @Override
    public String toString(){
        return String.format("CPU : %s | RAM : %s | STORAGE : %s", CPU, RAM, STORAGE);
    }

    static class Builder{
        private String CPU;
        private String RAM;
        private String STORAGE;
        
        public Builder(){
            System.out.println("Building the Computer");
        }

        public void setCPU(String CPU){
            this.CPU = CPU;
        }

        public void setRAM(String RAM){
            this.RAM = RAM;
        }

        public void setSTORAGE(String STORAGE){
            this.STORAGE = STORAGE;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
