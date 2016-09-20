package util;

import java.io.Serializable;

import org.hibernate.Session;

import infra.ConsultasHibernates;
import infra.RamosAtividadesHibernate;
import repository.Consultas;
import repository.RamosAtividades;

public class RepositoriosConsulta implements Serializable{

	public RamosAtividades getRamosAtividades(){
		return new RamosAtividadesHibernate(this.getSession());
		
	}
	
	public Consultas getConsultas(){
		return new ConsultasHibernates(this.getSession());
	}
	
    private Session getSession(){
    	return (Session) FacesUtil.getRequestAttribute("session");
    }
	
}
