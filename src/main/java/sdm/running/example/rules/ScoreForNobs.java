package sdm.running.example.rules;

import sdm.running.example.CribbageHand;
import sdm.running.example.ScoringRule;

public class ScoreForNobs implements ScoringRule {
    @Override
    public long applyTo(CribbageHand hand) {
        return hand.hasNobs() ? 1 : 0;
    }
}
