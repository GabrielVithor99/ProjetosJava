package org.dio.digitalinovation.service.imp;

import org.dio.digitalinovation.model.Cliente;
import org.dio.digitalinovation.model.Endereco;
import org.dio.digitalinovation.model.ClienteRepository;
import org.dio.digitalinovation.model.EnderecoReporistory;
import org.dio.digitalinovation.service.ClienteService;
import org.dio.digitalinovation.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoReporistory enderecoReporistory;
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
        if(clienteRepository.existsById(id)){
            salvarCliente(cliente);
        }
    }

    private void salvarCliente(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoReporistory.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoReporistory.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
