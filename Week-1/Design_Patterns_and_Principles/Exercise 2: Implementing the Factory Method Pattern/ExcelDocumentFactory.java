public class ExcelDocumentFactory implements DocumentFactory {

    @Override
    public Document createDocument(){
        return new ExcelDocument();
    }
    
}
