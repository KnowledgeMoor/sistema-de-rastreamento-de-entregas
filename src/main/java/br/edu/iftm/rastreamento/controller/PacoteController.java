package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.service.PacoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Pacotes", description = "API do PacoteController")
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private PacoteService pacoteService;

	@GetMapping
	 @Operation(
        summary = "Listar os pacotes",
        tags = {"Pacotes"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Pacote.class))),
        @ApiResponse(responseCode = "204", description = "Nenhum pacote encontrado",
            content = @Content)
    })
	public List<Pacote> getAllPacotes() {
		return pacoteService.getAllPacotes();
	}

	@PostMapping
	@Operation(
        summary = "Criar um novo pacote",
        tags = {"Pacotes"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pacote criado com sucesso",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Pacote.class))),
        @ApiResponse(responseCode = "400", description = "Requisição inválida",
            content = @Content)
    })
	public Pacote createPacote(@RequestBody Pacote pacote) {
		return pacoteService.createPacote(pacote);
	}

	@GetMapping("/{id}")
	@Operation(
        summary = "Buscar pacote usando id",
        tags = {"Pacotes"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Pacote.class))),
        @ApiResponse(responseCode = "404", description = "Pacote não encontrado",
            content = @Content)
    })
	public Pacote getPacoteById(@PathVariable Long id) {
		return pacoteService.getPacoteById(id);
	}

	@PutMapping("/{id}")
	@Operation(
        summary = "Atualizar um pacote",
        tags = {"Pacotes"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Pacote.class))),
        @ApiResponse(responseCode = "404", description = "Pacote não encontrado",
            content = @Content)
    })
	public Pacote updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails) {
		return pacoteService.updatePacote(id, pacoteDetails);
	}

	@DeleteMapping("/{id}")
	@Operation(
        summary = "Excluir um pacote",
        tags = {"Pacotes"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pacote excluído com sucesso",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Pacote não encontrado",
            content = @Content)
    })
	public void deletePacote(@PathVariable Long id) {
		pacoteService.deletePacote(id);
	}

	@GetMapping("/status/{status}")
    @Operation(
        summary = "Buscar pacotes por status",
        description = "Recupera uma lista de pacotes filtrados pelo status fornecido.",
        tags = {"Pacote"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Pacote.class))),
        @ApiResponse(responseCode = "404", description = "Pacotes não encontrados",
            content = @Content)
    })
    public List<Pacote> getPacotesByStatus(@PathVariable String status) {
        return pacoteService.getPacotesbyStatus(status);
    }

    @GetMapping("/destinatario/{destinatario}")
    @Operation(
        summary = "Buscar pacotes por destinatário",
        description = "Recupera uma lista de pacotes filtrados pelo destinatário fornecido.",
        tags = {"Pacote"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação concluida com sucesso",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Pacote.class))),
        @ApiResponse(responseCode = "404", description = "Pacotes não encontrados",
            content = @Content)
    })
    public List<Pacote> getPacotesByDestinatario(@PathVariable String destinatario) {
        return pacoteService.getPacotesbyDestinatario(destinatario);
    }
}