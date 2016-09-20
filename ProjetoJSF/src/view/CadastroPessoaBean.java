package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Consulta;
import model.RamoAtividade;
import model.TipoConsulta;
import repository.Consultas;
import repository.RamosAtividades;
import service.GestaoConsultas;
import service.RegraNegocioException;
import util.FacesUtil;
import util.RepositoriosAtividade;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable{
	
	private RepositoriosAtividade repositoriosAtividade = new RepositoriosAtividade();
	private List<RamoAtividade> ramosAtividades = new ArrayList<RamoAtividade>();
	private Consulta consulta = new Consulta();
	
	@PostConstruct
	public void init(){
		RamosAtividades ramosAtividades = this.repositoriosAtividade.getRamosAtividades();
		this.ramosAtividades = ramosAtividades.todas();
		
	}
	
	public void salvar(){
	    GestaoConsultas gestaoConsultas = new GestaoConsultas(this.repositoriosAtividade.getConsultas());
	    try {
			gestaoConsultas.salvar(consulta);
			
		    this.consulta = new Consulta();
			
		   FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
			
		}
	}
	
	public boolean isEditando(){
		return this.consulta.getCodigo() != null;
	}
	
	public TipoConsulta[] getTiposConsultas(){
    	return TipoConsulta.values();
    	
    }


	public Consulta getConsulta() {
		return consulta;
	}


	public void setConsulta(Consulta consulta) throws CloneNotSupportedException {
		this.consulta = consulta;
		if(this.consulta == null){
			this.consulta = new Consulta();
		}else{
			this.consulta = (Consulta) consulta.clone();
		}
	}

	public List<RamoAtividade> getRamosAtividades() {
		return ramosAtividades;
	}

	public void setRamosAtividades(List<RamoAtividade> ramosAtividades) {
		this.ramosAtividades = ramosAtividades;
	}
	
    
    

}


