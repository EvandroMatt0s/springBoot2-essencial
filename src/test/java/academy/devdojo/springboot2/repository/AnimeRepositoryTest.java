package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.AnimeCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Log4j2
@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persist anime when Successful")
    void save_PersitiAnime_WhenSuccessful() {
        Anime createdAnimeToBeSaved = AnimeCreator.createdAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(createdAnimeToBeSaved);

        Assertions.assertThat(animeSaved).isNotNull();

        Assertions.assertThat(animeSaved.getId()).isNotNull();

        Assertions.assertThat(animeSaved.getName()).isEqualTo(createdAnimeToBeSaved.getName());

    }

    @Test
    @DisplayName("Save updates anime when Successful")
    void save_UpdatesAnime_WhenSuccessful() {
        Anime createdAnimeToBeSaved = AnimeCreator.createdAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(createdAnimeToBeSaved);

        animeSaved.setName("Overlord");

        Anime animeUpdate = this.animeRepository.save(animeSaved);

        Assertions.assertThat(animeUpdate).isNotNull();

        Assertions.assertThat(animeUpdate.getId()).isNotNull();

        Assertions.assertThat(animeUpdate.getName()).isEqualTo(animeSaved.getName());
    }

    @Test
    @DisplayName("Delete removes anime when Successful")
    void delete_RemoveAnime_WhenSuccessful() {
        Anime createdAnimeToBeSaved = AnimeCreator.createdAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(createdAnimeToBeSaved);

        this.animeRepository.delete(animeSaved);

        Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());

        Assertions.assertThat(animeOptional.isEmpty());
    }

    @Test
    @DisplayName("Find By name return list of anime when Successful")
    void findByName_ReturnListOfAnime_WhenSuccessful() {
        Anime createdAnimeToBeSaved = AnimeCreator.createdAnimeToBeSaved();

        Anime animeSaved = this.animeRepository.save(createdAnimeToBeSaved);

        String name = animeSaved.getName();

        List<Anime> animes = this.animeRepository.findByName(name);

        Assertions.assertThat(animes)
                .isNotEmpty()
                .contains(animeSaved);
    }

    @Test
    @DisplayName("Find By Name returns empty list  when no anime is found")
    void findByName_ReturnsEmptyList_whenAnimeIsNotFound() {
        List<Anime> animes = this.animeRepository.findByName("xaxa");

        Assertions.assertThat(animes).isEmpty();
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void save_throwsConstraintViolationException_WhenNameIsEmpty() {
        Anime anime = new Anime();
        Assertions.assertThatThrownBy(() -> this.animeRepository.save(anime))
                .isInstanceOf(ConstraintViolationException.class);
        /*Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.animeRepository.save(anime))
                .withMessageContaining("The Anime name cannot be empty");*/
    }
    
}