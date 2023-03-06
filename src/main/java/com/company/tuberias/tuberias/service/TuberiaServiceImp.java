package com.company.tuberias.tuberias.service;

import com.company.tuberias.dao.ITuberiaDao;
import com.company.tuberias.tuberias.response.TuberiaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.company.tuberias.tuberias.entity.Tuberias;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TuberiaServiceImp implements ITuberiaService {

    @Autowired
    private ITuberiaDao tuberiaDao;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<TuberiaResponseRest> search() {
        TuberiaResponseRest response = new TuberiaResponseRest();
        try {
            List<Tuberias> tuberias = (List<Tuberias>) tuberiaDao.findAll();
            response.getTuberiaResponse().setTuberias(tuberias);
            response.setMetadata("Respuesta Ok", "00", "Respuesta exitosa");
        }catch (Exception e){
            response.setMetadata("Respuesta no Ok", "-1", "error al consultar");
            e.getStackTrace();
            return  new ResponseEntity<TuberiaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<TuberiaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<TuberiaResponseRest> searchById(Long id) {
        TuberiaResponseRest response = new TuberiaResponseRest();
        List<Tuberias> list = new ArrayList<>();
        try {
            Optional<Tuberias> tuberia = tuberiaDao.findById(id);
            if(tuberia.isPresent()){
                list.add(tuberia.get());
                response.getTuberiaResponse().setTuberias(list);
                response.setMetadata("Respuesta  Ok", "00", "categoria encontrada");
            }else{
                response.setMetadata("Respuesta no Ok", "-1", "categoria no encontrada");
                return  new ResponseEntity<TuberiaResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response.setMetadata("Respuesta no Ok", "-1", "error al consultar por id");
            e.getStackTrace();
            return  new ResponseEntity<TuberiaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<TuberiaResponseRest>(response, HttpStatus.OK);
    }
}
