package controleBovinos.entradaESaida;

import javax.swing.JOptionPane;


public class EntradaESaida {
		
	private EntradaESaida() {
	}
	
	
	/*
	 * Recebe dois parâmetros: mensagem que é a mensagem que será exibida e titulo que será o título da mensagem que será exibida.
	 * Exibe uma mensagem informativa por meio de uma caixa de diálogo.
	 *
	 */
	public static void exibirMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	/*
	 * Recebe dois parâmetros: componente que é a mensagem que será exibida e titulo que será o título da mensagem que será exibida.
	 * Exibe uma mensagem informativa por meio de uma caixa de diálogo.
	 *
	 */
	public static void exibirMensagem(Object componente, String titulo) {
		JOptionPane.showMessageDialog(null, componente, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	/*
	 * Recebe dois parâmetros: mensagem que é a mensagem que será exibida e titulo que será o título da mensagem que será exibida.
	 * Exibe uma mensagem de erro por meio de uma caixa de diálogo.
	 *
	 */
	public static void exibirMensagemDeErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	
}// fim class EntradaESaida
