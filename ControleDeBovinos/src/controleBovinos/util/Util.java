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
 * Classe com funções  
 */
public class Util {

	/**
	 * Função que recebe um bovino e verifica se os seus dados estão corretos.
	 * 
	 * @param bovino é o bovino que será avaliado.
	 * @return String com a mensagem de erro caso encontre algum ou de sucesso caso contrário.
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
	 * Método que recebe o nome de um bovino e verifica se ele é válido. 
	 * O dado é inválido quando:
	 * 		caso ele seja nulo .
	 * 		caso tenha um tamanho maior que 20.
	 * 
	 * @param nome é o nome que será avaliado.
	 * 
	 * @return boolean que pode ser true caso o nome serja válido ou false caso contrário.
	 */
	public static boolean validaNome(String nome) {

		if (nome.isEmpty() || nome.length() > Constantes.TAM_NOME) {
			return false;
		}
		return true;
	}

	/**
	 * Método que recebe o brinco de um bovino e verifica se ele é válido. 
	 * O dado é inválido quando:
	 * 		caso ele seja nulo.
	 * 		caso tenha um tamanho maior que 8 
	 * 		caso já exista.
	 * 
	 * @param brinco é o brinco do bovino que será avaliado.
	 * 
	 * @return boolean que pode ser true caso o brinco serja válido ou false caso contrário.
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
	 * Método que recebe o brinco do pai de um bovino e verifica se ele é válido. 
	 * O dado é inválido quando:
	 * 		caso ele tenha um tamanho maior que 8.
	 * 		caso ele não exista no banco de dados.
	 * 		caso ele exista no banco de dados mas o sexo não seja compatível com o masculino.
	 * 
	 * @param brincoPai é o brinco do bovino que será avaliado.
	 * 
	 * @return boolean que pode ser true caso o brinco serja válido ou false caso contrário.
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
	 * Método que recebe o brinco da mãe de um bovino e verifica se ele é válido. 
	 * O dado é inválido quando:
	 * 		caso ele tenha um tamanho maior que 8.
	 * 		caso ele não exista no banco de dados.
	 * 		caso ele exista no banco de dados mas o sexo não seja compatível com o feminino.
	 * 
	 * @param brincoMãe é o brinco do bovino que será avaliado.
	 * 
	 * @return boolean que pode ser true caso o brinco serja válido ou false caso contrário.
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
	 * Método usado para calcular a data do próximo parto de um bovino. 
	 * 
	 * @param data é a data de prenhes à qual serão adicionados 9 meses.
	 * 
	 * @return String que pode ser null caso a data fornecida seja inválida ou uma String com a nova data caso contrário.
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
	 * Método que pesquisa um bovino no banco de dados.
	 * 
	 * @param brinco é o brinco do bovino que será procurado no banco de dados.
	 * @return Bovino, é um bovino e caso não exista retorna null.
	 */
	public static Bovino pesquisaParente(String brinco) {

		DAO<Bovino> dao = new DAO<Bovino>(Bovino.class);

		Bovino bovino = dao.buscaPorld(brinco);

		return bovino;
	}
	
	
	/***
	 * Método que recebe uma data e verifica se ela é válida.
	 * 
	 * @param data é a data que será verificada.
	 * @return boolean que pode ser true caso seja uma data válida e false caso contrário.
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
	 * Método que recebe um Calendar e passa retorna uma String que representa a data no formato dia/mês/ano.
	 * 
	 * @param calendar é a data que será convertida.
	 * @return String que é a data convertida.
	 */
	public static String dataParaString(Calendar calendar) {

		int dia, mes, ano;

		dia = calendar.get(Calendar.DAY_OF_MONTH);
		mes = calendar.get(Calendar.MONTH) + 1;
		ano = calendar.get(Calendar.YEAR);

		return String.format((dia > 10 ? "%d" : "0%d") + (mes > 10 ? "//%d" : "//0%d") + "//%d", dia, mes, ano);

	}

	/***
	 * Método usado para receber um bovino e criar uma lista de Strings com os dados dele.
	 * 
	 * @param bovino o bovino que será usado para construir a lista.
	 * @return List\<String\> que é composta pelos dados do bovino. 
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
	 * Método sobrecarregado usado para receber um bovino e popular uma lista de Strings com os dados dele.
	 * 
	 * @param bovino o bovino que será usado para construir a lista.
	 * @param novo a lista que será populada com os dados do bovino.
	 */
	public static void populaListaBovinos(Bovino bovino, List<String> novo) {

		novo.addAll(populaListaBovinos(bovino));

	}
}
