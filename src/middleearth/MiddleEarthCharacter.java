package middleearth;

// Base class for all Middle-earth characters
public abstract class MiddleEarthCharacter {
    protected String name;
    protected double health;
    protected double power;

    // Constructor sets up character attributes
    public MiddleEarthCharacter(String name, double health, double power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }
    
    // Shows character details
    public void displayInfo() {
        System.out.println(getRace() + " " + name + " | Health: " + health + " | Power: " + power);
    }

    // Returns the race of the character
    public abstract String getRace();

    // Attacks another character
    public abstract boolean attack(MiddleEarthCharacter target);

    // Getters
    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getPower() {
        return power;
    }

    // Setters
    public void setHealth(double health) {
        this.health = health;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
