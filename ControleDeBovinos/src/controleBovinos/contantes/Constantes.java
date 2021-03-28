package controleBovinos.contantes;

public interface Constantes {

	final String SITUACAO[] = {"Em Lactação", "Seca","Vendido", "Morto"};
	
	final String RACA[] = {"Girolando", "Holandês", "Gir", "Jersey"};
	
	final String SEXO[] = {"M", "F"};
	
	final int TAM_BRINCO = 8, TAM_NOME= 20, TAM_SITUACAO= 15, TAM_RACA= 15, TAM_SEXO= 1, GESTACAO = 90;
	
	final String MENSAGEM_ERRO = "Valor inválido!!", MENSAGEM_ERRO_DATA = "Data inválida", TITULO_ERRO = "ERRO", TITULO_SUCESSO = "SUCESSO",
				 MENSAGEM_ERRO_NOME = "Nome inválido.", MENSAGEM_ERRO_BRINCO = "Brinco inválido.", 
				 MENSAGEM_ERRO_BRINCO_PAI = "Brinco do pai inválido.", MENSAGEM_ERRO_BRINCO_MAE = "Brinco da mãe inválido.",
				 FORMATO_DATA = "dd/MM/yyyy", MASCARA_DATA = "##/##/####", MENSAGEM_SUCESSO = "Cadastro realizado com sucesso",
				 DADO_NAO_SE_APLICA = "Não se aplica.", MENSAGEM_ERRO_PERSISTENCIA = "Erro ao cadastrar bovino.", DADO_NAO_INFORMADO = " - ";
	
}
