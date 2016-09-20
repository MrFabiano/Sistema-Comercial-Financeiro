package infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import model.Consulta;
import model.RamoAtividade;
import repository.RamosAtividades;

public class RamosAtividadesHibernate implements RamosAtividades {
	
	private Session session;
	
	public RamosAtividadesHibernate(Session session){
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RamoAtividade> todas() {

		return session.createCriteria(RamoAtividade.class)
				.addOrder(Order.asc("descricao"))
				.list();
	}

	@Override
	public RamoAtividade porCodigo(Integer codigo) {
		return (RamoAtividade) session.get(RamoAtividade.class, codigo);
	}

}
