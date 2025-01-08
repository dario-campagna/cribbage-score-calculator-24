package sdm.running.example;

import sdm.running.example.parse.CribbageHandParser;
import sdm.running.example.rules.ScoreForFifteenTwos;
import sdm.running.example.rules.ScoreForFlush;
import sdm.running.example.rules.ScoreForNobs;
import sdm.running.example.rules.ScoreForPairs;

import java.util.Arrays;

public class CribbageScoreCalculator {
    private final Display display;
    private CribbageHandParser parser = new CribbageHandParser();
    private CribbageScore score = new CribbageScore(Arrays.asList(
            new ScoreForFifteenTwos(),
            new ScoreForFlush(),
            new ScoreForPairs(),
            new ScoreForNobs()
    ));

    public CribbageScoreCalculator(Display display) {
        this.display = display;
    }

    public void showScoreFor(String cribbageHandAsString) {
        display.show(score.of(parser.parse(cribbageHandAsString)));
    }
}
