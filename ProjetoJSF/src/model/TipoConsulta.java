package model;

public enum TipoConsulta {
	
	FISICA("Fisica"),
	JURIDICA("Juridica");
	
	private String nome;

	private TipoConsulta(String nome) {
		this.nome = nome;
	}

    public String getNome(){
    	return this.nome;
    }
    
	

}
