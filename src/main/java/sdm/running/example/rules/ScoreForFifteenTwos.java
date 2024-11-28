package sdm.running.example.rules;

import sdm.running.example.CribbageHand;
import sdm.running.example.ScoringRule;

public class ScoreForFifteenTwos implements ScoringRule {
    @Override
    public long applyTo(CribbageHand hand) {
        return 2 * hand.fifteenTwos();
    }
}
