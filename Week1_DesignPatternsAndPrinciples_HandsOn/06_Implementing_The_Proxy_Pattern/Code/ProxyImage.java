public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename){
        this.filename = filename;
        loadingImage(filename);
    }

    public void loadingImage(String filename){
        System.out.println(filename+" image is loading");
    }

    @Override
    public void display(){
        if(realImage == null){
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
