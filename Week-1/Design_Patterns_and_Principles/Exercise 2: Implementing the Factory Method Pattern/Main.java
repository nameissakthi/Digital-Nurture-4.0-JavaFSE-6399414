public class Main {

    public static void test(){

        Document WORD = new WordDocumentFactory().createDocument();
        WORD.open();
        WORD.close();
        System.out.println("-------------------------");

        Document PDF = new PdfDocumentFactory().createDocument();
        PDF.open();
        PDF.close();
        System.out.println("-------------------------");

        Document EXCEL = new ExcelDocumentFactory().createDocument();
        EXCEL.open();
        EXCEL.close();
        System.out.println("-------------------------");

    }
    public static void main(String[] args) {
        
        System.out.println("-----IMPLEMENTATION OF FACTORY METHOD PATTERN-----");
        System.out.println("--------------------------------------------------");

        System.out.println();

        test();
    }
}
