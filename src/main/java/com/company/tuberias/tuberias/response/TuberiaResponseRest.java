package com.company.tuberias.tuberias.response;
import  com.company.tuberias.response.ResponseRest;
import com.company.tuberias.response.TuberiaResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TuberiaResponseRest extends ResponseRest {
    private TuberiaResponse tuberiaResponse = new TuberiaResponse();
}
