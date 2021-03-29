package controleBovinos.exception;

/*
 * Exception lan�ada caso algum dos dados fornecidos forem incorretos.
 */
public class BovinoInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public BovinoInvalidoException() {
		super("Dados Inv�lidos");
	}

	public BovinoInvalidoException(String mensagem) {
		super(mensagem);
	}
	
}
