package org.senai.ecommerce.service;

import org.senai.ecommerce.dto.ProdutoDto;
import org.senai.ecommerce.entity.Produto;
import org.senai.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService{

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoPorCodigo(Long codigo) {
        return produtoRepository.findById(codigo);
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long codigo, ProdutoDto produtoDto) {

        Optional<Produto> optionalProduto = produtoRepository.findById(codigo);
        Produto produto = optionalProduto.get();
        BeanUtils.copyProperties(produtoDto, produto);
        produtoRepository.save(produto);
        return produto;
    }

    public void excluirProduto(Long codigo) {
        Optional<Produto> optionalProduto = produtoRepository.findById(codigo);
        Produto produto = optionalProduto.get();
        produtoRepository.delete(produto);
    }
}
