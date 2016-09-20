package service;

import model.Consulta;
import repository.Consultas;

public class GestaoConsultas {
	
	private Consultas consultas;
	
	public GestaoConsultas(Consultas consultas){
		this.consultas = consultas;
	}
	
	public void salvar(Consulta consulta) throws RegraNegocioException{
        if(existeConsultaSemelhante(consulta)){
			throw new RegraNegocioException("Já existe uma cadastro igual a este");
		}
		
		this.consultas.guardar(consulta);
	}
	
	private boolean existeConsultaSemelhante(Consulta consulta){
		Consulta consultaSemelhante = this.consultas.comDadosIguais(consulta);
		return consultaSemelhante != null && !consultaSemelhante.equals(consulta);
	}

}
