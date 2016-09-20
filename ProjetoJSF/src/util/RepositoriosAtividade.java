package util;

import java.io.Serializable;

import org.hibernate.Session;

import infra.ConsultasHibernate;
import infra.RamosAtividadesHibernate;
import repository.Consultas;
import repository.RamosAtividades;

@SuppressWarnings("serial")
public class RepositoriosAtividade implements Serializable{
	
	public RamosAtividades getRamosAtividades(){
		return new RamosAtividadesHibernate((Session)FacesUtil.getRequestAttribute("session"));
	}
	
	public Consultas getConsultas(){
		return new ConsultasHibernate(this.getSession());
	}
	
	@SuppressWarnings("unused")
	private Session getSession(){
		return (Session)FacesUtil.getRequestAttribute("session"); 
	}

}
