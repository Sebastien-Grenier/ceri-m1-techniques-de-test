package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class IPokemonFactoryTest {

    @Mock
    IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() throws PokedexException {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613,64,4000,4, 56));
    }

    @Test
    void shouldReturnErreurWhenNegatif() throws PokedexException {
        when(pokemonFactory.createPokemon(0, 613, -510, 4000, 4).getHp()).thenThrow(new PokedexException("Erreur négatif"));
        IPokemonFactory pokemonFactory = null;
        pokemonFactory.createPokemon(0, 613, -510, 4000, 4);
    }

    @Test
    void shouldReturnSuccessWhen64() throws PokedexException {
        assertEquals(64, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
    }

}
