package view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Part;

import model.Lancamento;
import model.Pessoa;
import model.TipoLancamento;
import repository.Pessoas;
import service.GestaoLancamentos;
import service.RegraNegocioException;
import util.FacesUtil;
import util.Repositorios;

	@ManagedBean
	@ViewScoped
	public class CadastroLancamentoBean implements Serializable {

		
		private Repositorios repositorios = new Repositorios();
		private List<Pessoa> pessoas = new ArrayList<Pessoa>();
		private Lancamento lancamento = new Lancamento();
		private transient Part arquivoComprovante;
		
	
		public String init(){
			Pessoas pessoas = this.repositorios.getPessoas();
			this.pessoas = pessoas.todas();
			
		   
		
		/*public String checarPagamento(){
			if(this.lancamento.isPago()){
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lan�amento pago n�o pode ser editado");
				
			 return "ConsultaLancamento";*/
			
		    
			return null;
			
	    }
			
		public void lancamentoPagoModificado(ValueChangeEvent event){
			this.lancamento.setPago((Boolean) event.getNewValue());
			this.lancamento.setDataPagamento(null);
		    FacesContext.getCurrentInstance().renderResponse();
		}
		
		public void uploadComprovante(ActionEvent event){
			if(arquivoComprovante != null){
				try(InputStream is = arquivoComprovante.getInputStream();
					ByteArrayOutputStream out = new ByteArrayOutputStream()){
					
					int read = -1;
					byte[] buffer = new byte[1024];
					
					while((read = is.read(buffer)) != -1){
						out.write(buffer, 0, read);
					}
					
					lancamento.setComprovante(out.toByteArray());
					
				} catch (IOException e) {
				    
					throw new RuntimeException("Erro ao enviar arquivo:", e);
				}	
			}
		}

		public void salvar() {
			GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
			try {
				gestaoLancamentos.salvar(lancamento);
				
				this.lancamento = new Lancamento();
				
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lan�amento salvo com sucesso");
			} catch (RegraNegocioException e) {
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
			}
		}
		
		public boolean isEditando(){
			return this.lancamento.getCodigo() != null;
		}
		
		public TipoLancamento[] getTiposLancamentos() {
			return TipoLancamento.values();
		}

		public Lancamento getLancamento() {
			return lancamento;
		}
		

		public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
			this.lancamento = lancamento;
			if(this.lancamento == null){
				this.lancamento = new Lancamento();
			}else{
				this.lancamento = (Lancamento) lancamento.clone();
			}
		}

		public List<Pessoa> getPessoas() {
			return pessoas;
		}

		public void setPessoas(List<Pessoa> pessoas) {
			this.pessoas = pessoas;
		}

		public Part getArquivoComprovante() {
			return arquivoComprovante;
		}

		public void setArquivoComprovante(Part arquivoComprovante) {
			this.arquivoComprovante = arquivoComprovante;
		}
		
		
		
		
		
	}


