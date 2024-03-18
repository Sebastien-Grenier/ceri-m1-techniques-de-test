package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Récupérer les métadonnées du Pokémon à partir de l'index
        PokemonMetadata metadata = null;
        try {
            metadata = metadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }

        // Créer une instance de Pokemon avec les métadonnées et les statistiques fournies
        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(),
                metadata.getStamina(), cp, hp, dust, candy, 0.0);
    }

}

