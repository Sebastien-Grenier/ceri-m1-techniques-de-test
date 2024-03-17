package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static fr.univavignon.pokedex.api.Team.MYSTIC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {
    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    IPokedexFactory pokedexFactory;

    @Mock
    IPokedex pokedex;

    private PokemonTrainer pokemonTrainer;

    @BeforeEach
    public void setup() throws PokedexException {
        when(pokemonTrainerFactory.createTrainer("Red", Team.MYSTIC, pokedexFactory)).thenReturn(new PokemonTrainer("Red", MYSTIC, pokedex));
    }

    @Test
    void shouldReturnRedWhenRed() throws PokedexException {
        assertEquals("Red", pokemonTrainerFactory.createTrainer("Red", MYSTIC, pokedexFactory).getName());
    }

    @Test
    public void shouldReturnRedWhenName() {
        assertEquals("Red", pokemonTrainerFactory.createTrainer("Red", MYSTIC, pokedexFactory).getName());
    }

    @Test
    public void shouldReturnMysticWhenTeam() {
        assertEquals(MYSTIC, pokemonTrainerFactory.createTrainer("Red", MYSTIC, pokedexFactory).getTeam());
    }

    @Test
    public void shouldReturnPokedexWhenPokedex() {
        assertEquals(pokedex, pokemonTrainerFactory.createTrainer("Red", MYSTIC, pokedexFactory).getPokedex());
    }

}
