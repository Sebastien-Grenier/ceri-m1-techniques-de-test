package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {

    @Mock
    IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() throws PokedexException {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613,64,4000,4, 56));
        //when(pokemonFactory.createPokemon(0, 613, -510, 4000, 4)).thenThrow(new PokedexException("Erreur négatif"));
    }

    /*@Test
    void shouldReturnErreurWhenNegatif() throws PokedexException {
        assertEquals(64, pokemonFactory.createPokemon(0, 613, -510, 4000, 4).getHp());
    }*/

    @Test
    void shouldReturnSuccessWhen64() throws PokedexException {
        assertEquals(64, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
    }

    @Test
    void shouldReturnSuccessWhenGetIndex0() throws PokedexException {
        assertEquals(0, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIndex());
    }

    @Test
    void shouldReturnSuccessWhenGetCp613() throws PokedexException {
        assertEquals(613, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp());
    }

    @Test
    void shouldReturnSuccessWhenGetHp64() throws PokedexException {
        assertEquals(64, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
    }

    @Test
    void shouldReturnSuccessWhenGetDust4000() throws PokedexException {
        assertEquals(4000, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust());
    }

    @Test
    void shouldReturnSuccessWhenGetCandy4() throws PokedexException {
        assertEquals(4, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy());
    }

    @Test
    void shouldReturnSuccessWhenGetIV() throws PokedexException {
        assertEquals(56, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIv());
    }

}
