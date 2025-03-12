package uvg.edu;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

/**
 * Test class for the PokemonManager and Pokemon classes.
 */
public class PokemonTest {

    private PokemonManager pokemonManager;

    /**
     * Sets up the test environment before each test.
     * Initializes the PokemonManager and adds some initial data.
     */
    @Before
    public void setUp() {
        pokemonManager = new PokemonManager("hashmap");
        // Add some initial data to the manager if necessary
        pokemonManager.addPokemon(new Pokemon("Pikachu", 25, "Electric", null, "Mouse Pokémon", 0.4, 6.0, Arrays.asList("Static", "Lightning Rod"), 1, "false"));
        pokemonManager.addPokemon(new Pokemon("Charmander", 4, "Fire", null, "Lizard Pokémon", 0.6, 8.5, Arrays.asList("Blaze", "Solar Power"), 1, "false"));
    }

    /**
     * Tests the addPokemon method of the PokemonManager class.
     * Adds a new Pokemon and verifies that it was added correctly.
     */
    @Test
    public void testAddPokemon() {
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, Arrays.asList("Overgrow", "Chlorophyll"), 1, "false");
        pokemonManager.addPokemon(bulbasaur);
        
        Pokemon retrieved = pokemonManager.getPokemonByName("Bulbasaur");
        assertNotNull(retrieved);
        assertEquals("Bulbasaur", retrieved.getName());
    }

    /**
     * Tests the getPokemonByName method of the PokemonManager class.
     * Retrieves a Pokemon by name and verifies that it was retrieved correctly.
     */
    @Test
    public void testGetPokemonByName() {
        Pokemon pikachu = pokemonManager.getPokemonByName("Pikachu");
        assertNotNull(pikachu);
        assertEquals("Pikachu", pikachu.getName());
    }

    /**
     * Tests the constructor and getter methods of the Pokemon class.
     * Verifies that the Pokemon object is created correctly and the getters return the expected values.
     */
    @Test
    public void testPokemonConstructorAndGetters() {
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", null, "Mouse Pokémon", 0.4, 6.0, Arrays.asList("Static", "Lightning Rod"), 1, "false");
        
        assertEquals("Pikachu", pokemon.getName());
        assertEquals(25, pokemon.getPokedexNum());
        assertEquals("Electric", pokemon.getType1());
        assertEquals(null, pokemon.getType2());
        assertEquals("Mouse Pokémon", pokemon.getClassification());
        assertEquals(0.4, pokemon.getHeightMeters(), 0.01);
        assertEquals(6.0, pokemon.getWeightKg(), 0.01);
        assertEquals(Arrays.asList("Static", "Lightning Rod"), pokemon.getAbilities());
        assertEquals(1, pokemon.getGeneration());
        assertEquals("false", pokemon.getIsLegendary());
    }

    /**
     * Tests the toString method of the Pokemon class.
     * Verifies that the toString method returns the expected string representation of the Pokemon object.
     */
    @Test
    public void testPokemonToString() {
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", null, "Mouse Pokémon", 0.4, 6.0, Arrays.asList("Static", "Lightning Rod"), 1, "false");
        String expected = "Nombre: Pikachu, Pokedex Number: 25, Tipo1: Electric, Tipo2: null, Clasificación: Mouse Pokémon, Altura: 0.4m, Peso: 6.0kg, Habilidades: [Static, Lightning Rod], Generación: 1, Legendario: false";
        
        assertEquals(expected, pokemon.toString());
    }
}