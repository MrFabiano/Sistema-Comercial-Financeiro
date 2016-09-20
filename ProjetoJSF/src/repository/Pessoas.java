package repository;

import java.util.List;

import model.Pessoa;

public interface Pessoas  {
	
	public List<Pessoa> todas();
	public Pessoa buscarPorCodigo(Integer codigo);

}
