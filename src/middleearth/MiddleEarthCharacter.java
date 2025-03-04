package middleearth;

/*
 * Abstract class representing a character in Middle-earth.
 */
public abstract class MiddleEarthCharacter {
    protected String name;
    protected double health;
    protected double power;

    /*
     * Constructor to initialize a character.
     * 
     * @param name The name of the character
     * @param health The health of the character.
     * @param power The attack power of the character.
     */
    public MiddleEarthCharacter(String name, double health, double power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }
    
     /**
     * Displays character details.
     */
    public void displayInfo() {
        System.out.println(getRace() + " " + name + " | Health: " + health + " | Power: " + power);
    }

    /**
     * Returns the race of the character.
     */
    public abstract String getRace();

    /**
     * Executes an attack on another character.
     *
     * @param target The character being attacked.
     * @return true if the attack was successful, false otherwise.
     */
    public abstract boolean attack(MiddleEarthCharacter target);
}