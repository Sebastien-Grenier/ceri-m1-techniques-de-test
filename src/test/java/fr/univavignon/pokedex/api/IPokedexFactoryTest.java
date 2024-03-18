package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokedexFactoryTest {

    @Mock
    IPokedexFactory pokedexFactory;

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    IPokemonFactory pokemonFactory;

    @Mock
    IPokedex pokedex;



    @BeforeEach
    public void setup() throws PokedexException {
        IPokedex pokedex = this.pokedex;
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void shouldReturnNewPokedexWhenCreatePokedex() {
        IPokedexFactory factory = this.pokedexFactory;
        IPokedex createdPokedex = factory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        assertEquals(pokedex, createdPokedex);
    }


    @Test
    public void testCreatePokedex() {
        // Appel de la méthode createPokedex de PokedexFactory
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        // Vérification que l'objet retourné n'est pas null
        assertNotNull(pokedex);
    }



}
