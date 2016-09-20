package service;

import model.Consulta;
import repository.Consultas;

public class GestaoConsultas {
	
	private Consultas consultas;
	
	public GestaoConsultas(Consultas consultas){
		this.consultas = consultas;
	}

	public void salvar(Consulta consulta) throws RegraNegocioException{
		if(existeLancamentoSemelhante(consulta)){
			throw new RegraNegocioException("Já existe uma consulta igual a este");
		}
		
		this.consultas.guardar(consulta);
	}
	
	private boolean existeLancamentoSemelhante(Consulta consulta){
        Consulta consultaSemelhante = this.consultas.comDadosIguais(consulta);
		
		return consultaSemelhante != null && !consultaSemelhante.equals(consulta);
			
		}
		
	}


