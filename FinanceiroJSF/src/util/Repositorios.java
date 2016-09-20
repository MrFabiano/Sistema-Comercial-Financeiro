package util;

import java.io.Serializable;

import org.hibernate.Session;

import infra.ConsultasHibernates;
import infra.LancamentosHibernate;
import infra.PessoasHibernate;
import repository.Consultas;
import repository.Lancamentos;
import repository.Pessoas;

public class Repositorios implements Serializable{
	
	public Pessoas getPessoas(){
		return new PessoasHibernate(this.getSession());
	}
	
	public Lancamentos getLancamentos(){
		return new LancamentosHibernate(this.getSession());
	}
	
	private Session getSession(){
		return  (Session) FacesUtil.getRequestAttribute("session");
	}

	public Consultas getConsultas() {
		
		return new ConsultasHibernates(this.getSession());
	}


	
	

}
