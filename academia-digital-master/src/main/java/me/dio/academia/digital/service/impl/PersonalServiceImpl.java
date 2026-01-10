package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Personal;
import me.dio.academia.digital.dto.PersonalForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.PersonalRepository;
import me.dio.academia.digital.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Personal create(PersonalForm form) {
        Personal personal = Personal.builder()
                .nome(form.getNome())
                .cpf(form.getCpf())
                .bairro(form.getBairro())
                .dataDeNascimento(form.getDataDeNascimento())
                .build();
        return personalRepository.save(personal);
    }

    @Override
    public Personal getById(Long id) {
        return personalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal não encontrado"));
    }

    @Override
    public List<Personal> getAll() {
        return personalRepository.findAll();
    }

    @Override
    public Personal update(Long id, PersonalForm form) {
        Personal existing = getById(id);
        existing.setNome(form.getNome());
        existing.setCpf(form.getCpf());
        existing.setBairro(form.getBairro());
        existing.setDataDeNascimento(form.getDataDeNascimento());
        return personalRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        personalRepository.deleteById(id);
    }

    @Override
    public Personal adicionarAluno(Long personalId, Long alunoId) {
        Personal personal = getById(personalId);
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setPersonal(personal);
        personal.getAlunos().add(aluno);
        alunoRepository.save(aluno);
        return personalRepository.save(personal);
    }
}