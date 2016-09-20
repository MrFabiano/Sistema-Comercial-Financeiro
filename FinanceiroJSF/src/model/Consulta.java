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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Consulta implements Serializable, Cloneable{
		private static final long serialVersionUID = 1L;
		
		private Integer codigo;
		private String nome;
	    private TipoPessoa tipo;
		private String email;
		private Date dataNascimento;
		private RamoAtividade ramoAtividade; 
	
    @Id
    @GeneratedValue
    @Column
	public Integer getCodigo() {
			return codigo;
		}
		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}
		
		@Column
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		@Enumerated(EnumType.STRING)
		public TipoPessoa getTipo() {
			return tipo;
		}
		public void setTipo(TipoPessoa tipo) {
			this.tipo = tipo;
		}
		
		@Column
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


