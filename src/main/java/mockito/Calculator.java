package mockito;

public class Calculator {
    private AdditionService additionService;

    public Calculator(AdditionService additionService) {
        this.additionService = additionService;
    }

    public int calculate(int a, int b) {
        return additionService.add(a, b);
    }
}
