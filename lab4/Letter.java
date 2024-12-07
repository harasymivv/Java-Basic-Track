package lab4;

/**
 * Class representing a single letter.
 */
public class Letter {
    private char value;  // The letter's character value

    /**
     * Constructor to initialize the letter.
     * @param value The character representing the letter
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Returns the letter's value.
     * @return The character value of the letter
     */
    public char getValue() {
        return value;
    }

    /**
     * Sets a new value for the letter.
     * @param value The new character value
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * Converts the letter to a string.
     * @return The letter as a string
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Converts the letter to uppercase.
     * @return A new Letter object in uppercase
     */
    public Letter toUpperCase() {
        return new Letter(Character.toUpperCase(value));
    }

    /**
     * Converts the letter to lowercase.
     * @return A new Letter object in lowercase
     */
    public Letter toLowerCase() {
        return new Letter(Character.toLowerCase(value));
    }
}
