package controleBovinos.entradaESaida;

import javax.swing.JOptionPane;


public class EntradaESaida {
		
	private EntradaESaida() {
	}
	
	
	/*
	 * Recebe dois par�metros: mensagem que � a mensagem que ser� exibida e titulo que ser� o t�tulo da mensagem que ser� exibida.
	 * Exibe uma mensagem informativa por meio de uma caixa de di�logo.
	 *
	 */
	public static void exibirMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	/*
	 * Recebe dois par�metros: componente que � a mensagem que ser� exibida e titulo que ser� o t�tulo da mensagem que ser� exibida.
	 * Exibe uma mensagem informativa por meio de uma caixa de di�logo.
	 *
	 */
	public static void exibirMensagem(Object componente, String titulo) {
		JOptionPane.showMessageDialog(null, componente, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	/*
	 * Recebe dois par�metros: mensagem que � a mensagem que ser� exibida e titulo que ser� o t�tulo da mensagem que ser� exibida.
	 * Exibe uma mensagem de erro por meio de uma caixa de di�logo.
	 *
	 */
	public static void exibirMensagemDeErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	
}// fim class EntradaESaida
