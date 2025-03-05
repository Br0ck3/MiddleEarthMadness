package middleearth;

import java.util.Scanner;

public class MiddleEarthApp {
    public static void main(String[] args) {
        MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
        CharacterManager manager = council.getCharacterManager();

        // Predefined characters
        manager.addCharacter(new Elf("Legolas", 100, 20));
        manager.addCharacter(new Dwarf("Gimli", 120, 15));

        Scanner scanner = new Scanner(System.in);

        // User input for a new character
        System.out.println("Enter character name:");
        String name = scanner.nextLine();
        System.out.println("Enter character health:");
        double health = scanner.nextDouble();
        System.out.println("Enter character power:");
        double power = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Choose race: 1. Elf, 2. Dwarf, 3. Human, 4. Orc, 5. Wizard");
        int raceChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (raceChoice) {
            case 1:
                manager.addCharacter(new Elf(name, health, power));
                break;
            case 2:
                manager.addCharacter(new Dwarf(name, health, power));
                break;
            case 3:
                manager.addCharacter(new Human(name, health, power));
                break;
            case 4:
                manager.addCharacter(new Orc(name, health, power));
                break;
            case 5:
                manager.addCharacter(new Wizard(name, health, power));
                break;
            default:
                System.out.println("Invalid choice.");
        }
        

        System.out.println("Character created!");

        // Print all characters
        for (MiddleEarthCharacter character : manager.getCharacters()) {
            System.out.println(character.getName() + " the " + character.getRace());
        }

        scanner.close();
    }
}
