import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

class MyServiceTest {

    @Test
    public void testInteractionOrder(){
        Interaction interaction = mock(Interaction.class);

        MyService service = new MyService(interaction);

        service.runMethods();

        InOrder inOrder = inOrder(interaction);

        inOrder.verify(interaction).one();
        inOrder.verify(interaction).two();
        inOrder.verify(interaction).three();
    }
}