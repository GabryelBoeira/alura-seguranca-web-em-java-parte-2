package br.com.alura.owasp.validator;

import br.com.alura.owasp.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;

@Component
public class ImagemValidator {
    /**
     * Treats an image by saving it to the server's file system and updating the user's image name.
     *
     * @param  imagem   the image file to be treated
     * @param  usuario  the user object to update with the new image name
     * @param  request  the HTTP servlet request object
     * @return          true if the image was successfully treated, false otherwise
     * @throws IllegalStateException if the MultipartFile is in an invalid state
     * @throws IOException          if an I/O error occurs while treating the image
     */
    public boolean tratarImagem(MultipartFile imagem, Usuario usuario,
                              HttpServletRequest request) throws IllegalStateException, IOException {

        ByteArrayInputStream bytesImagem = new ByteArrayInputStream(imagem.getBytes());
        String mime = URLConnection.guessContentTypeFromStream(bytesImagem);
        if (mime == null) return false;

        usuario.setNomeImagem(imagem.getOriginalFilename());
        File arquivo = new File(request.getServletContext().getRealPath(
                "/image"), usuario.getNomeImagem());
        imagem.transferTo(arquivo);

        return true;
    }

}
