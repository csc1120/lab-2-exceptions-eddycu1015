/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Eddy Chukwuma-Ugwu
 * Last Updated: 9/13/24
 */
package chukwumaugwuch;

/**
 * Exception that's thrown if getValue is called before a die is rolled.
 */
public class DieNotRolledException extends RuntimeException {
    /**
     * Prints error message.
     * @return Error message.
     */
    public String getMessage() {
        return super.getMessage();
    }
}
