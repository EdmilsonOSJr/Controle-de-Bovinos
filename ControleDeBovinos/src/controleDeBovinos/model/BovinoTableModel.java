package controleDeBovinos.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class BovinoTableModel extends AbstractTableModel {
	// modelo da minha tabela
	// lista com os insumos que serão mostrados na minha tabela
	private List<Bovino> bovinos;

	// Nome das colunas da minha tabela
	private String[] colunas = new String[] { "Nome", "Brinco", "Brinco Pai", "Brinco Mãe", "Situação", "Sexo", "Raça",
			"Data nasc", "Data prenches", "Data último parto" };


	// cria uma nova instancia da tabelamodelInsumo
	public BovinoTableModel(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}

	public BovinoTableModel() {
		this.bovinos = new ArrayList<Bovino>();
	}

	// retorna o número de linhas da tabela
	@Override
	public int getRowCount() {
		return bovinos.size();
	}

	// retorna o número de colunas da tabela
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	// pega o nome de uma coluna
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	// retorna qual a classe de uma coluna
	public Class<?> getColumnClass(int columnIndex) {

		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
			return String.class;

		}
		return null;

	}

//	// coloca um valor numa linha informada
//	public void setValueAt(Bovino aValue, int rowIndex) {
//		Bovino bovino = bovinos.get(rowIndex);
//		
//		bovino[0] = aValue.getNome();
//		bovino[1] = aValue.getBrinco();
//		bovino[2] = aValue.getBrincoPai();
//		bovino[3] = aValue.getBrincoMae();
//		bovino[4] = aValue.getSituacao();
//		bovino[5] = aValue.getSexo();
//		bovino[6] = aValue.getRaca();
//		bovino[7] = transformaString(aValue.getDataNascimento());
//		bovino[8] = transformaString(aValue.getDataPrenches());
//		bovino[9] = transformaString(aValue.getDataUltParto());
//
//		// avisa ao listener que uma alteração foi feita
//		fireTableCellUpdated(rowIndex, 0);
//		fireTableCellUpdated(rowIndex, 1);
//		fireTableCellUpdated(rowIndex, 2);
//		fireTableCellUpdated(rowIndex, 3);
//		fireTableCellUpdated(rowIndex, 4);
//		fireTableCellUpdated(rowIndex, 5);
//		fireTableCellUpdated(rowIndex, 6);
//		fireTableCellUpdated(rowIndex, 7);
//		fireTableCellUpdated(rowIndex, 8);
//		fireTableCellUpdated(rowIndex, 9);
//	}

	// coloca um valor numa linha informada
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Bovino bovino = bovinos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			bovino.setNome(aValue.toString());
		case 1:
			bovino.setBrinco(aValue.toString());
		case 2:
			bovino.setBrincoPai(aValue.toString());
		case 3:
			bovino.setBrincoMae(aValue.toString());
		case 4:
			bovino.setSituacao(aValue.toString());
		case 5:
			bovino.setSexo(aValue.toString());
		case 6:
			bovino.setRaca(aValue.toString());
		case 7:
			Calendar data = (Calendar) aValue;
			bovino.setDataNascimento(data);
		case 8:
			Calendar data_1 = (Calendar) aValue;
			bovino.setDataPrenches(data_1);
		case 9:
			Calendar data_2 = (Calendar) aValue;
			bovino.setDataUltParto(data_2);

		default:
			System.err.println("Índice da coluna inválido");
			break;
		}

		fireTableCellUpdated(rowIndex, columnIndex);
	}

	// recupera um linhha
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Bovino bovinoSelecionado = bovinos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return bovinoSelecionado.getNome();
		case 1:
			return bovinoSelecionado.getBrinco();
		case 2:
			return bovinoSelecionado.getBrincoPai();
		case 3:
			return bovinoSelecionado.getBrincoMae();
		case 4:
			return bovinoSelecionado.getSituacao();
		case 5:
			return bovinoSelecionado.getSexo();
		case 6:
			return bovinoSelecionado.getRaca();
		case 7:
			return bovinoSelecionado.getDataNascimento();
		case 8:
			return bovinoSelecionado.getDataPrenches();
		case 9:
			return bovinoSelecionado.getDataUltParto();
		default:
			System.err.println("Índice da coluna inválido");
			break;
		}
		return null;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	// retorna o insumo selecionado
	public Bovino getBovino(int rowindex) {
		return bovinos.get(rowindex);
	}

	// insere um insumo na tabela
	public void addBovino(Bovino bovino) {
		bovinos.add(bovino);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	// insere um insumo na tabela
	public void removeBovino(int rowindex) {
		bovinos.remove(rowindex);

		fireTableRowsInserted(rowindex, rowindex);
	}

	// adiciona uma lista de insumos
	public void addListaDeBovinos(List<Bovino> novosBovinos) {
		int tamanhoAntigo = getRowCount();
		bovinos.addAll(novosBovinos);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	// retorna a tabela inteira.
	public List<Bovino> getListaDeBovinos() {
		return bovinos;
	}

	public void limpar() {
		bovinos.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return bovinos.isEmpty();
	}
}
