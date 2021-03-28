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
	
	
	
	/*
	 * Recebe dois par�metros: mensagem que � a mensagem que ser� exibida e titulo que ser� o t�tulo da mensagem que ser� exibida.
	 * L� uma string fornecida pelo usu�rio.
	 */
	public static String lerString (String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	/*
	 * Recebe dois par�metros: mensagem que � a mensagem que ser� exibida e titulo que ser� o t�tulo da mensagem que ser� exibida.
	 * L� um float fornecida pelo usu�rio.
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
	 * Recebe dois par�metros: mensagem que � a mensagem que ser� exibida e titulo que ser� o t�tulo da mensagem que ser� exibida.
	 * L� um double fornecida pelo usu�rio.
	 */
	public static double lerDouble (String mensagem, String titulo) {
		return Double.parseDouble(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE));
	}
	
	
	
	/*
	 * Recebe dois par�metros: mensagem que � a mensagem que ser� exibida e titulo que ser� o t�tulo da mensagem que ser� exibida.
	 * L� um int fornecida pelo usu�rio.
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
	 * @param componente a ser exibido na caixa de di�logo
	 * @param titulo a ser exibido na caixa de di�logo
	 * 
	 * Exibe uma mensagem informativa por meio de uma caixa de di�logo.
	 *
	 **/
	public static JTextArea lerTexto(String titulo) {
		
		// cria um �rea de texto e inicializa com determinado tamanho.
		JTextArea entrada = constroiAreaDeTexto("");
		
		// cria uma caixa de dialogo com determinado tamanho
		@SuppressWarnings("unused")
		JDialog caixaDeDialogo = constroiJDialogo(entrada,titulo);
						
		return entrada;
	}
	
	
	
	/*
	 * Recebe uma String que ser� o conte�do.
	 * 
	 * Constroi e retorna uma �rea de texto preenchida pelo conte�do.
	 * 
	 */	
	public static JTextArea constroiAreaDeTexto(String conteudo) {
		
		// cria uma �rea de texto com 20 de altura e 30 de largura
		JTextArea areaDeTexto = new JTextArea(20,30);
		
		// Define a quebra autom�tica das linha de texto.
		areaDeTexto.setLineWrap(true);
		
		// Define que a quebra autom�tica das linha de texto ocorra entre palavras.
		areaDeTexto.setWrapStyleWord(true);
		
		// Adiciona � �rea de texto um conte�ddo
		areaDeTexto.setText(conteudo);
		
		// Define uma borda para a �rea de texto
		areaDeTexto.setBorder(BorderFactory.createEtchedBorder());
		
		return areaDeTexto;
	}// fim constroiAreaDoTexto
	
	
	
	/*
	 * Recebe uma JTextArea que ser� o conte�do da caixa de di�logo e uma String que ser� o t�tulo da caixa de di�logo.
	 * 
	 * Constroi e retorna uma caixa de di�logo preenchida pela entrada e com o t�tulo fornecidos no par�metro.
	 * 
	 */	
	public static JDialog constroiJDialogo(JTextArea entrada, String titulo) {
		
		// cria uma caixa de di�logo.
		JDialog caixaDeDialogo = new JDialog();
					
		// Define o t�tulo da caixa de di�logo.
		caixaDeDialogo.setTitle(titulo);
		
		// Adiciona o conte�do � caixa de di�logo
		caixaDeDialogo.add(new JScrollPane(entrada));

		// Exibe a caixa de di�logo com o tamanho do seu conte�do
		caixaDeDialogo.pack();
		
		// Define a caixa de di�logo como modal.
		caixaDeDialogo.setModalityType(ModalityType.APPLICATION_MODAL);
		
		// Define a caixa de di�logo como n�o redimension�vel.
		caixaDeDialogo.setResizable(false);
		
		// Posiciona a caixa de di�logo sobre a janela.
		caixaDeDialogo.setLocationRelativeTo(null);
		
		// Exibe a caixa de di�logo.
		caixaDeDialogo.setVisible(true);
		
		
		return caixaDeDialogo;
	}// fim constroiDialogo
	
	
}// fim class EntradaESaida
