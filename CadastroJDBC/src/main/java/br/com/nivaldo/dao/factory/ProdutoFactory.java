/**
 * 
 */
package br.com.nivaldo.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.nivaldo.domain.Produto;

public class ProdutoFactory {

	
	public static Produto convert(ResultSet rs) throws SQLException {
		Produto prod = new Produto();
		prod.setId(rs.getLong("ID_PRODUTO"));
		prod.setCodigo(rs.getString("CODIGO"));
		prod.setNome(rs.getString("NOME"));
		prod.setDescricao(rs.getString("DESCRICAO"));
		prod.setValor(rs.getBigDecimal("VALOR"));
		prod.setPeso(rs.getInt("PESO"));
		return prod;
	}
}
