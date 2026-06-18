package junit;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @BeforeAll
    public static void init() {
        System.out.println("Before all test cases: ");
        System.out.println("Started test: " + new Date());
    }

    @BeforeEach
    public void before() {
        System.out.println("Test started");
    }

    @AfterEach
    public void after() {
        System.out.println("Test ended");
    }

    @Test
    public void addTest() {
        int ans = CalculatorService.add(10, 10);
        assertEquals(20, ans);
    }

    @Test
    public void productTest() {
        int ans = CalculatorService.product(10, 20);
        assertEquals(200, ans);
    }

    @Test
    public void addAny() {
        int ans = CalculatorService.addAny(10, 20, 20);
        assertEquals(50, ans);
    }

    @AfterAll
    public static void cleanUp() {
        System.out.println("Test Ended: " + new Date());
    }
}
