package uvg.edu;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class PokemonFactory {
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
