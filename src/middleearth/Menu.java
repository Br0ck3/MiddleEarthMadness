package middleearthapp;

import java.util.Scanner;

// Handles user interaction and provides a structured menu
public class Menu {
    private CharacterManager manager;
    private Scanner scanner;

    // Constructor initializes the character manager and scanner
    public Menu() {
        MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
        this.manager = council.getCharacterManager();
        this.scanner = new Scanner(System.in);
    }

    // Displays the main menu and handles user input
    public void displayMenu() {
        while (true) {
            System.out.println("\nMiddle-Earth Character Manager");
            System.out.println("1. Add a Character");
            System.out.println("2. Display All Characters");
            System.out.println("3. Update a Character");
            System.out.println("4. Delete a Character");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCharacter();
                    break;
                case 2:
                    manager.displayAllCharacters();
                    break;
                case 3:
                    updateCharacter();
                    break;
                case 4:
                    deleteCharacter();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Adds a new character based on user input
    private void addCharacter() {
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        System.out.print("Enter character health: ");
        double health = scanner.nextDouble();
        System.out.print("Enter character power: ");
        double power = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        System.out.println("Choose race: 1. Elf, 2. Dwarf, 3. Human, 4. Orc, 5. Wizard");
        int raceChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        MiddleEarthCharacter character = null;
        switch (raceChoice) {
            case 1:
                character = new Elf(name, health, power);
                break;
            case 2:
                character = new Dwarf(name, health, power);
                break;
            case 3:
                character = new Human(name, health, power);
                break;
            case 4:
                character = new Orc(name, health, power);
                break;
            case 5:
                character = new Wizard(name, health, power);
                break;
            default:
                System.out.println("Invalid choice. Character not created.");
                return;
        }
        
        manager.addCharacter(character);
        System.out.println("Character added successfully!");
    }

    // Updates an existing character
    private void updateCharacter() {
        System.out.print("Enter character name to update: ");
        String name = scanner.nextLine();
        MiddleEarthCharacter character = manager.getCharacter(name);
        if (character == null) {
            System.out.println("Character not found.");
            return;
        }
        
        System.out.print("Enter new health value: ");
        double health = scanner.nextDouble();
        System.out.print("Enter new power value: ");
        double power = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        if (manager.updateCharacter(name, health, power)) {
            System.out.println("Character updated successfully!");
        } else {
            System.out.println("Failed to update character.");
        }
    }

    // Deletes a character based on user input
    private void deleteCharacter() {
        System.out.print("Enter character name to delete: ");
        String name = scanner.nextLine();
        if (manager.deleteCharacter(name)) {
            System.out.println("Character deleted successfully!");
        } else {
            System.out.println("Character not found.");
        }
    }
}
