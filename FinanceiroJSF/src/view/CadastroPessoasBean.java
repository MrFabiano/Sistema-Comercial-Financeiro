package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Consulta;
import model.RamoAtividade;
import model.TipoPessoa;
import repository.RamosAtividades;
import service.GestaoConsultas;
import service.RegraNegocioException;
import util.FacesUtil;
import util.RepositoriosConsulta;


@ManagedBean
@ViewScoped
public class CadastroPessoasBean implements Serializable{
		
	    private RepositoriosConsulta repositorios = new RepositoriosConsulta();
		private List<RamoAtividade> ramosAtividades = new ArrayList<RamoAtividade>();
		private Consulta consulta = new Consulta();
		
		@SuppressWarnings("unchecked")
		@PostConstruct
		public void init(){
			RamosAtividades ramosAtividades = this.repositorios.getRamosAtividades();
			this.ramosAtividades = ramosAtividades.todas();
			
	     }
		
		public void cadastrar(){
			
			GestaoConsultas gestaoConsultas = new GestaoConsultas(this.repositorios.getConsultas());
			try {
				gestaoConsultas.salvar(consulta);
				
				this.consulta = new Consulta();
				
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso");
			} catch (RegraNegocioException e) {
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
			}
		}
		
		public boolean isEditando(){
			return this.consulta.getCodigo() != null;
		}
		
		public TipoPessoa[] getTiposPessoas(){
			return TipoPessoa.values();
		}

		public List<RamoAtividade> getRamosAtividades() {
			return ramosAtividades;
		}

		public void setRamosAtividades(List<RamoAtividade> ramosAtividades) {
			this.ramosAtividades = ramosAtividades;
		}

		public Consulta getConsulta() {
			return consulta;
		}
		

		public RepositoriosConsulta getRepositorios() {
			return repositorios;
		}

		public void setRepositorios(RepositoriosConsulta repositorios) {
			this.repositorios = repositorios;
		}

		public void setConsulta(Consulta consulta) throws CloneNotSupportedException {
			this.consulta = consulta;
			if(this.consulta == null){
				this.consulta = new Consulta();
			}else{
				this.consulta = (Consulta) consulta.clone();
			}
		}
		
	}

