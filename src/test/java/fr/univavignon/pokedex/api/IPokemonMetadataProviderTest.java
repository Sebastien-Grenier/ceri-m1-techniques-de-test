package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    public void setup() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        Mockito.lenient().when(pokemonMetadataProvider.getPokemonMetadata(5000)).thenThrow(new PokedexException("Pokemon not found"));
        Mockito.lenient().when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));
    }

    @Test
    void shouldReturnCorrectIndex() throws PokedexException {
        assertEquals(0, pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
    }

    @Test
    void shouldReturnCorrectName() throws PokedexException {
        assertEquals("Bulbizarre", pokemonMetadataProvider.getPokemonMetadata(0).getName());
    }

    @Test
    void shouldReturnCorrectAttack() throws PokedexException {
        assertEquals(126, pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
    }

    @Test
    void shouldReturnCorrectDefense() throws PokedexException {
        assertEquals(126, pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
    }

    @Test
    void shouldReturnCorrectStamina() throws PokedexException {
        assertEquals(90, pokemonMetadataProvider.getPokemonMetadata(0).getStamina());
    }

    /*

    @Test
    void shouldThrowExceptionForNotFoundPokemon() {
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(5000));
    }

    @Test
    void shouldThrowExceptionForInvalidIndex() {
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }
    */


}
