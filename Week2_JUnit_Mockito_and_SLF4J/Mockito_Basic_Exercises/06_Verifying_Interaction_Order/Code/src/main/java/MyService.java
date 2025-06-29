public class MyService {
    private final Interaction interaction;

    public MyService(Interaction interaction) {
        this.interaction = interaction;
    }

    public void runMethods(){
        interaction.one();
        interaction.two();
        interaction.three();
    }
}
