package uvg.edu;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PokemonLoader {
    public static List<Pokemon> loadPokemonsFromCSV(String filePath) {
        List<Pokemon> pokemons = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Para leer la cabecera y evitar procesarla
    
            while ((line = br.readLine()) != null) {
                // Usamos una expresión regular para dividir la línea correctamente
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    
                // Verificar si hay suficientes valores (10 columnas)
                if (values.length >= 10) {
                    try {
                        String name = values[0].trim();
                        int pokedex_num = Integer.parseInt(values[1].trim());
                        String type1 = values[2].trim();
                        String type2 = values[3].trim();
                        String classification = values[4].trim();
                        double height_meters = Double.parseDouble(values[5].trim());
                        double weight_kg = Double.parseDouble(values[6].trim());
    
                        // El campo de habilidades contiene varias habilidades separadas por comas
                        String[] abilityArray = values[7].replace("\"", "").split(",");
                        List<String> abilities = Arrays.asList(abilityArray);
    
                        int generation = Integer.parseInt(values[8].trim());
                        String is_legendary = values[9].trim();
    
                        // Crear el objeto Pokémon con los datos extraídos
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
