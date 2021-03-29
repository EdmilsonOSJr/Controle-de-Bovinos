package controleBovinos.exception;

/*
 * Exception lançada caso algum dos dados fornecidos forem incorretos.
 */
public class BovinoInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public BovinoInvalidoException() {
		super("Dados Inválidos");
	}

	public BovinoInvalidoException(String mensagem) {
		super(mensagem);
	}
	
}
