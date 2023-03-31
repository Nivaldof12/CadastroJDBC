/**
 * 
 */
package br.com.nivaldo.services;

import br.com.nivaldo.dao.IProdutoDAO;
import br.com.nivaldo.domain.Produto;
import br.com.nivaldo.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
