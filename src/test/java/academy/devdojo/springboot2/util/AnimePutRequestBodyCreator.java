package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {

    public static AnimePutRequestBody createdAnimePutRequestBody() {
        return AnimePutRequestBody.builder()
                .name(AnimeCreator.createdValidUpdatedAnime().getName())
                .build();
    }

}
