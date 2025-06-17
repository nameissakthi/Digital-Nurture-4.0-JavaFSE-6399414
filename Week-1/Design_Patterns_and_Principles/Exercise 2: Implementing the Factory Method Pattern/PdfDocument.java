public class PdfDocument implements Document {

    public PdfDocument() {
        System.out.println("PDF Document Created");
    }

    @Override
    public void open(){
        System.out.println("Opening the PDF");
    }

    @Override
    public void close(){
        System.out.println("Closing the PDF");
    }
}
