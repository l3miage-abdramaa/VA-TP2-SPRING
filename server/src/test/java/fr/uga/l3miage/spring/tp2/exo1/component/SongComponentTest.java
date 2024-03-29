package fr.uga.l3miage.spring.tp2.exo1.component;

import fr.uga.l3miage.spring.tp2.exo1.components.SongComponent;
import fr.uga.l3miage.spring.tp2.exo1.exceptions.technical.NotFoundSongEntityException;
import fr.uga.l3miage.spring.tp2.exo1.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@AutoConfigureTestDatabase
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
public class SongComponentTest {

    @Autowired
    private SongComponent songComponent;

    @MockBean
    private SongRepository songRepository;

    void getSongNotFound() {

        // Given

        //when(playlistRepository.findById(anyString())).thenReturn(Optional.empty());
        when(songRepository.findById(anyString())).thenReturn(Optional.empty());

        // then-when
        // assertThrows(NotFoundPlaylistEntityException.class,()->playlistComponent.getPlaylist("test"));
        assertThrows(NotFoundSongEntityException.class,()->songComponent.getSongEntityById("test"));
    }
}
