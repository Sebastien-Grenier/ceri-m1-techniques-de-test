package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemons;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        int index = pokemons.size();
        pokemons.add(pokemon);
        return index;
    }

    @Override
    public Pokemon getPokemon(int id) {
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return List.copyOf(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return List.copyOf(sortedPokemons);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) {

        Pokemon pokemon = pokemons.get(index);
        return new PokemonMetadata(
                pokemon.getIndex(),
                pokemon.getName(),
                pokemon.getAttack(),
                pokemon.getDefense(),
                pokemon.getStamina()
        );
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
