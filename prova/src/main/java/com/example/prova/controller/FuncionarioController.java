package com.example.prova.controller;

import com.example.prova.model.Funcionario;
import com.example.prova.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController //Indica que a classe é um controlador REST.
@RequestMapping("/funcionarios") // // Define o caminho base das rotas deste controlador como "/funcionarios".
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    //Construtor
    public  FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    // Mapeia requisições GET para "/funcionarios".
    // Retorna a lista de todos os funcionários cadastrados.
    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    // Mapeia requisições POST para "/funcionarios"
    // Recebe um objeto Funcionario no corpo da requisição (em formato JSON) e o salva no sistema
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionário " + funcionario.getNome() + " cadastrado com sucesso."));
    }

    // Mapeia requisições PUT para "/funcionarios"
    // Atualiza os dados de um funcionário existente com base no JSON enviado
    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem","Usuário atualizado com sucesso."));
    }

    // Mapeia requisições DELETE para "/funcionarios/{id}"
    // Remove o funcionário com o ID especificado
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem","Usuário exluído com sucesso."));
    }


}
