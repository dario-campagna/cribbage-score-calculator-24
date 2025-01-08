package sdm.running.example.rules;

import sdm.running.example.CribbageHand;
import sdm.running.example.ScoringRule;

public class ScoreForRuns implements ScoringRule {

    @Override
    public long applyTo(CribbageHand hand) {
        if (hand.isRunOfFive()) {
            return 5;
        }

        long runsOfFour = hand.runsOfFour();
        if (runsOfFour > 0) {
            return runsOfFour * 4;
        }

        return hand.runsOfThree() * 3;
    }
}
