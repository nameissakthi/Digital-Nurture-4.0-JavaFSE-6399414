public class MyService {
    ExternalAPI externalAPI;

    public MyService(ExternalAPI externalAPI){
        this.externalAPI = externalAPI;
    }

    public String fetchData(){
        return externalAPI.getData();
    }
}
