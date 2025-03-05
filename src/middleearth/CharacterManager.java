package middleearth;

import java.util.Arrays;

// Manages characters in Middle-earth
public class CharacterManager {
    private MiddleEarthCharacter[] characters; // List of characters
    private int size; // Current number of characters
    private int capacity; // Max capacity before resizing

    // Constructor sets up initial character list
    public CharacterManager() {
        this.capacity = 5;
        this.characters = new MiddleEarthCharacter[capacity];
        this.size = 0;
    }

    // Adds a character, expands list if needed
    public boolean addCharacter(MiddleEarthCharacter c) {
        if (size == capacity) {
            resizeArray();
        }
        characters[size++] = c;
        return true;
    }

    // Expands array size when full
    private void resizeArray() {
        capacity *= 2;
        MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[capacity];

        for (int i = 0; i < size; i++) {
            newCharacters[i] = characters[i];
        }
        characters = newCharacters;
    }

    // Finds a character by name
    public MiddleEarthCharacter getCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].name.equals(name)) {
                return characters[i];
            }
        }
        return null;
    }

    // Updates character stats
    public boolean updateCharacter(String name, double health, double power) {
        MiddleEarthCharacter c = getCharacter(name);
        if (c != null) {
            c.health = health;
            c.power = power;
            return true;
        }
        return false;
    }

    // Removes a character from the list
    public boolean deleteCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].name.equals(name)) {
                for (int j = i; j < size - 1; j++) {
                    characters[j] = characters[j + 1];
                }
                characters[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    // Shows all characters
    public void displayAllCharacters() {
        if (size == 0) {
            System.out.println("No characters found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            characters[i].displayInfo();
        }
    }

    // Returns all characters
    public MiddleEarthCharacter[] getCharacters() {
        return Arrays.copyOf(characters, size); // Ensures only valid characters are returned
    }
}
