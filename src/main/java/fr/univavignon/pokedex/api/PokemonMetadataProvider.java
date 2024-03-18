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
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Vérifiez si les métadonnées pour cet index existent dans la map
        if (metadataMap.containsKey(index)) {
            // Si oui, retournez les métadonnées correspondantes
            return metadataMap.get(index);
        } else {
            // Sinon, lancez une exception indiquant que l'index du Pokémon n'est pas valide
            throw new PokedexException("Invalid Pokemon index: " + index);
        }
    }
}