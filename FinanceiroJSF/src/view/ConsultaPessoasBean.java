package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import model.Consulta;
import repository.Consultas;
import util.ConsultaUtil;
import util.RepositoriosConsulta;


	@ManagedBean
	public class ConsultaPessoasBean {
		
		private RepositoriosConsulta repositorios = new RepositoriosConsulta();
		private List<Consulta> consultas = new ArrayList<Consulta>();
		private Consulta lancamentoSelecionado;
		
		@SuppressWarnings("unchecked")
		@PostConstruct
		public void inicializa(){
			
			Consultas consultas = this.repositorios.getConsultas();
			this.consultas = consultas.todos();
			
			}
		
		public void excluir(){
			
			Consultas consultas = this.repositorios.getConsultas();
			consultas.remover(this.lancamentoSelecionado);
			
		     this.inicializa();
			
			ConsultaUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cliente excluido com sucesso");
		}
		 
			
			
		public List<Consulta> getConsultas() {
			return consultas;
		}



		public Consulta getLancamentoSelecionado() {
			return lancamentoSelecionado;
		}



		public void setLancamentoSelecionado(Consulta lancamentoSelecionado) {
			this.lancamentoSelecionado = lancamentoSelecionado;
		}

		public void setConsultas(List<Consulta> consultas) {
			this.consultas = consultas;
		}
		
		

	}


