package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.PokemonMetadata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
    }

    @Test
    void shouldReturnBulbizarreWhen0() throws PokedexException {
        assertEquals(1, pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
    }

}
