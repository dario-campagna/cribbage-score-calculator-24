# Behaviors

- Print on standard output the score of a given Cribbage hand (string)
- Compute the score of a Cribbage hand
  - Distinguish hand cards from starter card
  - Know the rank and the suite of a card
  - Combination of cards
- Parse a Cribbage hand represented as a string
    - Each rank corresponds to a numeric value
    - Well-defined set of values for rank and suite

# Tests

- "5♥5♦5♠J♣5♣" -> print "29"
- "0♦J♥Q♠A♣9♦" -> print "4"
- ~~5♥5♦5♠J♣5♣ -> score is 29~~
- ~~"5♥5♦5♠J♣5♣" -> four hand cards (five of Hearts,...) and a starter card (five of Clubs)~~
- ~~"5♥5♦5♠J♣5♣" -> five of Clubs is the starter card~~
- ~~"5♥5♦5♠J♣5♣" -> the hand cards are...~~
- ~~"5♥" -> card with rank 5~~
- ~~"5♥" -> card with suite Hearts~~
- ~~"5♦" -> card with suite Diamonds~~
- ~~"5♣" -> card with suite Clubs~~
- ~~"5♠" -> card with suite Spades~~

Pairs

- ~~8♥8♦4♠A♣5♣ -> score is 2~~
  - ~~8♥8♦4♠A♣5♣ -> one pair~~
- ~~2♥2♦2♠A♣5♣ -> score is 6~~
  - ~~2♥2♦2♠A♣5♣ -> three pairs~~
- ~~3♥3♦3♠A♣3♣ -> score is 12~~
  - ~~3♥3♦3♠A♣3♣ -> six pairs~~

Flush

- ~~0♥J♥K♥A♥9♦ -> score is 4~~
- ~~0♥J♥K♥A♥9♥ -> score is 5~~

One for his nobs

- ~~8♥J♣6♠K♣3♣ -> score is 1~~

Fifteen-twos

- ~~8♥J♣4♠K♣3♣ -> score is 2~~
  - ~~8♥J♣4♠K♣3♣ -> 1 combination of two or more cards totalling exactly fifteen~~
- ~~7♦3♦0♥5♣3♥ -> score is 6~~
  - ~~7♦3♦0♥5♣3♥ -> 3 combination of two or more cards totalling exactly fifteen~~

Runs

- 0♦J♥Q♠A♣9♦ -> score is 4
  - 0♦J♥Q♠A♣9♦ -> one run of four
- 0♠5♠4♠7♣3♥ -> score is 3
  - 0♠5♠4♠7♣3♥ -> a run of three
- 5♠4♠2♠6♥3♥ -> score is 6
  - - 5♠4♠2♠6♥3♥ -> double run of three

