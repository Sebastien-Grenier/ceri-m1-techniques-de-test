package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private List<Pokemon> pokemonList;

    @Mock
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);

        // Create Pokedex with mocks
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        pokemonList = new ArrayList<>();
        pokemonList.add(bulbizarre);
        pokemonList.add(aquali);
    }

    @Test
    void shouldReturnPokemonsWhenGetPokemons() {
        assertEquals(pokemonList, pokedex.getPokemons());
    }

    @Test
    void shouldReturnSizeWhenGetSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    void shouldReturnIndexWhenAddPokemon() throws PokedexException {
        Pokemon newPokemon = new Pokemon(1, "TeteDeNoeud", 100, 100, 100, 1000, 100, 10000, 10, 50.0);
        int index = pokedex.addPokemon(newPokemon);
        assertEquals(2, index);
        assertEquals(newPokemon, pokedex.getPokemon(2));
    }

    @Test
    void shouldReturnPokemonWhenGetPokemon() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(1));
    }

    @Test
    void shouldReturnSortedPokemonsWhenGetPokemonsWithComparator() throws PokedexException {
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);
        List<Pokemon> sortedList = new ArrayList<>(pokemonList);
        sortedList.sort(comparator);

        assertEquals(sortedList, pokedex.getPokemons(comparator));
    }

    @Test
    void shouldReturnPokemonMetadataWhenGetPokemonMetadata() throws PokedexException {
        // Utilisez un index valide correspondant à un Pokémon existant dans le pokedex
        PokemonMetadata expectedMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata actualMetadata = pokedex.getPokemonMetadata(0);

        // Comparaison des champs individuels
        assertEquals(expectedMetadata.getIndex(), actualMetadata.getIndex());
        assertEquals(expectedMetadata.getName(), actualMetadata.getName());
        assertEquals(expectedMetadata.getAttack(), actualMetadata.getAttack());
        assertEquals(expectedMetadata.getDefense(), actualMetadata.getDefense());
        assertEquals(expectedMetadata.getStamina(), actualMetadata.getStamina());
    }

}
