public class ExceptionThrower {
    public void throwException(boolean exception) {
        if(exception)
            throw new RuntimeException("Exception thrown by ExceptionThrower");
    }
}
