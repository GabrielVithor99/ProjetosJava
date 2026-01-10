package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Personal;
import me.dio.academia.digital.dto.PersonalForm;
import me.dio.academia.digital.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personais")
public class PersonalController {

    @Autowired
    private PersonalService service;

    // Criar um novo Personal usando PersonalForm
    @PostMapping
    public Personal create(@RequestBody PersonalForm form) {
        return service.create(form);
    }

    // Buscar Personal por ID
    @GetMapping("/{id}")
    public Personal getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Listar todos os Personais
    @GetMapping
    public List<Personal> getAll() {
        return service.getAll();
    }

    // Atualizar Personal por ID usando PersonalForm
    @PutMapping("/{id}")
    public Personal update(@PathVariable Long id, @RequestBody PersonalForm form) {
        return service.update(id, form);
    }

    // Deletar Personal por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Adicionar aluno pelo id
    @PostMapping("/{personalId}/alunos/{alunoId}")
    public Personal adicionarAluno(@PathVariable Long personalId, @PathVariable Long alunoId) {
        return service.adicionarAluno(personalId, alunoId);
    }
}