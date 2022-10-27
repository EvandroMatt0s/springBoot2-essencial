package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class,2);
        log.info(entity);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class,2);

        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> exchange= new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Anime>>() {
                });

        log.info(exchange.getBody());

    }
}
