# Lehmer Random Number Generator

## Randomness Difficulty

True randomness is difficult for computers because they execute algorithms based on precise rules. [Lehmer's linear congruence](https://en.wikipedia.org/wiki/Lehmer_random_number_generator) method provides a simple yet effective way to generate seemingly random numbers by using certain constants, making the resulting numbers appear random and uniformly distributed within a specific range.

## ZufallsTestFenster (Main)

This program implements a Random Number Generator class using Lehmer's linear congruence method, which generates seemingly random numbers. It then visually tests the quality of the random number generator by displaying random points in a graphical user interface, where the absence of recognizable patterns indicates a good random number generator.

## GUI

![ZufallsTestFenster GUI](../img/09-zufall.png)

# ZufallsTest (Main)

## Terminal Output

```bash
79
88
71
39
77
5
50
...
7
```
