package uvg.edu;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PokemonLoader {
    public static List<Pokemon> loadPokemonsFromCSV(String filePath) throws IOException {
        List<Pokemon> pokemons = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // Leer la primera fila (encabezados) y omitirla
        reader.readLine(); 

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");

            try {
                String name = values[0];
                String pokedexNumStr = values[1].trim();
                String type1 = values[2];
                String type2 = values[3];
                String classification = values[4];
                String heightStr = values[5].trim();
                String weightStr = values[6].trim();
                String abilitiesStr = values[7].replace("\"", "").trim();
                String generationStr = values[8].trim();  // Cambiar a String
                String isLegendary = values[9];

                // Imprimir los valores antes de convertirlos
                System.out.println("pokedex_num: " + pokedexNumStr + ", height_meters: " + heightStr + ", weight_kg: " + weightStr + ", generation: " + generationStr);

                // Convertir los valores a los tipos correctos
                int pokedex_num = Integer.parseInt(pokedexNumStr);
                double height_meters = Double.parseDouble(heightStr);
                double weight_kg = Double.parseDouble(weightStr);
                List<String> abilities = Arrays.asList(abilitiesStr.split(","));

                // Cambiar la generación a String
                String generation = generationStr; // Mantener como String

                // Crear un objeto Pokemon y agregarlo a la lista
                Pokemon pokemon = new Pokemon(name, pokedex_num, type1, type2, classification, height_meters, weight_kg, abilities, generation, isLegendary);
                pokemons.add(pokemon);

            } catch (NumberFormatException e) {
                System.out.println("Error al procesar la línea: " + line);
                System.out.println("No se puede convertir a número uno de los valores: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Faltan columnas en la línea: " + line);
            }
        }
        reader.close();
        return pokemons;
    }
}
