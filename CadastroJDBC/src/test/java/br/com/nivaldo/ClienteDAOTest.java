/**
 * 
 */
package br.com.nivaldo;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.nivaldo.dao.ClienteDAO;
import br.com.nivaldo.dao.IClienteDAO;
import br.com.nivaldo.domain.Cliente;
import br.com.nivaldo.exceptions.DAOException;
import br.com.nivaldo.exceptions.MaisDeUmRegistroException;
import br.com.nivaldo.exceptions.TableException;
import br.com.nivaldo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {
	
	private IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Nivaldo");
		cliente.setCidade("Caruaru");
		cliente.setEnd("End");
		cliente.setEstado("PE");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setIdade(21L);
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Nivaldo");
		cliente.setCidade("Caruaru");
		cliente.setEnd("End");
		cliente.setEstado("PE");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setIdade(21L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Nivaldo");
		cliente.setCidade("Caruaru");
		cliente.setEnd("End");
		cliente.setEstado("PE");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setIdade(21L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
}
