package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.Anime;

public class AnimeCreator {

    public static Anime createdAnimeToBeSaved() {
        return Anime.builder()
                .name("Hajime no Ippo")
                .build();
    }
    public static Anime createdValidAnime() {
        return Anime.builder()
                .name("Hajime no Ippo")
                .id(1L)
                .build();
    }
    public static Anime createdValidUpdatedAnime() {
        return Anime.builder()
                .name("Hajime no Ippo")
                .id(1L)
                .build();
    }
}
