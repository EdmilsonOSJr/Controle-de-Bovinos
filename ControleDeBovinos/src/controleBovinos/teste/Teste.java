package controleBovinos.teste;

import controleBovinos.Bean.BovinoBean;
import controleBovinos.DAO.DAO;
import controleDeBovinos.model.Bovino;

public class Teste {

	public static void main(String[] args) {
		
		Bovino bovino = new Bovino();
		
		bovino.setBrinco("brinco 1");
		bovino.setBrincoMae("brinco 1 mae");
		bovino.setBrincoPai("brinco 1 pai");
		bovino.setNome("gado");
		
		BovinoBean bBean = new BovinoBean();
		
		bBean.setBovino(bovino);
		
		bBean.gravar();
		
		//DAO<Bovino> dao = new DAO<>(Bovino.class);
		
		//dao.adiciona(bovino);
	}
	
	
}
