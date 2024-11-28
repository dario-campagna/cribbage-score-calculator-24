package sdm.running.example;

import java.util.List;

public class CribbageScore {
    List<ScoringRule> rules;

    public CribbageScore(List<ScoringRule> rules) {
        this.rules = rules;
    }

    public long of(CribbageHand hand) {
        return rules.stream().mapToLong(rule -> rule.applyTo(hand)).sum();
    }
}
