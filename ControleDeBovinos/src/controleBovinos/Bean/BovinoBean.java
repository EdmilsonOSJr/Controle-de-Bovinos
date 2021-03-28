package controleBovinos.Bean;

import controleBovinos.DAO.DAO;
import controleDeBovinos.model.Bovino;

public class BovinoBean {
	
	
	private Bovino bovino = new Bovino();
	private Long idbovino;

	public Bovino getBovino() {
		return bovino;
	}

	public void setBovino(Bovino bovino) {
		this.bovino = bovino;
	}

	public Long getIdbovino() {
		return idbovino;
	}

	public void setIdbovino(Long idbovino) {
		this.idbovino = idbovino;
	}

	public void gravar() {
		
		try {
			DAO<Bovino> dao = new DAO<Bovino>(Bovino.class);
			dao.adiciona(bovino);
			this.bovino = new Bovino();
		} catch (Exception e) {
			System.out.println("O bonivo já existe.");
		}
	}
	

	
}
