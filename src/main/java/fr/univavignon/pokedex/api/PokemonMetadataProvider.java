package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    // Map pour stocker les métadonnées des Pokémon par index
    private final Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetadataProvider() {
        // Initialisation de la map des métadonnées
        this.metadataMap = new HashMap<>();
        // Exemple d'ajout de métadonnées pour le Pokémon Bulbizarre (index 0)
        this.metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        this.metadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        // Ajoutez d'autres métadonnées pour d'autres Pokémon si nécessaire
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index)  {

        return metadataMap.get(index);
    }
}
