package fr.uga.l3miage.spring.tp2.exo1.repositories;


import fr.uga.l3miage.exo1.enums.GenreMusical;
import fr.uga.l3miage.spring.tp2.exo1.models.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
)
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void testRequestCountByGenreMusicalEquals() {

        // given

        ArtistEntity artistEntity = ArtistEntity
                .builder()
                .name("grand corps malade")
                .biography("mesdames")
                .genreMusical(GenreMusical.SLAM)
                .build();
        ArtistEntity artistEntity1 = ArtistEntity
                .builder()
                .name("GCM")
                .biography("dimanche soir")
                .genreMusical(GenreMusical.SLAM)
                .build();
        artistRepository.save(artistEntity);
        artistRepository.save(artistEntity1);

        // when
        int nbArtistEntitiesResponses = artistRepository.countByGenreMusicalEquals(GenreMusical.SLAM);

        int nbArtistRap = artistRepository.countByGenreMusicalEquals(GenreMusical.RAP);

        // then
        assertThat(nbArtistEntitiesResponses).isEqualTo(2);
        assertThat(nbArtistRap).isEqualTo(0);

    }
}
