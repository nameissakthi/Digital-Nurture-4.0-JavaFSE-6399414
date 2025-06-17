public class WordDocument implements Document {
    public WordDocument() {
        System.out.println("Word Document Created");
    }

    @Override
    public void open(){
        System.out.println("Opening the Word");
    }

    @Override
    public void close(){
        System.out.println("Closing the Word");
    }
}
