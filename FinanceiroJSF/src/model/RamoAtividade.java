package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RamoAtividade implements Serializable{
		 private static final long serialVersionUID = 1L;
		 
			private Integer codigo;
			 private String descricao;
			  
			 public RamoAtividade(){
				 
			 }
			 
			 public RamoAtividade(Integer codigo, String descricao){
				 this.codigo = codigo;
				 this.descricao = descricao;
				 
			 }
			 
			 @Id
			 @GeneratedValue
			public Integer getCodigo() {
				return codigo;
			}
			public void setCodigo(Integer codigo) {
				this.codigo = codigo;
			}
			public String getDescricao() {
				return descricao;
			}
			public void setDescricao(String descricao) {
				this.descricao = descricao;
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
				RamoAtividade other = (RamoAtividade) obj;
				if (codigo == null) {
					if (other.codigo != null)
						return false;
				} else if (!codigo.equals(other.codigo))
					return false;
				return true;
			}
			 
			 
		}

