package digitalinovation.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoReporistory extends CrudRepository<Endereco,String> {

}
