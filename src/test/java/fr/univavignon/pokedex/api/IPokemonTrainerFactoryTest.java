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

    @BeforeEach
    public void setup() throws PokedexException {

        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        when(pokemonTrainerFactory.createTrainer("Red", MYSTIC, pokedexFactory)).thenReturn(new PokemonTrainer("Red", MYSTIC, pokedex ));
    }

    @Test
    void shouldReturnRedWhenRed() throws PokedexException {
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        assertEquals("Red", pokemonTrainerFactory.createTrainer("Red", MYSTIC, pokedexFactory).getName());
    }

}
