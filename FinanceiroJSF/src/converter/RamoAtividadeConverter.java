package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import model.Pessoa;
import model.RamoAtividade;
import repository.RamosAtividades;
import util.HibernateUtil;
import util.RepositoriosConsulta;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoAtividadeConverter implements Converter{
	
	private RepositoriosConsulta repositorios = new RepositoriosConsulta();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		RamoAtividade atividade = null;
		
		if(value != null){
			RamosAtividades ramosAtividades = repositorios.getRamosAtividades();
			atividade = ramosAtividades.porCodigo(new Integer(value));
		}
		
		return atividade;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
		return( (RamoAtividade) value).getCodigo().toString();
	}
      return null;
  }
}
