package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import model.Consulta;
import repository.Consultas;
import util.RepositoriosAtividade;

@FacesConverter(forClass=Consulta.class)
public class ConsultaConverter implements Converter {
	
	private RepositoriosAtividade repositoriosAtividade = new RepositoriosAtividade();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Consulta retorno = null;
		Consultas consultas = (Consultas) this.repositoriosAtividade.getConsultas();
		
		if(value != null && !value.equals("")){
			retorno = consultas.porCodigo(new Integer(value));
			
			if(retorno == null){
				String descricaoErro = "Consulta não existe";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);
			throw new ConverterException(message);
			}
		}
	       
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			Integer codigo = ((Consulta) value).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		
		return null;
		
	}

}


