package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:DesignForExtension"})
    @Override
    public PokemonTrainer createTrainer(final String name, final Team team, final IPokedexFactory pokedexFactory) {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        return new PokemonTrainer(name, team, pokedex);
    }
}
