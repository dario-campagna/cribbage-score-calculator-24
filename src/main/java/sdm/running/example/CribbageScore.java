package sdm.running.example;

public class CribbageScore {
    public long of(CribbageHand hand) {
        int scoreForNobs = hand.hasNobs() ? 1 : 0;
        long scoreForFifteenTwos = 2 * hand.fifteenTwos();
        int scoreForFlush = hand.isFlush() ? 4 + (hand.hasCardsOfSameSuite() ? 1 : 0) : 0;
        long scoreForPairs = 2 * hand.getNumberOfPairs();
        return scoreForNobs + scoreForFlush +  scoreForFifteenTwos + scoreForPairs;
    }
}
