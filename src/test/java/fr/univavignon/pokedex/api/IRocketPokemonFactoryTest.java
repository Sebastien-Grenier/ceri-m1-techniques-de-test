package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IRocketPokemonFactoryTest {

    RocketPokemonFactory rocketPokemonFactory;
    Pokemon bulbizarre;

    @BeforeEach
    public void setup() throws PokedexException {
        rocketPokemonFactory = new RocketPokemonFactory();
        bulbizarre = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
    }


    @Test
    public void testCreatePokemonWithValidIndex() {
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(createdPokemon);
        assertEquals(createdPokemon.getName(), bulbizarre.getName());
        assertEquals(createdPokemon.getCp(), bulbizarre.getCp());
        assertEquals(createdPokemon.getHp(), bulbizarre.getHp());
        assertEquals(createdPokemon.getDust(), bulbizarre.getDust());
        assertEquals(createdPokemon.getCandy(), bulbizarre.getCandy());

    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(999, 2729, 202, 5000, 4);
        assertNotNull(createdPokemon);
        assertEquals("MISSINGNO", createdPokemon.getName());
    }
}