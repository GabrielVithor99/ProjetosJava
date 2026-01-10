package org.dio.digitalinovation.service.imp;

import org.dio.digitalinovation.model.Produto;
import org.dio.digitalinovation.model.ProdutoRespository;
import org.dio.digitalinovation.service.ProdutoService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRespository respository;

    @Override
    public Iterable<Produto> buscarTodos() {
        return respository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id){
        Optional<Produto> produto = respository.findById(id);
        return produto.get();
    }

    @Override
    public void inserir(Produto produto) {
        respository.save(produto);
    }

    @Override
    public void atualizar(Long id, Produto produto) {
        Produto produtoNovo = respository.findById(id).get();
        produtoNovo.setMarca(produto.getMarca());
        produtoNovo.setTipo(produto.getTipo());
        produtoNovo.setPreco(produto.getPreco());
        produtoNovo.setNome(produto.getNome());
        respository.save(produtoNovo);
    }

    @Override
    public void deletar(Long id) {
        respository.deleteById(id);
    }
}
