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
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() throws PokedexException {
        pokemonFactory = new PokemonFactory(metadataProvider);

        // Définir le comportement du mock metadataProvider
        when(metadataProvider.getPokemonMetadata(0))
                .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        // Définir le comportement du mock pokemonFactory
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
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
        assertEquals(0, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIv());
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        // Définir le comportement attendu du mock
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        // Appeler la méthode à tester
        Pokemon pokemon = pokemonFactory.createPokemon(0, 100, 100, 2000, 3);

        // Vérifier si le résultat est conforme aux attentes
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
        assertEquals(100, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(2000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());
    }

}
