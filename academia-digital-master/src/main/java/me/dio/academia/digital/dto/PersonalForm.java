package me.dio.academia.digital.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Data
public class PersonalForm {

    private String nome;
    private String cpf;
    private String bairro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
}


