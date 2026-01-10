package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Personal;
import me.dio.academia.digital.dto.PersonalForm;

import java.util.List;

public interface PersonalService {

    Personal create(PersonalForm form);

    Personal getById(Long id);

    List<Personal> getAll();

    Personal update(Long id, PersonalForm form);

    void delete(Long id);

    Personal adicionarAluno(Long personalId, Long alunoId);
}

