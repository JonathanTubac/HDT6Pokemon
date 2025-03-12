package uvg.edu;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * The PokemonManager class provides methods to manage a collection of Pokémon.
 * It allows adding Pokémon to the collection, retrieving Pokémon by name, and displaying the collection in various ways.
 */
public class PokemonManager {
    private static Map<String, Pokemon> pokemonCollection;
    
    /**
     * Constructs a new PokemonManager with the specified type of Map implementation.
     *
     * @param mapType The type of Map to use for storing the Pokémon collection (e.g., "HashMap", "TreeMap", "LinkedHashMap").
     */
    public PokemonManager(String mapType) {
        this.pokemonCollection = PokemonFactory.createMap(mapType);
    }

    /**
     * Adds a Pokémon to the collection.
     *
     * @param pokemon The Pokémon to add to the collection.
     */
    public void addPokemon(Pokemon pokemon) {
        if (pokemonCollection.containsKey(pokemon.getName())) {
            System.out.println("Error: Ya tienes este Pokémon en tu colección.");
        } else {
            pokemonCollection.put(pokemon.getName(), pokemon);
            System.out.println("¡Pokémon agregado a tu colección!");
        }
    }

    /**
     * Retrieves a Pokémon from the collection by its name.
     *
     * @param name The name of the Pokémon to retrieve.
     * @return The Pokémon with the specified name, or null if not found.
     */
    public Pokemon getPokemonByName(String name) {
        return pokemonCollection.get(name);
    }

    /**
     * Displays the Pokémon collection sorted by the primary type (type1).
     */
    public void showCollectionSortedByType() {
        pokemonCollection.values().stream()
                .sorted((p1, p2) -> p1.getType1().compareTo(p2.getType1()))
                .forEach(System.out::println);
    }

    /**
     * Displays all Pokémon that have a specified ability.
     *
     * @param pokemons The list of Pokémon to search.
     * @param habilidad The ability to search for.
     */
    public static void showPokemonByAbility(List<Pokemon> pokemons, String habilidad) {
        final String habilidadLower = habilidad.toLowerCase();

        pokemons.stream()
                .filter(pokemon -> {
                    List<String> habilidades = pokemon.getAbilities();
                    return habilidades.stream()
                            .anyMatch(habilidadPokemon -> habilidadPokemon.toLowerCase().contains(habilidadLower)); 
                })
                .forEach(pokemon -> {
                    System.out.println("Nombre: " + pokemon.getName() + ", Habilidades: " + String.join(", ", pokemon.getAbilities()));
                });
    }

    /**
     * Displays all Pokémon sorted by the primary type (type1).
     *
     * @param pokemons The list of Pokémon to display.
     */
    public static void showAllPokemonsSortedByType(List<Pokemon> pokemons) {
        pokemons.stream()
                .sorted(Comparator.comparing(Pokemon::getType1)) 
                .forEach(pokemon -> {
                    System.out.println("Nombre: " + pokemon.getName() + ", Tipo1: " + pokemon.getType1());
                });
    }

    /**
     * Prints the entire Pokémon collection.
     */
    public static void printPokemonCollection() {
        pokemonCollection.forEach((name, pokemon) -> {
            System.out.println("Nombre: " + name + ", Detalles: " + pokemon);
        });
    }
}