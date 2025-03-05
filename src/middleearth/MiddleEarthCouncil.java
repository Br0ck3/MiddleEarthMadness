package middleearth;

// Singleton for managing Middle-earth characters
public class MiddleEarthCouncil {
    private static MiddleEarthCouncil instance;
    private CharacterManager characterManager;

    // Private constructor (only one instance allowed)
    private MiddleEarthCouncil() {
        this.characterManager = new CharacterManager();
    }

    // Returns the only instance of MiddleEarthCouncil
    public static MiddleEarthCouncil getInstance() {
        if (instance == null) {
            instance = new MiddleEarthCouncil();
        }
        return instance;
    }

    // Gives access to the character manager
    public CharacterManager getCharacterManager() {
        return characterManager;
    }
}
