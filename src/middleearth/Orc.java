package middleearth;

public class Orc extends MiddleEarthCharacter {
    public Orc(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public String getRace() {
        return "Orc";
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Orc || target instanceof Elf) {
            System.out.println(name + " cannot attack " + target.getRace() + ".");
            return false;
        }
        double damage = (target instanceof Human) ? power * 1.5 : power;
        target.health -= damage;
        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
        return true;
    }
}
