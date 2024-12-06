package br.edu.ifpe.jaboatao.ts.servicos;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.LocacaoException;

public class LocacaoServiceTest {
	private LocacaoService locacaoService;

	@BeforeEach
	public void setup() {
		locacaoService = new LocacaoService();
	}

	@Test
	@DisplayName("Alugando uma roupa")
	public void teste01() throws LocacaoException {
		locacaoService.setPromocao(true);
		Locacao locacao = locacaoService.alugarRoupa(new Cliente("cliente 1"),
				List.of(new Roupa("roupa 1", "M", 1, 10.0)));
		Assertions.assertEquals(10, locacao.getValorLocacao());
	}

	@DisplayName("Alugando 2 roupas")
	public void teste02() throws LocacaoException {
		locacaoService.setPromocao(true);
		Locacao locacao = locacaoService.alugarRoupa(new Cliente("cliente 1"),
				List.of(new Roupa("roupa 1", "M", 1, 10.0),
						new Roupa("roupa 2", "M", 1, 10.0)));
		Assertions.assertEquals(20 * 0.9, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Alugando 3 roupas")
	public void teste03() throws LocacaoException {
		locacaoService.setPromocao(true);
		Locacao locacao = locacaoService.alugarRoupa(new Cliente("cliente 1"),
				List.of(new Roupa("roupa 1", "M", 1, 10.0),
						new Roupa("roupa 2", "M", 1, 10.0),
						new Roupa("roupa 3", "M", 1, 10.0)));
		Assertions.assertEquals(30 * 0.85, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Alugando 4 roupas")
	public void teste04() throws LocacaoException {
		locacaoService.setPromocao(true);
		Locacao locacao = locacaoService.alugarRoupa(new Cliente("cliente 1"),
				List.of(new Roupa("roupa 1", "M", 1, 10.0),
						new Roupa("roupa 2", "M", 1, 10.0),
						new Roupa("roupa 3", "M", 1, 10.0),
						new Roupa("roupa 4", "M", 1, 10.0)));
		Assertions.assertEquals(40 * 0.75, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Alugando 5 roupas")
	public void teste05() throws LocacaoException {
		locacaoService.setPromocao(true);
		Locacao locacao = locacaoService.alugarRoupa(new Cliente("cliente 1"),
				List.of(new Roupa("roupa 1", "M", 1, 10.0),
						new Roupa("roupa 2", "M", 1, 10.0),
						new Roupa("roupa 3", "M", 1, 10.0),
						new Roupa("roupa 4", "M", 1, 10.0),
						new Roupa("roupa 5", "M", 1, 10.0)));
		Assertions.assertEquals(50 * 0.5, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Alugando 6 roupas")
	public void teste06() throws LocacaoException {
		locacaoService.setPromocao(true);
		Locacao locacao = locacaoService.alugarRoupa(new Cliente("cliente 1"),
				List.of(new Roupa("roupa 1", "M", 1, 10.0),
						new Roupa("roupa 2", "M", 1, 10.0),
						new Roupa("roupa 3", "M", 1, 10.0),
						new Roupa("roupa 4", "M", 1, 10.0),
						new Roupa("roupa 5", "M", 1, 10.0),
						new Roupa("roupa 6", "M", 1, 10.0)));
		Assertions.assertEquals(60 * 0.5, locacao.getValorLocacao());
	}

}
