package com.company.tuberias.response;

import java.util.List;
import com.company.tuberias.tuberias.entity.Tuberias;
import lombok.Data;

@Data
public class TuberiaResponse {
    private List<Tuberias> tuberias;
}
