package com.company.tuberias.dao;

import org.springframework.data.repository.CrudRepository;
import com.company.tuberias.tuberias.entity.Tuberias;
public interface ITuberiaDao extends CrudRepository<Tuberias, Long> {
}
