package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    List<Pokemon> pokemonList;

    IPokemonFactory pokemonFactory;

    IPokemonMetadataProvider pokemonMetadataProvider;

    public Pokedex(final IPokemonFactory pokemonFactory, final IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonList = new ArrayList<Pokemon>();
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemonList.size();
    }

    /**
     * Adds the given {@code pokemon} to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size() - 1;
    }

    /**
     * Locates the pokemon identified by the given {@code id}.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given {@code index} is not valid.
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        for (Pokemon buffer : pokemonList) {
            if (buffer.getIndex() == id) {
                return buffer;
            }
        }
        throw new PokedexException("Pokemon does not exist !");
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonList);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given {@code order}.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemonList);
        sortedList.sort(order);
        return Collections.unmodifiableList(sortedList);
    }

    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
