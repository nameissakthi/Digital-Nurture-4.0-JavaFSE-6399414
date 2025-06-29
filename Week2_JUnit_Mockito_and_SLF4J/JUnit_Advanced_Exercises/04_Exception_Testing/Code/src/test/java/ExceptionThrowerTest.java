import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionThrowerTest {

    @Test
    public void testThrowException() {
        ExceptionThrower exceptionThrower = new ExceptionThrower();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            exceptionThrower.throwException(true);
        });

        assertEquals("Exception thrown by ExceptionThrower", exception.getMessage());
    }

    @Test
    public void testNoException() {
        ExceptionThrower exceptionThrower = new ExceptionThrower();

        assertDoesNotThrow(() -> {
            exceptionThrower.throwException(false);
        });
    }
}