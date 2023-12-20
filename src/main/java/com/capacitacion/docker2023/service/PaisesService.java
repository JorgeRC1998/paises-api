package com.capacitacion.docker2023.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capacitacion.docker2023.dao.PaisesDao;
import com.capacitacion.docker2023.dto.RespuestaDto;
import com.capacitacion.docker2023.entity.PaisEntity;

@Service
public class PaisesService {
    @Autowired
    PaisesDao paisesDao;

    public List<PaisEntity> getPaises(){
        return paisesDao.findAll();
    }

    public Optional<PaisEntity> getPaisesPorId(Long id){
        return paisesDao.findById(id);
    }
    
    public RespuestaDto crearPais(PaisEntity paisEntity){
        paisesDao.save(paisEntity);
        RespuestaDto respuestaDto = new RespuestaDto(true, "pais creado correctamente");
        return respuestaDto;    
    }

    public RespuestaDto actualizarPais(PaisEntity paisEntity){
        PaisEntity paisNuevo = paisesDao.getReferenceById(paisEntity.getId().longValue());
        paisNuevo.setNombre(paisEntity.getNombre());
        paisNuevo.setCapital(paisEntity.getCapital());
        paisesDao.save(paisNuevo);
        RespuestaDto respuestaDto = new RespuestaDto(true, "pais actualizado correctamente");
        return respuestaDto;    
    }

    public RespuestaDto eliminarPais(Long id){
        paisesDao.deleteById(id);
        RespuestaDto respuestaDto = new RespuestaDto(true, "pais eliminado correctamente");
        return respuestaDto;    
    }

}
