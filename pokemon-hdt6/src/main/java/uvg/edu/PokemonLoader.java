/**
 * Jonathan Javier Tubac Arreaza 24484
 */
package uvg.edu;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

/**
 * The PokemonFactory class provides a method to create different types of Map implementations for storing Pokémon.
 */
public class PokemonFactory {

    /**
     * Creates a Map implementation based on the specified type.
     *
     * @param mapType The type of Map to create (e.g., "HashMap", "TreeMap", "LinkedHashMap").
     * @return A Map implementation for storing Pokémon.
     * @throws IllegalArgumentException if the specified mapType is not recognized.
     */
    public static Map<String, Pokemon> createMap(String mapType) {
        switch (mapType.toLowerCase()) {
            case "hashmap":
                return new HashMap<>();
            case "treemap":
                return new TreeMap<>();
            case "linkedhashmap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de Map no reconocido.");
        }
    }
}
