import java.util.concurrent.TimeUnit;

public class Performance {
    public void task() {
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
