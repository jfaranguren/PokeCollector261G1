package model;

/**
 * Description: The Controller class manages a collection of Pokémon cards (Pokedex).
 * It provides functionalities to manage cards in the collection.
 * 
 */
public class Controller {

    /**
     * Array that stores all the Pokémon cards in the collection.
     */
    private Card[] pokedex;

    /**
     * Maximum number of cards that can be stored in the Pokedex.
     */
    private final int MAX_CARDS = 1000;

    /**
     * Description: Initializes a new Controller with an empty Pokedex array.
     * The array is sized to hold up to MAX_CARDS cards.
     * Also loads test data into the Pokedex.
     * 
     * Postcondition: pokedex array is initialized and test data is loaded
     */
    public Controller() {
        pokedex = new Card[MAX_CARDS];
        loadTestData();

    }

    /**
     * Description: Loads test data into the Pokedex for demonstration purposes.
     * Registers three test cards with predefined information.
     * 
     * Precondition: pokedex array must be initialized.
     * Postcondition: Three test cards are added (if possible) to the Pokedex.
     */
    public void loadTestData() {

        registerCard("Pikachu", "Electrico", "Normal", "Rocky Ridges", 20, 2.0);
        registerCard("Blastoise", "Agua", "Rara", "Void Dimension", 43, 14.0);
        registerCard("Error", "Error", "Error", "Error", 43, -20);
    }

    /**
     * Description: Registers a new Pokémon card in the Pokedex.
     * Creates a Card object with the provided details and adds it to the first
     * available
     * null position in the pokedex array.
     * Precondition: pokedex array must be initialized.
     * Postcondition: If available null position is found, a new Card object is
     * added
     * to to the pokedex.
     * 
     * @param name      the name of the Pokémon card
     * @param type      the type of the Pokémon (e.g., Fire, Water, Grass)
     * @param rarity    the rarity level of the card
     * @param expansion the expansion set the card belongs to
     * @param id        the unique identifier of the card
     * @param price     the price of the card
     * @return true if the card is successfully registered, false if the Pokedex is
     *         full
     */
    public boolean registerCard(String name, String type, String rarity, String expansion, int id, double price) {

        if (checkCardId(id)) {

            Card myCard = new Card(name, type, rarity, expansion, id, price);

            for (int i = 0; i < pokedex.length; i++) {

                if (pokedex[i] == null) {
                    pokedex[i] = myCard;
                    return true;
                }

            }
        }

        return false;

    }

    /**
     * Description: Checks if a card with the given ID already exists in the Pokedex.
     * Prevents duplicate card IDs from being registered.
     * 
     * Precondition: pokedex array must be initialized.
     * 
     * @param id the ID to check for uniqueness
     * @return true if the ID is unique and not in use, false if it already exists
     */
    public boolean checkCardId(int id) {

        for (Card card : pokedex) {

            if (card != null && card.getId() == id) {
                return false;
            }

        }

        return true;

    }

    /**
     * Description: Retrieves formatted information about all cards in the Pokedex.
     * Lists each registered card with its position number and name, separated by
     * newlines.
     * Only non-null cards are included in the output.
     * Precondition: pokedex array must be initialized.
     * 
     * @return a String containing the formatted list of all cards in the Pokedex,
     *         or an empty string if no cards are registered
     */
    public String getPokedexInformation() {

        String information = "";

        for (int i = 0; i < pokedex.length; i++) {
            if (pokedex[i] != null) {
                information += (i + 1) + ". " + pokedex[i].getName() + "\n";
            }

        }

        return information;

    }

    /**
     * Description: Retrieves detailed information about a specific card in the
     * Pokedex.
     * Precondition: pokedex array must be initialized.
     * 
     * @param index the position of the card in the Pokedex array (0-based indexing)
     * @return a String containing the card's detailed information, or null if not
     *         implemented
     *         or if the index is out of bounds
     */
    public String getCardInformation(int index) {

        if (checkIndex(index) && pokedex[index] != null) {

            return pokedex[index].toString();

        }

        return null;
    }

    /**
     * Description: Validates if an index is within the valid range of the Pokedex array.
     * 
     * Precondition: pokedex array must be initialized.
     * 
     * @param index the index to validate
     * @return true if the index is within the valid range (0 to MAX_CARDS-1), false otherwise
     */
    public boolean checkIndex(int index) {

        if (index >= 0 && index <= MAX_CARDS) {
            return true;
        }

        return false;
    }

    /**
     * Description: Modifies the information of an existing card in the Pokedex.
     * Updates the card's name, type, rarity, expansion, and price.
     * 
     * Precondition: pokedex array must be initialized.
     * Precondition: index must be valid and within bounds.
     * Postcondition: If the card exists at the given index, its information is updated.
     * 
     * @param index the position of the card to modify (0-based indexing)
     * @param name the new name for the card
     * @param type the new type for the card
     * @param rarity the new rarity level for the card
     * @param expansion the new expansion set for the card
     * @param price the new price for the card
     * @return true if the card is successfully modified, false if the index is invalid or card doesn't exist
     */
    public boolean modifyCard(int index, String name, String type, String rarity, String expansion, double price) {

        if (checkIndex(index) && pokedex[index] != null) {

            pokedex[index].setName(name);
            pokedex[index].setType(type);
            pokedex[index].setRarity(rarity);
            pokedex[index].setExpansion(expansion);
            pokedex[index].setPrice(price);
            return true;

        }

        return false;
    }

    /**
     * Description: Deletes a card from the Pokedex by setting it to null.
     * The card at the specified index is removed from the collection.
     * 
     * Precondition: pokedex array must be initialized.
     * Precondition: index must be valid and within bounds.
     * Postcondition: If a card exists at the given index, it is removed (set to null).
     * 
     * @param index the position of the card to delete (0-based indexing)
     * @return true if the card is successfully deleted, false if the index is invalid or no card exists at that position
     */
    public boolean deleteCard(int index) {

        if (checkIndex(index) && pokedex[index] != null) {

            pokedex[index] = null;

            return true;

        }

        return false;

    }

}
