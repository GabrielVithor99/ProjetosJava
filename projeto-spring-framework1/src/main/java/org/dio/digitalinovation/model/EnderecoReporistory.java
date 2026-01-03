package org.dio.digitalinovation.model;

import jakarta.persistence.Id;
import org.dio.digitalinovation.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoReporistory extends CrudRepository<Endereco,String> {

}
