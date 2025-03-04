package middleearth;

public class Human extends MiddleEarthCharacter {
    public Human(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public String getRace() {
        return "Human";
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Human || target instanceof Orc) {
            System.out.println(name + " cannot attack " + target.getRace() + ".");
            return false;
        }
        double damage = (target instanceof Wizard) ? power * 1.5 : power;
        target.health -= damage;
        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
        return true;
    }
}
