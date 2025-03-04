package middleearth;

public class Wizard extends MiddleEarthCharacter {
    public Wizard(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public String getRace() {
        return "Wizard";
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Wizard || target instanceof Human) {
            System.out.println(name + " cannot attack " + target.getRace() + ".");
            return false;
        }
        double damage = (target instanceof Dwarf) ? power * 1.5 : power;
        target.health -= damage;
        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
        return true;
    }
}
