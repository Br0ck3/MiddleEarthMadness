package middleearth;

import java.util.Scanner;

public class MiddleEarthApp {
    public static void main(String[] args) {
        MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
        CharacterManager manager = council.getCharacterManager();

        manager.addCharacter(new Elf("Legolas", 100, 20));
        manager.addCharacter(new Dwarf("Gimli", 120, 15));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter character name:");
        String name = scanner.nextLine();
        System.out.println("Enter character health:");
        double health = scanner.nextDouble();
        System.out.println("Enter character power:");
        double power = scanner.nextDouble();

        System.out.println("Choose race (1 for Elf, 2 for Dwarf):");
        int raceChoice = scanner.nextInt();
        if (raceChoice == 1) {
            manager.addCharacter(new Elf(name, health, power));
        } else if (raceChoice == 2) {
            manager.addCharacter(new Dwarf(name, health, power));
        }

        System.out.println("Character created!");

        // Print all characters
        for (MiddleEarthCharacter character : manager.getCharacters()) {
            System.out.println(character.getName() + " the " + character.getRace());
        }

        scanner.close();
    }
}
