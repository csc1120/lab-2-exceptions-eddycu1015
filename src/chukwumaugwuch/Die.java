/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Eddy Chukwuma-Ugwu
 * Last Updated: 9/13/24
 */
package chukwumaugwuch;

import java.util.Random;

/**
 * Die objects are generated w/ a specific amount of sides.
 * They can be rolled to give a random value.
 */
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
    private final Random random = new Random();

    /**
     * Constructor for die objects.
     * @param numSides Number of sides
     * @throws IllegalArgumentException if input is out of valid range
     */
    public Die(int numSides) {
        if (numSides < MIN_SIDES || numSides > MAX_SIDES) {
            throw new IllegalArgumentException("Number of sides must be between " +
                    MIN_SIDES + " and " + MAX_SIDES);
        }
        this.numSides = numSides;
    }

    /**
     * Returns current value.
     * @return Current value.
     * @throws DieNotRolledException if die isn't rerolled.
     */
    public int getCurrentValue() {
        if (currentValue < 1 || currentValue > MAX_SIDES) {
            throw new DieNotRolledException();
        }
        int value = currentValue;
        currentValue = 0;
        return value;
    }

    /**
     * Generates a new random value for the die.
     */
    public void roll() {
        currentValue = random.nextInt(numSides) + 1;
    }
}