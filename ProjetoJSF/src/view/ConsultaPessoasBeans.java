package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import model.Consulta;
import repository.Consultas;
import util.FacesUtil;
import util.RepositoriosAtividade;

@ManagedBean
public class ConsultaPessoasBeans {
	
	private RepositoriosAtividade repositoriosAtividade = new RepositoriosAtividade();
	private List<Consulta> consultas = new ArrayList<Consulta>();
	private Consulta lancamentoSelecioando;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar(){
		Consultas consultas = this.repositoriosAtividade.getConsultas();
	    this.consultas = consultas.todos();
		
	  }
	
	public void excluir(){
		Consultas consultas = this.repositoriosAtividade.getConsultas();
		consultas.remover(this.lancamentoSelecioando);
		
		this.inicializar();
		
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Consulta excluido com sucesso");
		
	}
	
     public List<Consulta> getConsultas(){
		return consultas;
	}

	public Consulta getLancamentoSelecioando() {
		return lancamentoSelecioando;
	}

	public void setLancamentoSelecioando(Consulta lancamentoSelecioando) {
		this.lancamentoSelecioando = lancamentoSelecioando;
	}


     

}
