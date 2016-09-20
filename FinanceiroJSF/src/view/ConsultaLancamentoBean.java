package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import model.Lancamento;
import repository.Lancamentos;
import service.GestaoLancamentos;
import service.RegraNegocioException;
import util.FacesUtil;
import util.Repositorios;


	@ManagedBean
	public class ConsultaLancamentoBean {
		
		private Repositorios repositorios = new Repositorios();
		private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		private Lancamento lancamentoSelecionado;
		
		@SuppressWarnings("unchecked")
		@PostConstruct
		public void inicializar(){
			Lancamentos lancamentos = this.repositorios.getLancamentos();
            this.lancamentos = lancamentos.todos();
            
		    }
		
		public void excluir(){
			    GestaoLancamentos gestaoLancamentos = new  GestaoLancamentos(this.repositorios.getLancamentos());
			try{
				gestaoLancamentos.excluir(this.lancamentoSelecionado);
				
				this.inicializar();
				
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluido com sucesso");
			}catch(RegraNegocioException e){
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
			}
		}
		
		
		public List<Lancamento> getLancamentos(){
			return lancamentos;
		}

		public Lancamento getLancamentoSelecionado() {
			return lancamentoSelecionado;
		}

		public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
			this.lancamentoSelecionado = lancamentoSelecionado;
		}
		
		

	}


