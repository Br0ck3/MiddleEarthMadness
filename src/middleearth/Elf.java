package middleearth;

//Represents an Elf character in Middle-earth.
public class Elf extends MiddleEarthCharacter {
    public Elf(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public String getRace() {
        return "Elf";
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Elf || target instanceof Dwarf) {
            System.out.println(name + " cannot attack " + target.getRace() + ".");
            return false;
        }
        double damage = (target instanceof Orc) ? power * 1.5 : power;
        target.health -= damage;
        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
        return true;
    }
}
