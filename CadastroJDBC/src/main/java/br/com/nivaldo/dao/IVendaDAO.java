/**
 * 
 */
package br.com.nivaldo.dao;

import br.com.nivaldo.dao.generic.IGenericDAO;
import br.com.nivaldo.domain.Venda;
import br.com.nivaldo.exceptions.DAOException;
import br.com.nivaldo.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
