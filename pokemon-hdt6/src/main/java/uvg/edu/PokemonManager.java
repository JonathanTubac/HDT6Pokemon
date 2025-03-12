package uvg.edu;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PokemonManager {
    private static Map<String, Pokemon> pokemonCollection;
    
        // Constructor
        public PokemonManager(String mapType) {
            this.pokemonCollection = PokemonFactory.createMap(mapType);
        }
    
        // Agregar Pokémon a la colección
        public void addPokemon(Pokemon pokemon) {
            if (pokemonCollection.containsKey(pokemon.getName())) {
                System.out.println("Error: Ya tienes este Pokémon en tu colección.");
            } else {
                pokemonCollection.put(pokemon.getName(), pokemon);
                System.out.println("¡Pokémon agregado a tu colección!");
            }
        }
    
        // Buscar Pokémon por nombre
        public Pokemon getPokemonByName(String name) {
            return pokemonCollection.get(name);
        }
    
        // Mostrar la colección de Pokémon ordenada por tipo1
        public void showCollectionSortedByType() {
            pokemonCollection.values().stream()
                    .sorted((p1, p2) -> p1.getType1().compareTo(p2.getType1()))
                    .forEach(System.out::println);
        }
    
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
    
        public static void showAllPokemonsSortedByType(List<Pokemon> pokemons) {
           pokemons.stream()
                    .sorted(Comparator.comparing(Pokemon::getType1)) 
                    .forEach(pokemon -> {
                        System.out.println("Nombre: " + pokemon.getName() + ", Tipo1: " + pokemon.getType1());
                    });
        }
    
        public static void printPokemonCollection() {
            pokemonCollection.forEach((name, pokemon) -> {
            System.out.println("Nombre: " + name + ", Detalles: " + pokemon);
        });
    }
}
