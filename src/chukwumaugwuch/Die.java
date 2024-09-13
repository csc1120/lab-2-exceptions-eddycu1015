/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: FIXME
 * Last Updated: FIXME
 */
package chukwumaugwuch;

import java.util.Random;

public class Die {
    /**
     * Fewest sides a user can generate.
     */
    public static final int MIN_SIDES = 2;
    /**
     * Most sides a user can generate.
     */
    public static final int MAX_SIDES = 100;
    private int currentValue;
    private final int numSides;
    private Random random;

    /**
     * Constructor for die objects.
     * @param numSides Number of sides
     * @throws IllegalArgumentException if input is out of valid range
     */
    public Die(int numSides) {
        if (numSides < MIN_SIDES || numSides > MAX_SIDES) {
            throw new IllegalArgumentException("Number of sides must be between " + MIN_SIDES + " and " + MAX_SIDES);
        }
        this.numSides = numSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * Generates a new random value for the die.
     */
    public void roll() {
        currentValue = random.nextInt(numSides) + MIN_SIDES;
    }
}