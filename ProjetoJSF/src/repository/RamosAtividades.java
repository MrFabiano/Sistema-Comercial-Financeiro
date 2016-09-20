package repository;

import java.util.List;

import model.RamoAtividade;

public interface RamosAtividades {
	
	public List<RamoAtividade> todas();
	public RamoAtividade porCodigo(Integer codigo);

}