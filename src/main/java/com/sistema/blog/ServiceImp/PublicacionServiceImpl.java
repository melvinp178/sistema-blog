package com.sistema.blog.ServiceImp;

import com.sistema.blog.Dto.PublicacionDto;
import com.sistema.blog.entities.PublicacionEntity;
import com.sistema.blog.repository.PublicacionRepository;
import com.sistema.blog.service.PublicacionService;
import org.springframework.stereotype.Service;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    private PublicacionRepository publicacionRepository;

    public PublicacionServiceImpl(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {
        //se convierte de dto a entity
        PublicacionEntity publicacionEntity = new PublicacionEntity();
        publicacionEntity.setTitulo(publicacionDto.getTitulo());
        publicacionEntity.setContenido(publicacionDto.getContenido());
        publicacionEntity.setDescripcion(publicacionDto.getDescripcion());

        PublicacionEntity newPublicacion = publicacionRepository.save(publicacionEntity);

        //se convierte de entity a dto
        PublicacionDto publicacionRespuesta = new PublicacionDto();

        publicacionDto.setId(newPublicacion.getId());
        publicacionDto.setTitulo(newPublicacion.getTitulo());
        publicacionDto.setContenido(newPublicacion.getContenido());
        publicacionDto.setDescripcion(newPublicacion.getDescripcion());
        return publicacionRespuesta;
    }
}
