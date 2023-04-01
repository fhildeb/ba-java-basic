# Diverse Array Manipulation

These programs showcase various array manipulation and processing techniques, from handling command line parameters and generating sequences to simulating dice throws and performing statistical analysis.

## ArgsTester (Main)

This program prints command line parameters in the order they were provided or in reverse order if specified.

### Terminal Output

Passed Arguments: `argEins` `argZwei` `argDrei`

```bash
argEins
argZwei
argDrei
```

## Fibonacci (Main)

This program generates a Fibonacci sequence up to a specified length and stores the values in a long array. It outputs the values in a table format and explores the efficiency and limitations of calculating large Fibonacci numbers.

### Terminal Output

```bash
0
1
2
3
5
8
...
4181
```

## Rueckwaerts (Main)

This program takes command line parameters and prints them in reverse order, reversing the characters of each parameter as well.

### Terminal Output

Passed Arguments: `argEins` `argZwei` `argDrei`

```bash
ierDgra iewZgra sniEgra
```

## SummeVon (Main)

This program outputs the sum of the integers passed as command line parameters.

### Terminal Output

Passed Arguments: `15` `12` `1998`

```bash
2025
```

## WuerfelTest (Main)

This program simulates a dice using a randomized math method and generates a specified number of throws. It stores the results in an int array and performs statistical evaluations, such as sum, average, relative frequencies, and standard deviation.

### Terminal Output

```bash
Summe: 1773
Durchschnitt: 3.546

Haeufigkeit von 1: 72
rel. Haeufigkeit: 0.144

Haeufigkeit von 2: 84
rel. Haeufigkeit: 0.168

Haeufigkeit von 3: 100
rel. Haeufigkeit: 0.2

Haeufigkeit von 4: 78
rel. Haeufigkeit: 0.156

Haeufigkeit von 5: 75
rel. Haeufigkeit: 0.15

Haeufigkeit von 6: 91
rel. Haeufigkeit: 0.182


Varianz: 2.597194388777555
Standardabweichung: 1.6115813317290428
```
