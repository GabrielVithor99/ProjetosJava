package me.dio.academia.digital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoForm {

  private String nome;
  private String cpf;
  private String bairro;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataDeNascimento;

  private Long personalId; // opcional
}

