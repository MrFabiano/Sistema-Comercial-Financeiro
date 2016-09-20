package repository;

import java.util.List;

import model.Consulta;

public interface Consultas {

	public List<Consulta> todos();
	public Consulta porCodigo(Integer codigo);
	public Consulta guardar(Consulta consulta);
	public void remover(Consulta consulta);
    public Consulta comDadosIguais(Consulta consulta);
	
}
