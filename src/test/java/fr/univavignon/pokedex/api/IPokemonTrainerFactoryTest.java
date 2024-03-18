package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static fr.univavignon.pokedex.api.Team.MYSTIC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    private PokemonTrainer pokemonTrainer;

    @BeforeEach
    public void setup() throws PokedexException {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();

        pokemonTrainer = pokemonTrainerFactory.createTrainer("Red", Team.MYSTIC, pokedexFactory);
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
        assertNotNull(pokemonTrainer.getPokedex());
    }

    @Test
    public void testCreateTrainer() {
        assertNotNull(pokemonTrainerFactory.createTrainer("Red", MYSTIC, pokedexFactory));
    }




}
