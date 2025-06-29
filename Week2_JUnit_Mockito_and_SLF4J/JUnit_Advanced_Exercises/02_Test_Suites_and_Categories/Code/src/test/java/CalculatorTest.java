import org.junit.platform.suite.api.*;

@SelectClasses({
        AdditionTest.class,
        SubtractionTest.class
})
@SuiteDisplayName("Calculator Test Suite")
@Suite
public class CalculatorTest {
}
