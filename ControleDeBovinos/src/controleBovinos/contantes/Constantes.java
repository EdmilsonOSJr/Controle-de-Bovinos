package controleBovinos.contantes;

public interface Constantes {

	final String SITUACAO[] = {"Em Lacta��o", "Seca","Vendido", "Morto"};
	
	final String RACA[] = {"Girolando", "Holand�s", "Gir", "Jersey"};
	
	final String SEXO[] = {"M", "F"};
	
	final int TAM_BRINCO = 8, TAM_NOME= 20, TAM_SITUACAO= 15, TAM_RACA= 15, TAM_SEXO= 1, GESTACAO = 90;
	
	final String MENSAGEM_ERRO = "Valor inv�lido!!", MENSAGEM_ERRO_DATA = "Data inv�lida", TITULO_ERRO = "ERRO", TITULO_SUCESSO = "SUCESSO",
				 MENSAGEM_ERRO_NOME = "Nome inv�lido.", MENSAGEM_ERRO_BRINCO = "Brinco inv�lido.", 
				 MENSAGEM_ERRO_BRINCO_PAI = "Brinco do pai inv�lido.", MENSAGEM_ERRO_BRINCO_MAE = "Brinco da m�e inv�lido.",
				 FORMATO_DATA = "dd/MM/yyyy", MASCARA_DATA = "##/##/####", MENSAGEM_SUCESSO = "Cadastro realizado com sucesso",
				 DADO_NAO_SE_APLICA = "N�o se aplica.", MENSAGEM_ERRO_PERSISTENCIA = "Erro ao cadastrar bovino.", DADO_NAO_INFORMADO = " - ";
	
}
