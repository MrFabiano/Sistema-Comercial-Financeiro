package infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Consulta;
import repository.Consultas;

public class ConsultasHibernate implements Consultas{
	
	private Session session;
	
	public ConsultasHibernate(Session session){
		this.session = session;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Consulta> todos() {
		
		return session.createCriteria(Consulta.class).list();
	}



	@Override
	public Consulta guardar(Consulta consulta) {
		return  (Consulta) session.merge(consulta);
	}


	@Override
	public void remover(Consulta consulta) {
	     this.session.delete(consulta);
		
	}


	@Override
	public Consulta comDadosIguais(Consulta consulta) {
		return (Consulta) this.session.createCriteria(Consulta.class)
				.add(Restrictions.eq("nome", consulta.getNome()))
				.add(Restrictions.eq("tipo", consulta.getTipo()))
				.add(Restrictions.eq("email", consulta.getEmail()))
				.add(Restrictions.eq("dataNascimento", consulta.getDataNascimento()))
				.add(Restrictions.eq("ramoAtividade", consulta.getRamoAtividade()))
				.uniqueResult();
	}
	
	@Override
	public Consulta porCodigo(Integer codigo) {
		return (Consulta) this.session.get(Consulta.class, codigo);
	}

}
