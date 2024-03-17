package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void shouldReturnBulbizarreWhen0() throws PokedexException {
        assertEquals(0, pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
    }

    /*
    @Test
    void shouldReturnInvalidWhenNegatif1() throws PokedexException {
        assertEquals(-1, pokemonMetadataProvider.getPokemonMetadata(-1).getIndex());
    }


    @Test
    void shouldReturnNotFoundWhen5000() throws PokedexException {
        assertEquals(5000, pokemonMetadataProvider.getPokemonMetadata(5000).getIndex());
    }

     */

}
