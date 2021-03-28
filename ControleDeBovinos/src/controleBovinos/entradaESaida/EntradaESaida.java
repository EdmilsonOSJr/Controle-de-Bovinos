package controleBovinos.entradaESaida;

import javax.swing.JTextArea;


import java.awt.Dialog.ModalityType;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


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
	
	
	
	/*
	 * Recebe dois parâmetros: mensagem que é a mensagem que será exibida e titulo que será o título da mensagem que será exibida.
	 * Lê uma string fornecida pelo usuário.
	 */
	public static String lerString (String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	/*
	 * Recebe dois parâmetros: mensagem que é a mensagem que será exibida e titulo que será o título da mensagem que será exibida.
	 * Lê um float fornecida pelo usuário.
	 */
	public static Float lerFloat (String mensagem, String titulo) {
		
		String entrada = lerString(mensagem, titulo);
		
		if(entrada!=null)
			if(entrada.matches("(\\d+)(,*)(\\d*)")) {
				entrada = entrada.replace(',', '.');
				return Float.parseFloat(entrada);
			}
			else
				return -1f;
		else
			return null;
		//return Float.parseFloat(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE));
	}
	
	
	
	/*
	 * Recebe dois parâmetros: mensagem que é a mensagem que será exibida e titulo que será o título da mensagem que será exibida.
	 * Lê um double fornecida pelo usuário.
	 */
	public static double lerDouble (String mensagem, String titulo) {
		return Double.parseDouble(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE));
	}
	
	
	
	/*
	 * Recebe dois parâmetros: mensagem que é a mensagem que será exibida e titulo que será o título da mensagem que será exibida.
	 * Lê um int fornecida pelo usuário.
	 */
	public static Integer lerInt (String mensagem, String titulo) {
		String entrada = lerString(mensagem, titulo);
		if(entrada!=null)
			if(entrada.matches("\\d+"))
				return Integer.parseInt(entrada);
			else
				return -1;
		else
			return null;
	}
	
	
	
	/*
	 * @param componente a ser exibido na caixa de diálogo
	 * @param titulo a ser exibido na caixa de diálogo
	 * 
	 * Exibe uma mensagem informativa por meio de uma caixa de diálogo.
	 *
	 **/
	public static JTextArea lerTexto(String titulo) {
		
		// cria um área de texto e inicializa com determinado tamanho.
		JTextArea entrada = constroiAreaDeTexto("");
		
		// cria uma caixa de dialogo com determinado tamanho
		@SuppressWarnings("unused")
		JDialog caixaDeDialogo = constroiJDialogo(entrada,titulo);
						
		return entrada;
	}
	
	
	
	/*
	 * Recebe uma String que será o conteúdo.
	 * 
	 * Constroi e retorna uma área de texto preenchida pelo conteúdo.
	 * 
	 */	
	public static JTextArea constroiAreaDeTexto(String conteudo) {
		
		// cria uma área de texto com 20 de altura e 30 de largura
		JTextArea areaDeTexto = new JTextArea(20,30);
		
		// Define a quebra automática das linha de texto.
		areaDeTexto.setLineWrap(true);
		
		// Define que a quebra automática das linha de texto ocorra entre palavras.
		areaDeTexto.setWrapStyleWord(true);
		
		// Adiciona à área de texto um conteúddo
		areaDeTexto.setText(conteudo);
		
		// Define uma borda para a área de texto
		areaDeTexto.setBorder(BorderFactory.createEtchedBorder());
		
		return areaDeTexto;
	}// fim constroiAreaDoTexto
	
	
	
	/*
	 * Recebe uma JTextArea que será o conteúdo da caixa de diálogo e uma String que será o título da caixa de diálogo.
	 * 
	 * Constroi e retorna uma caixa de diálogo preenchida pela entrada e com o título fornecidos no parâmetro.
	 * 
	 */	
	public static JDialog constroiJDialogo(JTextArea entrada, String titulo) {
		
		// cria uma caixa de diálogo.
		JDialog caixaDeDialogo = new JDialog();
					
		// Define o título da caixa de diálogo.
		caixaDeDialogo.setTitle(titulo);
		
		// Adiciona o conteúdo à caixa de diálogo
		caixaDeDialogo.add(new JScrollPane(entrada));

		// Exibe a caixa de diálogo com o tamanho do seu conteúdo
		caixaDeDialogo.pack();
		
		// Define a caixa de diálogo como modal.
		caixaDeDialogo.setModalityType(ModalityType.APPLICATION_MODAL);
		
		// Define a caixa de diálogo como não redimensionável.
		caixaDeDialogo.setResizable(false);
		
		// Posiciona a caixa de diálogo sobre a janela.
		caixaDeDialogo.setLocationRelativeTo(null);
		
		// Exibe a caixa de diálogo.
		caixaDeDialogo.setVisible(true);
		
		
		return caixaDeDialogo;
	}// fim constroiDialogo
	
	
}// fim class EntradaESaida
