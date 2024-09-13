/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: FIXME
 * Last Updated: FIXME
 */
package chukwumaugwuch;

/**
 * Exception that's thrown if getValue is called before die is rolled.
 */
public class DieNotRolledException extends RuntimeException  {
    /**
     * Prints error message.
     * @return Error message
     */
    public String DieNotRolledException() {
        return super.getMessage();
    }
}
