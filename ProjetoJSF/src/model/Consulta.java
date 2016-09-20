package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table
public class Consulta implements Serializable, Cloneable {
	
	private Integer codigo;
	private String nome;
	private TipoConsulta tipo;
	private String email;
	private Date dataNascimento;
	private RamoAtividade ramoAtividade;
	
	@Id
	@GeneratedValue
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Enumerated(EnumType.STRING)
	public TipoConsulta getTipo() {
		return tipo;
	}
	public void setTipo(TipoConsulta tipo) {
		this.tipo = tipo;
	}
	
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_ramoatividade")
	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	

}
