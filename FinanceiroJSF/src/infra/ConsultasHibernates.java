package infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.Consulta;
import repository.Consultas;

public class ConsultasHibernates implements Consultas{
	
	private Session session;
	
	public ConsultasHibernates(Session session){
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consulta> todos() {
		
		return session.createCriteria(Consulta.class)
				.addOrder(Order.desc("email"))
				.list();
	}

	@Override
	public Consulta porCodigo(Integer codigo) {
		
		return (Consulta) this.session.get(Consulta.class, codigo);
	}

	@Override
	public Consulta guardar(Consulta consulta) {
		return (Consulta) session.merge(consulta);
	}

	@Override
	public void remover(Consulta consulta) {
		this.session.delete(consulta);
		
	}

	@Override
	public Consulta comDadosIguais(Consulta consulta) {
		
		return (Consulta) this.session.createCriteria(Consulta.class)
				.add(Restrictions.ilike("nome", consulta.getNome()))
				.add(Restrictions.eq("tipo", consulta.getTipo()))
				.add(Restrictions.eq("email", consulta.getEmail()))
				.add(Restrictions.eq("dataNascimento", consulta.getDataNascimento()))
				.add(Restrictions.eq("ramoAtividade", consulta.getRamoAtividade()))
				.uniqueResult();
	}

}
