package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_personal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Personal extends Usuario {

    @OneToMany(mappedBy = "personal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private java.util.List<Aluno> alunos;
}

