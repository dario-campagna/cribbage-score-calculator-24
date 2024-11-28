package sdm.running.example.rules;

import sdm.running.example.CribbageHand;
import sdm.running.example.ScoringRule;

public class ScoreForFlush implements ScoringRule {
    @Override
    public long applyTo(CribbageHand hand) {
        return hand.isFlush() ? 4 + (hand.hasCardsOfSameSuite() ? 1 : 0) : 0;
    }
}
