package middleearth;

public class Dwarf extends MiddleEarthCharacter {
    public Dwarf(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public String getRace() {
        return "Dwarf";
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Dwarf || target instanceof Wizard) {
            System.out.println(name + " cannot attack " + target.getRace() + ".");
            return false;
        }
        double damage = (target instanceof Elf) ? power * 1.5 : power;
        target.health -= damage;
        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
        return true;
    }
}
