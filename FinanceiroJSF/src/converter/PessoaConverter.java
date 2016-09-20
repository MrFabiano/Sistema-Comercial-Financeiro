package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import model.Pessoa;
import repository.Pessoas;
import util.FacesUtil;
import util.HibernateUtil;
import util.Repositorios;

	@FacesConverter(forClass=Pessoa.class)
	public class PessoaConverter implements Converter {
		
		private Repositorios repositorios = new Repositorios();

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Pessoa retorno = null;
			
			if(value != null){
				Pessoas pessoas = repositorios.getPessoas();
                retorno = pessoas.porCodigo(new Integer(value));
		   }
			
			return retorno;
			
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if(value != null){
			return( (Pessoa) value).getCodigo().toString();
		}
	      return null;
	  }
	}

