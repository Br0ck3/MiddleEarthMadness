package middleearth;

/**
 * Manages a list of Middle-earth characters.
 */
public class CharacterManager {
    private MiddleEarthCharacter[] characters; // Array to store characters
    private int size; // Current number of characters
    private int capacity; // Max capacity before resizing

    /**
     * Constructor initializes the character list with a default size.
     */
    public CharacterManager() {
        this.capacity = 5; // Initial array size
        this.characters = new MiddleEarthCharacter[capacity];
        this.size = 0;
    }

    /**
     * Adds a new character to the list.
     * If the array is full, doubles its size before adding.
     *
     * @param c The character to add.
     * @return true if added successfully.
     */
    public boolean addCharacter(MiddleEarthCharacter c) {
        if (size == capacity) {
            resizeArray();
        }
        characters[size++] = c;
        return true;
    }

    /**
     * Doubles the size of the characters array when full.
     */
    private void resizeArray() {
        capacity *= 2;
        MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[capacity];

        // Copy old characters into the new array
        for (int i = 0; i < size; i++) {
            newCharacters[i] = characters[i];
        }
        characters = newCharacters;
    }

    /**
     * Finds and returns a character by name.
     *
     * @param name The character's name.
     * @return The character if found, otherwise null.
     */
    public MiddleEarthCharacter getCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].name.equals(name)) {
                return characters[i];
            }
        }
        return null;
    }

    /**
     * Updates a character's health and power.
     *
     * @param name   The character's name.
     * @param health The new health value.
     * @param power  The new power value.
     * @return true if the character was updated, false if not found.
     */
    public boolean updateCharacter(String name, double health, double power) {
        MiddleEarthCharacter c = getCharacter(name);
        if (c != null) {
            c.health = health;
            c.power = power;
            return true;
        }
        return false;
    }

    /**
     * Deletes a character from the list.
     *
     * @param name The name of the character to delete.
     * @return true if deleted, false if not found.
     */
    public boolean deleteCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].name.equals(name)) {
                // Shift elements left to remove the character
                for (int j = i; j < size - 1; j++) {
                    characters[j] = characters[j + 1];
                }
                characters[size - 1] = null; // Remove duplicate reference
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Displays all characters in the system.
     */
    public void displayAllCharacters() {
        if (size == 0) {
            System.out.println("No characters found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            characters[i].displayInfo();
        }
    }
}
