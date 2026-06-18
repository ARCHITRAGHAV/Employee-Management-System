package junit;

public class CalculatorService {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int product(int a, int b) {
        return a * b;
    }

    public static int addAny(int... numbers) {
        int s = 0;
        for (int i : numbers) {
            s = s + i;
        }
        return s;
    }
}
