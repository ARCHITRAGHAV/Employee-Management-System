package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Mock
    private AdditionService additionService;

    @InjectMocks
    private Calculator calculator;

    @Test
    void testAddition() {
        when(additionService.add(10, 20)).thenReturn(30);

        int result = calculator.calculate(10, 20);

        assertEquals(30, result);

        verify(additionService).add(10, 20);
        System.out.println("done");
    }

}
