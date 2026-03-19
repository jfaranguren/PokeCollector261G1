package ui;

import java.util.Scanner;
import model.Card;

/**
 * Executable class represents the user interface and main controller of the PokeCollector application.
 * Manages the main menu and functionalities.
 */
public class Executable {

    // Attributes
    private static Scanner reader;
    private static Card myCard;

    /**
     * Main entry point of the PokeCollector application.
     * Initializes the Scanner and starts the main menu.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        reader = new Scanner(System.in);
        showMenu();

    }

    /**
     * Displays the main menu and handles user option selection.
     * Allows users to access system functionalities or exit.
     */
    public static void showMenu() {

        int option = 0;

        do {
            System.out.println("Bienvenido a PokeCollector!!!");
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Registrar informacion de una carta");
            System.out.println("2. Mostrar informacion de una carta");
            System.out.println("0. Salir del sistema");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    registerCard();
                    break;

                case 2:
                    showCardInfo();
                    break;

                case 0:
                    System.out.println("Gracias por usar nuestros servicios!");
                    break;

                default:
                    System.out.println("Digite una opcion valida");
                    break;
            }

            if (option != 0) {
                clearConsole();
            }

        } while (option != 0);

    }

    /**
     * Clears the console screen after confirming user wants to return to the main
     * menu.
     * Uses ANSI escape codes to clear the screen.
     */
    public static void clearConsole() {

        int option = 0;

        while (option != 1) {
            System.out.println("\n¿Desea volver al menu principal?");
            System.out.println("1. Si");
            System.out.println("2. No");
            option = reader.nextInt();

        }

        System.out.print("\033[H\033[2J");

    }

    /**
     * Captures card information from the user and creates a new Card object.
     * Prompts for card name, type, rarity, expansion, ID, and price.
     */
    public static void registerCard() {

        reader.nextLine();
        System.out.println("Digite el nombre");
        String name = reader.nextLine();

        System.out.println("Digite el tipo");
        String type = reader.nextLine();

        System.out.println("Digite la rareza");
        String rarity = reader.nextLine();

        System.out.println("Digite la expansion");
        String expansion = reader.nextLine();

        System.out.println("Digite el numero consecutivo");
        int id = reader.nextInt();

        System.out.println("Digite el precio");
        double price = reader.nextDouble();

        myCard = new Card(name, type, rarity, expansion, id, price);

        System.out.println("Carta registrada exitosamente!");

    }

    /**
     * Displays the information of the registered card.
     * Prints all card details to the console.
     */
    public static void showCardInfo() {

        System.out.println("La informacion de la carta es: \n" + myCard.toString());

    }

}
