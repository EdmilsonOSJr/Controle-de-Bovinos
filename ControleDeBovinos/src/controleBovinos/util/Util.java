package controleBovinos.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import controleBovinos.DAO.DAO;
import controleBovinos.contantes.Constantes;
import controleBovinos.model.Bovino;

/*
 * Classe com fun��es  
 */
public class Util {

	/**
	 * Fun��o que recebe um bovino e verifica se os seus dados est�o corretos.
	 * 
	 * @param bovino � o bovino que ser� avaliado.
	 * @return String com a mensagem de erro caso encontre algum ou de sucesso caso contr�rio.
	 */
	public static String validaBovino(Bovino bovino) {

		if (!validaNome(bovino.getNome()))
			return Constantes.MENSAGEM_ERRO_NOME;

		if (!validaBrinco(bovino.getBrinco()))
			return Constantes.MENSAGEM_ERRO_BRINCO;

		if (!validaBrincoPai(bovino.getBrincoPai()))
			return Constantes.MENSAGEM_ERRO_BRINCO_PAI;

		if (!validaBrincoMae(bovino.getBrincoMae()))
			return Constantes.MENSAGEM_ERRO_BRINCO_MAE;

		return Constantes.MENSAGEM_SUCESSO;

	}

	/**
	 * M�todo que recebe o nome de um bovino e verifica se ele � v�lido. 
	 * O dado � inv�lido quando:
	 * 		caso ele seja nulo .
	 * 		caso tenha um tamanho maior que 20.
	 * 
	 * @param nome � o nome que ser� avaliado.
	 * 
	 * @return boolean que pode ser true caso o nome serja v�lido ou false caso contr�rio.
	 */
	public static boolean validaNome(String nome) {

		if (nome.isEmpty() || nome.length() > Constantes.TAM_NOME) {
			return false;
		}
		return true;
	}

	/**
	 * M�todo que recebe o brinco de um bovino e verifica se ele � v�lido. 
	 * O dado � inv�lido quando:
	 * 		caso ele seja nulo.
	 * 		caso tenha um tamanho maior que 8 
	 * 		caso j� exista.
	 * 
	 * @param brinco � o brinco do bovino que ser� avaliado.
	 * 
	 * @return boolean que pode ser true caso o brinco serja v�lido ou false caso contr�rio.
	 */
	public static boolean validaBrinco(String brinco) {
		Bovino bovino;

		if (brinco.isEmpty() || brinco.length() > Constantes.TAM_BRINCO) {

			return false;

		} else {

			bovino = pesquisaParente(brinco);

			if (bovino != null)
				return false;
		}

		return true;
	}

	
	/**
	 * M�todo que recebe o brinco do pai de um bovino e verifica se ele � v�lido. 
	 * O dado � inv�lido quando:
	 * 		caso ele tenha um tamanho maior que 8.
	 * 		caso ele n�o exista no banco de dados.
	 * 		caso ele exista no banco de dados mas o sexo n�o seja compat�vel com o masculino.
	 * 
	 * @param brincoPai � o brinco do bovino que ser� avaliado.
	 * 
	 * @return boolean que pode ser true caso o brinco serja v�lido ou false caso contr�rio.
	 */
	public static boolean validaBrincoPai(String brincoPai) {

		Bovino bovino;

		if (brincoPai.length() > Constantes.TAM_BRINCO) {
			return false;

		} else {

			if (!brincoPai.isEmpty()) {

				bovino = pesquisaParente(brincoPai);

				if (bovino != null) {

					if (bovino.getSexo().equalsIgnoreCase("M") == false)
						return false;

				} else
					return false;
			}
		}

		return true;
	}

	
	
	/**
	 * M�todo que recebe o brinco da m�e de um bovino e verifica se ele � v�lido. 
	 * O dado � inv�lido quando:
	 * 		caso ele tenha um tamanho maior que 8.
	 * 		caso ele n�o exista no banco de dados.
	 * 		caso ele exista no banco de dados mas o sexo n�o seja compat�vel com o feminino.
	 * 
	 * @param brincoM�e � o brinco do bovino que ser� avaliado.
	 * 
	 * @return boolean que pode ser true caso o brinco serja v�lido ou false caso contr�rio.
	 */
	public static boolean validaBrincoMae(String brincoMae) {

		Bovino bovino;

		if (brincoMae.length() > Constantes.TAM_BRINCO) {
			return false;
		} else {

			if (!brincoMae.isEmpty()) {
				bovino = pesquisaParente(brincoMae);

				if (bovino != null) {
					if (bovino.getSexo().equalsIgnoreCase("F") == false)
						return false;
				} else
					return false;
			}

		}

		return true;
	}

	/**
	 * M�todo usado para calcular a data do pr�ximo parto de um bovino. 
	 * 
	 * @param data � a data de prenhes � qual ser�o adicionados 9 meses.
	 * 
	 * @return String que pode ser null caso a data fornecida seja inv�lida ou uma String com a nova data caso contr�rio.
	 */
	public static String calculaProximoParto(String data) {
		SimpleDateFormat formato = new SimpleDateFormat(Constantes.FORMATO_DATA);
		try {

			if (!dataValida(data))
				throw new ParseException(data, 0);

			Calendar calendar = Calendar.getInstance();

			calendar.setTime(formato.parse(data));

			calendar.add(Calendar.DAY_OF_MONTH, Constantes.GESTACAO);

			return dataParaString(calendar);

		} catch (ParseException e1) {
			return null;
		}

	}
	
	/***
	 * M�todo que pesquisa um bovino no banco de dados.
	 * 
	 * @param brinco � o brinco do bovino que ser� procurado no banco de dados.
	 * @return Bovino, � um bovino e caso n�o exista retorna null.
	 */
	public static Bovino pesquisaParente(String brinco) {

		DAO<Bovino> dao = new DAO<Bovino>(Bovino.class);

		Bovino bovino = dao.buscaPorld(brinco);

		return bovino;
	}
	
	
	/***
	 * M�todo que recebe uma data e verifica se ela � v�lida.
	 * 
	 * @param data � a data que ser� verificada.
	 * @return boolean que pode ser true caso seja uma data v�lida e false caso contr�rio.
	 */
	public static boolean dataValida(String data) {
		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);

		try {
			LocalDate.parse(data, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	
	/***
	 * M�todo que recebe um Calendar e passa retorna uma String que representa a data no formato dia/m�s/ano.
	 * 
	 * @param calendar � a data que ser� convertida.
	 * @return String que � a data convertida.
	 */
	public static String dataParaString(Calendar calendar) {

		int dia, mes, ano;

		dia = calendar.get(Calendar.DAY_OF_MONTH);
		mes = calendar.get(Calendar.MONTH) + 1;
		ano = calendar.get(Calendar.YEAR);

		return String.format((dia > 10 ? "%d" : "0%d") + (mes > 10 ? "//%d" : "//0%d") + "//%d", dia, mes, ano);

	}

	/***
	 * M�todo usado para receber um bovino e criar uma lista de Strings com os dados dele.
	 * 
	 * @param bovino o bovino que ser� usado para construir a lista.
	 * @return List\<String\> que � composta pelos dados do bovino. 
	 */
	public static List<String> populaListaBovinos(Bovino bovino) {

		List<String> novo = new ArrayList<>();

		novo.add(bovino.getNome());
		novo.add(bovino.getBrinco());
		novo.add(bovino.getBrincoPai() == null || bovino.getBrincoPai().isEmpty() ? Constantes.DADO_NAO_INFORMADO : bovino.getBrincoPai());
		novo.add(bovino.getBrincoMae() == null || bovino.getBrincoMae().isEmpty() ? Constantes.DADO_NAO_INFORMADO : bovino.getBrincoMae());
		novo.add(bovino.getSituacao());
		novo.add(bovino.getSexo());
		novo.add(bovino.getRaca());

		novo.add(bovino.getDataNascimento() == null ? Constantes.DADO_NAO_INFORMADO : Util.dataParaString(bovino.getDataNascimento()));
		novo.add(bovino.getDataPrenhes() == null ? Constantes.DADO_NAO_INFORMADO : Util.dataParaString(bovino.getDataPrenhes()));
		novo.add(bovino.getDataUltParto() == null ? Constantes.DADO_NAO_INFORMADO : Util.dataParaString(bovino.getDataUltParto()));

		return novo;
	}
	
	/***
	 * M�todo sobrecarregado usado para receber um bovino e popular uma lista de Strings com os dados dele.
	 * 
	 * @param bovino o bovino que ser� usado para construir a lista.
	 * @param novo a lista que ser� populada com os dados do bovino.
	 */
	public static void populaListaBovinos(Bovino bovino, List<String> novo) {

		novo.addAll(populaListaBovinos(bovino));

	}
}
