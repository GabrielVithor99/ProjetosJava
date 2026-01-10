package me.dio.academia.digital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AlunoUpdateForm {

  private String nome;

  private String bairro;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataDeNascimento;
}
