package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokedexTest {

    @Mock
    IPokedex pokedex;

    private Pokemon bulbizarre;
    private Pokemon aquali;
    private ArrayList<Pokemon> pokemonPokedex;

    @BeforeEach
    public void setup() throws PokedexException {
        pokemonPokedex = new ArrayList<>();

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokemonPokedex.add(bulbizarre);
        pokemonPokedex.add(aquali);

        lenient().when(pokedex.getPokemons()).thenReturn(pokemonPokedex);
        lenient().when(pokedex.size()).thenReturn(pokemonPokedex.size());

        lenient().when(pokedex.addPokemon(any(Pokemon.class))).thenAnswer(invoc -> {
            Pokemon inputPokemon = invoc.getArgument(0);
            pokemonPokedex.add(inputPokemon);
            return pokemonPokedex.size() - 1;
        });

        lenient().when(pokedex.getPokemon(any(Integer.class))).thenAnswer(invoc -> {
            int index = invoc.getArgument(0);
            return pokemonPokedex.get(index);
        });
    }

    @Test
    void shouldReturnPokemonsWhenGetPokemons() {
        assertEquals(pokemonPokedex, pokedex.getPokemons());
    }

    @Test
    void shouldReturnSizeWhenGetSize() {
        assertEquals(pokemonPokedex.size(), pokedex.size());
    }

    @Test
    void shouldReturnIndexWhenAddPokemon() throws PokedexException {
        Pokemon newPokemon = new Pokemon(1, "TeteDeNoeud", 100, 100, 100, 1000, 100, 10000, 10, 50.0);
        int index = pokedex.addPokemon(newPokemon);
        assertEquals(pokemonPokedex.size() - 1, index);
        assertEquals(newPokemon, pokemonPokedex.get(index));
    }

    @Test
    void shouldReturnPokemonWhenGetPokemon() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(1));
    }

}
