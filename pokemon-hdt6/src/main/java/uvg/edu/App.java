/**
 * Jonathan Javier Tubac Arreaza 24484
 */
package uvg.edu;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
/**
 * The App class is the main entry point for the Pokémon management application.
 * It allows users to interact with a collection of Pokémon through a console-based menu.
 * Users can add Pokémon to their collection, view details of specific Pokémon, and perform various other operations.
 */
public class App {
    /**
     * The main method that runs the Pokémon management application.
     * It provides a console-based menu for users to interact with their Pokémon collection.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Pokemon> pokemons = null;
        pokemons = PokemonLoader.loadPokemonsFromCSV("src/main/java/uvg/edu/pokemon_data_pokeapi.csv");

        System.out.print("Seleccione la implementación de Map (HashMap, TreeMap, LinkedHashMap): ");
        String mapType = scanner.nextLine();

        PokemonManager manager = new PokemonManager(mapType);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar Pokémon en la colección, ordenados por tipo1");
            System.out.println("4. Mostrar todos los Pokémon, ordenados por tipo1");
            System.out.println("5. Mostrar Pokémon con una habilidad");
            System.out.println("6. Ver la colección del usuario");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String nombre = scanner.nextLine();
                    Optional<Pokemon> pokemonOpt = pokemons.stream().filter(p -> p.getName().equalsIgnoreCase(nombre))
                            .findFirst();
                    if (pokemonOpt.isPresent()) {
                        manager.addPokemon(pokemonOpt.get());
                    } else {
                        System.out.println("Error: Pokémon no encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon a buscar: ");
                    nombre = scanner.nextLine();
                    pokemonOpt = pokemons.stream().filter(p -> p.getName().equalsIgnoreCase(nombre)).findFirst();
                    pokemonOpt.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Error: Pokémon no encontrado."));
                    break;
                case 3:
                    manager.showCollectionSortedByType();
                    break;
                case 4:
                    long inicio4 = System.nanoTime();
                    PokemonManager.showAllPokemonsSortedByType(pokemons); 
                    long fin4 = System.nanoTime();
                    System.out.println("Tiempo de ejecución: " + (fin4 - inicio4));
                    break;
                case 5:
                    System.out.println("Ingrese la habilidad que desea buscar: ");
                    String habilidad = scanner.nextLine();
                    PokemonManager.showPokemonByAbility(pokemons, habilidad); 
                    break;
                case 6:
                    PokemonManager.printPokemonCollection(); 
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}
