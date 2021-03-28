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

public class Util {

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

	public static boolean validaNome(String nome) {

		if (nome.isEmpty() || nome.length() > Constantes.TAM_NOME) {
			return false;
		}
		return true;
	}

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

	public static String calculaProximoParto(String data) {
		SimpleDateFormat formato = new SimpleDateFormat(Constantes.FORMATO_DATA);
		try {

			if (!dataValida(data))
				throw new ParseException(data, 0);

			Calendar calendar = Calendar.getInstance();

			System.out.println(data);
			calendar.setTime(formato.parse(data));

			calendar.add(Calendar.DAY_OF_MONTH, Constantes.GESTACAO);

			return dataParaString(calendar);

		} catch (ParseException e1) {
			return null;
		}

	}

	public static Bovino pesquisaParente(String brinco) {

		DAO<Bovino> dao = new DAO<Bovino>(Bovino.class);

		Bovino bovino = dao.buscaPorld(brinco);

		return bovino;
	}

	public static boolean dataValida(String strDate) {
		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);

		try {
			LocalDate.parse(strDate, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static String dataParaString(Calendar calendar) {

		int dia, mes, ano;

		dia = calendar.get(Calendar.DAY_OF_MONTH);
		mes = calendar.get(Calendar.MONTH) + 1;
		ano = calendar.get(Calendar.YEAR);

		return String.format((dia > 10 ? "%d" : "0%d") + (mes > 10 ? "//%d" : "//0%d") + "//%d", dia, mes, ano);

	}


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
		novo.add(bovino.getDataPrenches() == null ? Constantes.DADO_NAO_INFORMADO : Util.dataParaString(bovino.getDataPrenches()));
		novo.add(bovino.getDataUltParto() == null ? Constantes.DADO_NAO_INFORMADO : Util.dataParaString(bovino.getDataUltParto()));

		return novo;
	}
	
	public static void populaListaBovinos(Bovino bovino, List<String> novo) {

		novo.addAll(populaListaBovinos(bovino));

	}
}
