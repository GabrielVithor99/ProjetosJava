package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "tb_aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Aluno extends Usuario {

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "personal_id", referencedColumnName = "id")
  @JsonBackReference
  @JsonIgnore
  private Personal personal;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<AvaliacaoFisica> avaliacoes;
}

