package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setup() throws PokedexException {
        MockitoAnnotations.openMocks(this);
        metadataProvider = new PokemonMetadataProvider();
        lenient().when(pokemonMetadataProvider.getPokemonMetadata(0))
                .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        lenient().when(pokemonMetadataProvider.getPokemonMetadata(5000))
                .thenThrow(new PokedexException("Pokemon not found"));
        lenient().when(pokemonMetadataProvider.getPokemonMetadata(-1))
                .thenThrow(new PokedexException("Invalid index"));
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

    @Test
    public void shouldReturnBulbizarreMetadataWhenIndexIs0() throws PokedexException {
        // Given
        int index = 0;
        PokemonMetadata expectedMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

        // When
        PokemonMetadata actualMetadata = metadataProvider.getPokemonMetadata(index);

        // Then
        assertEquals(expectedMetadata.getIndex(), actualMetadata.getIndex());
        assertEquals(expectedMetadata.getName(), actualMetadata.getName());
        assertEquals(expectedMetadata.getAttack(), actualMetadata.getAttack());
        assertEquals(expectedMetadata.getDefense(), actualMetadata.getDefense());
        assertEquals(expectedMetadata.getStamina(), actualMetadata.getStamina());
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
