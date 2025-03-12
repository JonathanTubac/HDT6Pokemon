package uvg.edu;

import java.util.List;

public class Pokemon {
    private String name;
    private int pokedex_num;
    private String type1;
    private String type2;
    private String classification;
    private double height_meters;
    private double weight_kg;
    private List<String> abilities;
    private String generation;
    private String is_legendary;

    // Constructor con los parámetros correctos
    public Pokemon(String name, int pokedex_num, String type1, String type2, String classification,
            double height_meters, double weight_kg, List<String> abilities, String generation, String is_legendary) {
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

    // Getters y setters (si es necesario)
    public String getName() {
        return name;
    }

    public int getPokedexNum() {
        return pokedex_num;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getClassification() {
        return classification;
    }

    public double getHeightMeters() {
        return height_meters;
    }

    public double getWeightKg() {
        return weight_kg;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public String getGeneration() {
        return generation;
    }

    public String getIsLegendary() {
        return is_legendary;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Pokedex Number: " + pokedex_num +
                ", Tipo1: " + type1 + ", Tipo2: " + type2 +
                ", Clasificación: " + classification + ", Altura: " + height_meters +
                "m, Peso: " + weight_kg + "kg, Habilidades: " + abilities.toString() +
                ", Generación: " + generation + ", Legendario: " + is_legendary;
    }
}
