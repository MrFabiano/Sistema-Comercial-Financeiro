package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import model.Consulta;
import repository.Consultas;
import util.Repositorios;

@FacesConverter(forClass=Consulta.class)
public class ConsultaConverter implements Converter {
	
	private Repositorios repositoriosBean = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Consulta retorno = null;
		Consultas consultas = this.repositoriosBean.getConsultas();
		
		if(value != null && !value.equals("")){
			retorno =  consultas.porCodigo(new Integer(value));
			
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
		Integer codigo =((Consulta) value).getCodigo();
		return codigo == null ? "" : codigo.toString();
	}
      return null;
  }
}


