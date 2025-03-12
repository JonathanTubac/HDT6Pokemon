/**
 * Jonathan Javier Tubac Arreaza 24484
 */
package uvg.edu;

import java.util.List;

/**
 * The Pokemon class represents a Pokémon with various attributes such as name, types, classification, height, weight, abilities, generation, and legendary status.
 */
public class Pokemon {
    private String name;
    private int pokedex_num;
    private String type1;
    private String type2;
    private String classification;
    private double height_meters;
    private double weight_kg;
    private List<String> abilities;
    private int generation;
    private String is_legendary;

    /**
     * Constructs a new Pokemon with the specified attributes.
     *
     * @param name The name of the Pokémon.
     * @param pokedex_num The Pokédex number of the Pokémon.
     * @param type1 The primary type of the Pokémon.
     * @param type2 The secondary type of the Pokémon (can be null).
     * @param classification The classification of the Pokémon.
     * @param height_meters The height of the Pokémon in meters.
     * @param weight_kg The weight of the Pokémon in kilograms.
     * @param abilities The list of abilities of the Pokémon.
     * @param generation The generation of the Pokémon.
     * @param is_legendary The legendary status of the Pokémon.
     */
    public Pokemon(String name, int pokedex_num, String type1, String type2, 
                   String classification, double height_meters, double weight_kg, 
                   List<String> abilities, int generation, String is_legendary) {
        this.name = name;
        this.pokedex_num = pokedex_num;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height_meters = height_meters;
        this.weight_kg = weight_kg;
        this.abilities = abilities;
        this.generation = generation;
        this.is_legendary = is_legendary;
    }

    /**
     * Gets the name of the Pokémon.
     *
     * @return The name of the Pokémon.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the Pokédex number of the Pokémon.
     *
     * @return The Pokédex number of the Pokémon.
     */
    public int getPokedexNum() {
        return pokedex_num;
    }

    /**
     * Gets the primary type of the Pokémon.
     *
     * @return The primary type of the Pokémon.
     */
    public String getType1() {
        return type1;
    }

    /**
     * Gets the secondary type of the Pokémon.
     *
     * @return The secondary type of the Pokémon.
     */
    public String getType2() {
        return type2;
    }

    /**
     * Gets the classification of the Pokémon.
     *
     * @return The classification of the Pokémon.
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Gets the height of the Pokémon in meters.
     *
     * @return The height of the Pokémon in meters.
     */
    public double getHeightMeters() {
        return height_meters;
    }

    /**
     * Gets the weight of the Pokémon in kilograms.
     *
     * @return The weight of the Pokémon in kilograms.
     */
    public double getWeightKg() {
        return weight_kg;
    }

    /**
     * Gets the list of abilities of the Pokémon.
     *
     * @return The list of abilities of the Pokémon.
     */
    public List<String> getAbilities() {
        return abilities;
    }

    /**
     * Gets the generation of the Pokémon.
     *
     * @return The generation of the Pokémon.
     */
    public int getGeneration() {
        return generation;
    }

    /**
     * Gets the legendary status of the Pokémon.
     *
     * @return The legendary status of the Pokémon.
     */
    public String getIsLegendary() {
        return is_legendary;
    }

    /**
     * Returns a string representation of the Pokémon.
     *
     * @return A string representation of the Pokémon.
     */
    @Override
    public String toString() {
        return "Nombre: " + name + ", Pokedex Number: " + pokedex_num +
                ", Tipo1: " + type1 + ", Tipo2: " + type2 +
                ", Clasificación: " + classification + ", Altura: " + height_meters +
                "m, Peso: " + weight_kg + "kg, Habilidades: " + abilities.toString() +
                ", Generación: " + generation + ", Legendario: " + is_legendary;
    }
}
