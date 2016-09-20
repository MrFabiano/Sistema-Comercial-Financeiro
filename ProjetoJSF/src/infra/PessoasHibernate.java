package infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import model.Pessoa;
import repository.Pessoas;

public class PessoasHibernate implements Pessoas{
	
	private Session session;
	
	public PessoasHibernate(Session session){
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todas() {
		return session.createCriteria(Pessoa.class).list();
	}

	@Override
	public Pessoa buscarPorCodigo(Integer codigo) {
		return (Pessoa) this.session.get(Pessoa.class, codigo);
	}

}
