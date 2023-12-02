package org.senai.ecommerce.controller;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.senai.ecommerce.dto.ProdutoDto;
import org.senai.ecommerce.entity.Produto;
import org.senai.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Operation(description = "Busca todos produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endpoint para buscar os produtos"),
            @ApiResponse(code = 400, message = "Não existem produtos")})
    @GetMapping("/todos")
    public ResponseEntity<?> getProdutos() {
        return new ResponseEntity<>(produtoService.getProdutos(), HttpStatus.OK);
    }

    @Operation(description = "Busca um produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endpoint para buscar um produto"),
            @ApiResponse(code = 400, message = "Não existe produto")})
    @GetMapping("/{codigo}")
    public ResponseEntity<?> getProdutoPorCodigo(@PathVariable Long codigo) {
        return new ResponseEntity<>(produtoService.getProdutoPorCodigo(codigo), HttpStatus.OK);
    }

    @Operation(description = "Adicionar um produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endpoint para adicionar os produtos"),
            @ApiResponse(code = 400, message = "Produto invalido")})
    @PostMapping("/add")
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.criarProduto(produto), HttpStatus.CREATED);
    }


    @Operation(description = "Editar produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endpoint para editar os produtos"),
            @ApiResponse(code = 400, message = "Não existem produtos")})
    @PutMapping("/{codigo}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long codigo, @RequestBody ProdutoDto produtoDto) {
        return new ResponseEntity<>(produtoService.atualizarProduto(codigo, produtoDto), HttpStatus.OK);
    }

    @Operation(description = "Deleta produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endpoint para deletar os produtos"),
            @ApiResponse(code = 400, message = "Não existem produtos")})
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long codigo) {
        produtoService.excluirProduto(codigo);
        return new ResponseEntity<>("Produto Excluído do Sucesso!", HttpStatus.OK);
    }
}
