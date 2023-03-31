/**
 * 
 */
package br.com.nivaldo.services;

import br.com.nivaldo.domain.Cliente;
import br.com.nivaldo.exceptions.DAOException;
import br.com.nivaldo.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
