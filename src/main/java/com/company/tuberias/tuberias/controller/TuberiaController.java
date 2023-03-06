package com.company.tuberias.tuberias.controller;

import com.company.tuberias.tuberias.response.TuberiaResponseRest;
import com.company.tuberias.tuberias.service.ITuberiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TuberiaController {
    @Autowired
    private ITuberiaService service;
    @GetMapping("/tuberias")
    public ResponseEntity<TuberiaResponseRest> searchTuberias(){
        ResponseEntity<TuberiaResponseRest> response = service.search();
        return response;
    }
}
