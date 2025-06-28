public class MyService {
    private ExternalAPI externalAPI;

    public MyService(ExternalAPI externalAPI) {
        this.externalAPI = externalAPI;
    }

    public void setData(String name, int age) {
        externalAPI.send(name, age);
    }
}
