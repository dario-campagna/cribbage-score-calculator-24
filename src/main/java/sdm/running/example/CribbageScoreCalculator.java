package sdm.running.example;

import sdm.running.example.parse.CribbageHandParser;
import sdm.running.example.rules.*;

import java.util.Arrays;

public class CribbageScoreCalculator {
    private final Display display;
    private CribbageHandParser parser = new CribbageHandParser();
    private CribbageScore score = new CribbageScore(Arrays.asList(
            new ScoreForFifteenTwos(),
            new ScoreForFlush(),
            new ScoreForPairs(),
            new ScoreForNobs(),
            new ScoreForRuns()
    ));

    public CribbageScoreCalculator(Display display) {
        this.display = display;
    }

    public void showScoreFor(String cribbageHandAsString) {
        display.show(score.of(parser.parse(cribbageHandAsString)));
    }
}
