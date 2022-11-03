package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {

    public static AnimePostRequestBody createdAnimePostRequestBody() {
        return AnimePostRequestBody.builder()
                .name(AnimeCreator.createdAnimeToBeSaved().getName())
                .build();
    }

}
