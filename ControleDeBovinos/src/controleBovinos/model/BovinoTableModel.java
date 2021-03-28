package controleBovinos.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import controleBovinos.util.Util;

@SuppressWarnings("serial")
public class BovinoTableModel extends AbstractTableModel {
	// modelo da minha tabela
	// lista com os insumos que serão mostrados na minha tabela
	private List<List<String>> bovinos;

	// Nome das colunas da minha tabela
	private String[] colunas = new String[] { "Nome", "Brinco", "Brinco Pai", "Brinco Mãe", "Situação", "Sexo", "Raça",
			"Nascimento", "Prenches", "Último parto" };

	// cria uma nova instancia da tabelamodelInsumo
	public BovinoTableModel(List<Bovino> bovinos) {
		super();
		
		for (int cont = 0; cont < bovinos.size(); cont++) {
			
			this.bovinos.add(Util.populaListaBovinos(bovinos.get(cont)));
			
		}
	
	}

	public BovinoTableModel() {
		this.bovinos = new ArrayList<>();
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

	// coloca um valor numa linha informada
	public void setValueAt(Bovino aValue, int rowIndex) {
		List<String> bovino = bovinos.get(rowIndex);
		
		Util.populaListaBovinos(aValue, bovino);
		
		// avisa ao listener que uma alteração foi feita
		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
		fireTableCellUpdated(rowIndex, 3);
		fireTableCellUpdated(rowIndex, 4);
		fireTableCellUpdated(rowIndex, 5);
		fireTableCellUpdated(rowIndex, 6);
		fireTableCellUpdated(rowIndex, 7);
		fireTableCellUpdated(rowIndex, 8);
		fireTableCellUpdated(rowIndex, 9);
	}

	// coloca um valor numa linha informada
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		List<String> bovino = bovinos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			bovino.add(aValue.toString());
		case 1:
			bovino.add(aValue.toString());
		case 2:
			bovino.add(aValue.toString());
		case 3:
			bovino.add(aValue.toString());
		case 4:
			bovino.add(aValue.toString());
		case 5:
			bovino.add(aValue.toString());
		case 6:
			bovino.add(aValue.toString());
		case 7:
			Calendar data = (Calendar) aValue;
			bovino.add(data == null ? "Não informado"
					: Util.dataParaString(data));
		case 8:
			Calendar data1 = (Calendar) aValue;
			bovino.add(data1 == null ? "Não informado"
					: Util.dataParaString(data1));
		case 9:
			Calendar data2 = (Calendar) aValue;
			bovino.add(data2 == null ? "Não informado"
					: Util.dataParaString(data2));

		default:
			System.err.println("Índice da coluna inválido");
			break;
		}

		fireTableCellUpdated(rowIndex, columnIndex);
	}

	// recupera um linhha
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<String> bovinoSelecionado = bovinos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return bovinoSelecionado.get(0);
		case 1:
			return bovinoSelecionado.get(1);
		case 2:
			return bovinoSelecionado.get(2);
		case 3:
			return bovinoSelecionado.get(3);
		case 4:
			return bovinoSelecionado.get(4);
		case 5:
			return bovinoSelecionado.get(5);
		case 6:
			return bovinoSelecionado.get(6);
		case 7:
			return bovinoSelecionado.get(7);
		case 8:
			return bovinoSelecionado.get(8);
		case 9:
			return bovinoSelecionado.get(9);
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
	public List<String> getBovino(int rowindex) {
		return bovinos.get(rowindex);
	}

	// insere um insumo na tabela
	public void addBovino(Bovino bovino) {
		bovinos.add(Util.populaListaBovinos(bovino));

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
		
		for (int cont = 0; cont < novosBovinos.size(); cont++) {
			
			bovinos.add(Util.populaListaBovinos(novosBovinos.get(cont)));
		}
		
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	// retorna a tabela inteira.
	public List<List<String>> getListaDeBovinos() {
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
