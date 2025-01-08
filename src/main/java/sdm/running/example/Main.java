package sdm.running.example;

public class Main {

    public static void main(String... args) {
        CribbageScoreCalculator calculator = new CribbageScoreCalculator(score -> System.out.println(score));
        calculator.showScoreFor(args[0]);
    }
    
}
