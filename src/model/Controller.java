package model;

public class Controller {

    private Card[] pokedex;
    private final int MAX_CARDS = 1000;

    public Controller() {
        pokedex = new Card[MAX_CARDS];
    }


    /**
     * Descripción: Permite registrar una carta a partir de los parametros
     * Precondición: El arreglo pokedex debe estar inicializado
     * Poscondición: Se asigna una carta nueva al arreglo pokedex 
     * @param name
     * @param type
     * @param rarity
     * @param expansion
     * @param id
     * @param price
     * @return
     */
    public boolean registerCard(String name, String type, String rarity, String expansion, int id, double price) {

        Card myCard = new Card(name, type, rarity, expansion, id, price);

        for (int i = 0; i < pokedex.length; i++) {

            if (pokedex[i] == null) {
                pokedex[i] = myCard;
                return true;
            }

        }

        return false;

    }

    public String getPokedexInformation() {

        String information = "";

        for (int i = 0; i < pokedex.length; i++) {
            if (pokedex[i] != null) {
                information += (i + 1) + ". " + pokedex[i].getName() + "\n";
            }

        }

        return information;

    }

    public String getCardInformation(int index){


        return null;
    }

}
