package com.bntu.timetable.service.api.deanery;

import com.bntu.timetable.entity.Deanery;

import java.util.List;
import java.util.UUID;

public interface DeaneryService {

    Deanery createDeanery (Deanery deanery);

    Deanery updateDeanery (Deanery deanery);

    Deanery getDeanery(UUID id);

    void deleteDeanery(UUID id);

    List<Deanery> getDeaneries();

}
