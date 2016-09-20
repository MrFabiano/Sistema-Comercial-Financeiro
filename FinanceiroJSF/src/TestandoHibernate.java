import java.util.List;

import org.hibernate.Session;

import model.Pessoa;
import model.RamoAtividade;
import util.HibernateUtil;

public class TestandoHibernate {

	@SuppressWarnings("unchecked")
	public static void main(String args[]){

       Session session = HibernateUtil.getSession();
       
       List<Pessoa> pessoas = session.createCriteria(Pessoa.class).list();
       List<RamoAtividade> ramosAtividades = session.createCriteria(RamoAtividade.class).list();
      
       
       for(Pessoa p :  pessoas){
    	   System.out.println(p.getCodigo() + " " + p.getNome() + " ");
       
    		   
      session.close();
   }

	for(RamoAtividade r  : ramosAtividades){
		System.out.println(r.getCodigo() + " " + r.getDescricao() + "");
	}
	
	session.close();
  }
}