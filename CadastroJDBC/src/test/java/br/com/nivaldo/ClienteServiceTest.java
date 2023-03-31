/**
 * 
 */
package br.com.nivaldo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.nivaldo.dao.ClienteDaoMock;
import br.com.nivaldo.dao.IClienteDAO;
import br.com.nivaldo.domain.Cliente;
import br.com.nivaldo.exceptions.DAOException;
import br.com.nivaldo.exceptions.TipoChaveNaoEncontradaException;
import br.com.nivaldo.services.ClienteService;
import br.com.nivaldo.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Nivaldo");
		cliente.setCidade("Caruaru");
		cliente.setEnd("End");
		cliente.setEstado("PE");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setIdade(21L);	
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Nivaldo Ferreira");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Nivaldo Ferreira", cliente.getNome());
	}
}
