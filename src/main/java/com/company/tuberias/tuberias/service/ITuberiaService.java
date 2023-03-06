package com.company.tuberias.tuberias.service;

import com.company.tuberias.tuberias.response.TuberiaResponseRest;
import org.springframework.http.ResponseEntity;

public interface ITuberiaService {
    public ResponseEntity<TuberiaResponseRest> search();
}
