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

    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokedexFactory pokedexFactory;
    IPokemonFactory pokemonFactory;
    IPokedex pokedex;

    @BeforeEach
    public void initTestEnvironment() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(pokemonFactory, pokemonMetadataProvider);
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void createPokedexTest() {
        assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }



}
