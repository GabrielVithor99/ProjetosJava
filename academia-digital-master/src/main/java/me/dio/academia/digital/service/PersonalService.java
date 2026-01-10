package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Personal;
import java.util.List;

public interface PersonalService {

    Personal create(Personal personal);

    Personal getById(Long id);

    List<Personal> getAll();

    Personal update(Long id, Personal personal);

    void delete(Long id);
}
