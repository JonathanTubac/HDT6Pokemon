/**
 * Jonathan Javier Tubac Arreaza 24484
 */
package uvg.edu;

import java.io.*;
import java.util.*;

/**
 * The PokemonLoader class provides a method to load Pokémon data from a CSV file.
 */
public class PokemonLoader {

    /**
     * Loads Pokémon data from a CSV file and returns a list of Pokémon objects.
     *
     * @param filePath The path to the CSV file containing Pokémon data.
     * @return A list of Pokémon objects loaded from the CSV file.
     */
    public static List<Pokemon> loadPokemonsFromCSV(String filePath) {
        List<Pokemon> pokemons = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); 
    
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    
                if (values.length >= 10) {
                    try {
                        String name = values[0].trim();
                        int pokedex_num = Integer.parseInt(values[1].trim());
                        String type1 = values[2].trim();
                        String type2 = values[3].trim();
                        String classification = values[4].trim();
                        double height_meters = Double.parseDouble(values[5].trim());
                        double weight_kg = Double.parseDouble(values[6].trim());
    
                        String[] abilityArray = values[7].replace("\"", "").split(",");
                        List<String> abilities = Arrays.asList(abilityArray);
    
                        int generation = Integer.parseInt(values[8].trim());
                        String is_legendary = values[9].trim();
    
                        Pokemon pokemon = new Pokemon(name, pokedex_num, type1, type2, classification, 
                                                      height_meters, weight_kg, abilities, generation, is_legendary);
                        pokemons.add(pokemon);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al procesar la línea: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return pokemons;
    }
}
