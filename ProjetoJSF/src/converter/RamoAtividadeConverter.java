package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import model.RamoAtividade;
import repository.RamosAtividades;
import util.FacesUtil;
import util.HibernateUtil;
import util.RepositoriosAtividade;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoAtividadeConverter implements Converter{
	
	private RepositoriosAtividade repositoriosAtividade = new RepositoriosAtividade();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		RamoAtividade retorno = null;
		
		if(value != null){
			
			RamosAtividades ramosAtividades = repositoriosAtividade.getRamosAtividades();
			retorno = ramosAtividades.porCodigo(new Integer(value));
			
			}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if( value != null){
			return ((RamoAtividade) value).getCodigo().toString();
		}
		
		return null;
	}

}
