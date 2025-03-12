package uvg.edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Pokemon> coleccionUsuario = new HashMap<>();
        List<Pokemon> pokemons = null;
        pokemons = PokemonLoader.loadPokemonsFromCSV("src/main/java/uvg/edu/pokemon_data_pokeapi.csv");

        // Solicitar la implementación de Map que el usuario desea
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
            scanner.nextLine(); // Consumir el salto de línea

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
                    PokemonManager.showAllPokemonsSortedByType(pokemons); // Llamar al método de PokemonManager
                    break;
                case 5:
                    System.out.println("Ingrese la habilidad que desea buscar: ");
                    String habilidad = scanner.nextLine();
                    PokemonManager.showPokemonByAbility(pokemons, habilidad); // Llamar al método de PokemonManager
                    break;
                case 6:
                    PokemonManager.printPokemonCollection(); // Llamar al método para ver la colección del usuario
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
