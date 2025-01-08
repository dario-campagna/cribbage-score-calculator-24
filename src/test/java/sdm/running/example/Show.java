package sdm.running.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Show {

    private final Display display = Mockito.mock(Display.class);
    private final CribbageScoreCalculator calculator = new CribbageScoreCalculator(display);

    @Test
    void score29() {
        calculator.showScoreFor("5♥5♦5♠J♣5♣");
        Mockito.verify(display).show(29);
    }

    @Test
    void score4() {
        calculator.showScoreFor("0♥J♥K♥A♥8♦");
        Mockito.verify(display).show(4);
    }
    
    @Test
    void score12() {
        calculator.showScoreFor("5♠4♠2♠6♥5♥");
        Mockito.verify(display).show(12);
    }
}
