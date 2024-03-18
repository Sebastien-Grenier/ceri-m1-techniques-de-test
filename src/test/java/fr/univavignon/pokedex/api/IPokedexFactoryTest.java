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
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    IPokemonFactory pokemonFactory;

    private PokedexFactory pokedexFactory;

    @BeforeEach
    public void setup() {
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        // Création d'une instance de PokedexFactory
        IPokedexFactory factory = pokedexFactory;

        // Appel de la méthode createPokedex de PokedexFactory
        IPokedex pokedex = factory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        // Vérification que l'objet retourné n'est pas null
        assertNotNull(pokedex);
    }



}
