package middleearth;

/**
 * Singleton class that represents the Middle-earth Council.
 */
public class MiddleEarthCouncil {
    private static MiddleEarthCouncil instance;
    private CharacterManager characterManager;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private MiddleEarthCouncil() {
        characterManager = new CharacterManager();
    }

    /**
     * Returns the single instance of MiddleEarthCouncil.
     */
    public static MiddleEarthCouncil getInstance() {
        if (instance == null) {
            instance = new MiddleEarthCouncil();
        }
        return instance;
    }

    /**
     * Provides access to the CharacterManager.
     */
    public CharacterManager getCharacterManager() {
        return characterManager;
    }
}
