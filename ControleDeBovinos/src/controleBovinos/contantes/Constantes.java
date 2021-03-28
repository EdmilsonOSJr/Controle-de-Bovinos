package controleBovinos.contantes;

public interface Constantes {

	final String SITUACAO[] = {"Em Lactação", "Seca","Vendido", "Morto"};
	
	final String RACA[] = {"Girolando", "Holandês", "Gir", "Jersey"};
	
	final String SEXO[] = {"M", "F"};
	
	final int TAM_BRINCO = 8, TAM_NOME= 20, GESTACAO = 90;
	
	final String MENSAGEM_ERRO = "Valor inválido!!", MENSAGEM_ERRO_DATA = "Data inválida", TITULO_ERRO = "ERRO",
				 MENSAGEM_ERRO_NOME = "Nome inválido.", MENSAGEM_ERRO_BRINCO = "Brinco inválido.", 
				 MENSAGEM_ERRO_BRINCO_PAI = "Brinco do pai inválido.", MENSAGEM_ERRO_BRINCO_MAE = "Brinco da mãe inválido.",
				 FORMATO_DATA = "dd/MM/yyyy", MASCARA_DATA = "##/##/####", MENSAGEM_SUCESSO = "Sucesso",
				 DADO_NAO_SE_APLICA = "Não se aplica.", MAE_INVALIDA = "O brinco da mãe é inválido" , 
				 PAI_INVALIDO = "O brinco do pai é inválido";
	
}
