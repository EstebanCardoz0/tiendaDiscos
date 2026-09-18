import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estebancardozo.tiendadiscos.dto.AlbumResponse;
import com.estebancardozo.tiendadiscos.dto.ArtistaResponse;
import com.estebancardozo.tiendadiscos.entity.Album;
import com.estebancardozo.tiendadiscos.entity.Artista;
import com.estebancardozo.tiendadiscos.service.AlbumService;

@RestController
@RequestMapping("api/album")
public class AlbumController {

    private final AlbumService albumser;

    public AlbumController(AlbumService albumService) {
        this.albumser = albumService;
    }

    private AlbumResponse toResponse(Album album) {

        Artista artista = album.getArtista();
        ArtistaResponse artistaResponse = new ArtistaResponse(artista.getId(), artista.getNombre(), artista.getPais());
        AlbumResponse albumResponse = new AlbumResponse(album.getId(), album.getTitulo(), artistaResponse,
                album.getAnio(), album.getDiscografica(), album.getGenero());

        return albumResponse;
    }

}
