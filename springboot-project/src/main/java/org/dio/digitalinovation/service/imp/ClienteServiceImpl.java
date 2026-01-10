package org.dio.digitalinovation.service.imp;

import org.dio.digitalinovation.model.Cliente;
import org.dio.digitalinovation.model.Endereco;
import org.dio.digitalinovation.model.ClienteRepository;
import org.dio.digitalinovation.model.EnderecoRepository;
import org.dio.digitalinovation.service.ClienteService;
import org.dio.digitalinovation.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
    
    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarCliente(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Cliente novoCliente = clienteRepository.findById(id).get();
        novoCliente.setEndereco(gerarEndereco(cliente));
        novoCliente.setNome(cliente.getNome());
        clienteRepository.save(novoCliente);
    }

    private void salvarCliente(Cliente cliente) {
       Endereco endereco = gerarEndereco(cliente);
       cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }

    private  Endereco gerarEndereco(Cliente cliente){
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        return endereco;
    }
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
