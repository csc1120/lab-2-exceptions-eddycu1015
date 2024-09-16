/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Eddy Chukwuma-Ugwu
 * Last Updated: 9/13/24
 */
package chukwumaugwuch;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program asks the user to generate dice and how many times they should be rolled.
 * After simulating the rolls it prints a report that shows the most common values.
 */
public class Driver {
    /**
     * Least dice allowed.
     */
    public static final int MIN_DICE = 2;
    /**
     * Most dice allowed.
     */
    public static final int MAX_DICE = 10;

    public static void main(String[] args) {
        boolean done = false;
        while (!done) {
            try {
                int[] diceProperties = getInput();
                Die[] diceList = createDice(diceProperties[0], diceProperties[1]);
                int[] rollValues = rollDice(diceList, diceProperties[1], diceProperties[2]);
                report(diceProperties[0], rollValues, findMax(rollValues));
                done = true;
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter whole numbers.");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

    }

    /**
     * Sets the properties of dice to what the user inputs.
     * @return Array w/ # of dice, sides, and rolls.
     */
    private static int[] getInput() {
        System.out.println("Enter the number of dice to roll, " +
                "number of sides they'll have, and number of times to roll them. ");
        System.out.println("Make sure to separate each value with a space: ");
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        for (int i = 0; i < 3; i++) {
            if (sc.hasNextInt()) {
                input[i] = sc.nextInt();
            } else {
                throw new InputMismatchException();
            }
        }

        if (input[0] < MIN_DICE || input[0] > MAX_DICE) {
            throw new IllegalArgumentException("Number of dice must be between "
                    + MIN_DICE + " and " + MAX_DICE);
        }
        return input;
    }

    /**
     * Creates dice objects.
     * @param numDice # of dice rolled at once.
     * @param numSides # of sides each die has.
     * @return Array of dice.
     */
    private static Die[] createDice(int numDice, int numSides) {
        Die[] dice = new Die[numDice];
        for (int i = 0; i < numDice; i++) {
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    /**
     * Rolls the set of dice multiple times then tracks frequency of each value.
     * @param dice Array of dice objects.
     * @param numSides # of sides each die has.
     * @param numRolls # of times the set of dice is rolled.
     * @return An array of amounts each value was rolled.
     */
    private static int[] rollDice(Die[] dice, int numSides, int numRolls) {
        int[] values = new int[numSides * dice.length - dice.length + 1];
        for (int i = 0; i < numRolls; i++) {
            int sum = 0;
            for (Die die : dice) {
                die.roll();
                sum += die.getCurrentValue();
            }
            values[sum - dice.length]++;
        }
        return values;
    }

    /**
     * Finds the highest value from array of frequency.
     * @param rolls Array of amounts each value was rolled.
     * @return Highest amount from array.
     */
    private static int findMax(int[] rolls) {
        int max = rolls[0];
        for (int roll : rolls) {
            if (roll > max) {
                max = roll;
            }
        }
        return max;
    }

    /**
     * Prints each value and how often it was rolled.
     * @param numDice # of dice rolled each time.
     * @param rolls Array of amounts each value was rolled.
     * @param max Highest amount from rolls array.
     */
    private static void report(int numDice, int[] rolls, int max) {
        double scale = (double) max / 10;
        for (int i = 0; i < rolls.length; i++) {
            String stars = "";
            int numStars = (int)Math.round(rolls[i] / scale);
            stars += "*".repeat(numStars);
            System.out.printf("%2d:%-8d%s%n", i + numDice, rolls[i], stars);
        }
    }

}

