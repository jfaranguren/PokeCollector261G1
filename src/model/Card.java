package model;

/**
 * Card class represents a Pokemon trading card with its properties.
 * Stores information about a card such as name, type, rarity, expansion set, ID, and price.
 */
public class Card {

    // Attributes
    private String name;
    private String type;
    private String rarity;
    private String expansion;
    private int id;
    private double price;

    // Methods
    
    /**
     * Constructs a Card object with the specified properties.
     *
     * @param name      The name of the card
     * @param type      The type of the card
     * @param rarity    The rarity level of the card
     * @param expansion The expansion set the card belongs to
     * @param id        The unique identification number of the card
     * @param price     The price of the card
     */
    public Card(String name, String type, String rarity, String expansion, int id, double price) {

        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.expansion = expansion;
        this.id = id;
        this.price = price;

    }

    /**
     * Returns a string representation of the card with all its information.
     *
     * @return A formatted string containing the card's name, type, rarity, expansion, ID, and price
     */
    public String toString() {

        return "Nombre: " + name + 
               "\nTipo: " + type +
               "\nRareza: " + rarity +
               "\nExpansion: " + expansion +
               "\nID: " + id +
               "\nPrice: " + price;

    }

}
