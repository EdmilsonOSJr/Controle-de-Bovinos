package controleDeBovinos.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controleBovinos.Bean.BovinoBean;
import controleBovinos.DAO.DAO;
import controleBovinos.contantes.Constantes;
import controleBovinos.entradaESaida.EntradaESaida;
import controleDeBovinos.model.Bovino;
import controleDeBovinos.model.BovinoTableModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadastroBonvino extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	private JLabel brincoLabel, brincoMaeLabel, brincoPaiLabel, situacaoLabel,
				   sexoLabel, racaLabel, dataPrechesLabel, dataProxPartoLabel,
				   dataUltPartoLabel, dataNascLabel, nomeLabel;
	
	private JPanel contentPane, dadosPanel, cadastroPanel, panel_2,
				   cansultaPanel, femeaPanel;
	
	private JTextField nomeTextField, brincoTextField, brincoMaeTextField,
					   brincoPaiTextField, dataNascTextField, dataPrechesTextField,
					   dataProxPartoTextField, dataUltPartoTextField;
	
	
	private JComboBox<String> situacaoComboBox, racaComboBox, sexoComboBox;
	
	private JTabbedPane tabbedPane;
	
	private JButton cadastrarButton, cansultaButton;
	
	private BovinoTableModel modelo;
	
	private JTable bovinoTable;
	
	private JScrollPane scrollPane;
	
	private List<Bovino> bovinos;
	
	private DAO<Bovino> dao = new DAO<Bovino>(Bovino.class);
	
	SimpleDateFormat formato = new SimpleDateFormat(Constantes.FORMATO_DATA); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroBonvino frame = new CadastroBonvino();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroBonvino() {
		
		setTitle("Controle de Bovinos");
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setName("");
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(10, 11, 720, 439);
		contentPane.add(tabbedPane);
		
		cadastroPanel = new JPanel();
		tabbedPane.addTab("Cadastro", null, cadastroPanel, null);
		cadastroPanel.setBorder(new TitledBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Cadastro de Bovino", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Cadastro de Bovinos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cadastroPanel.setLayout(null);
		
		dadosPanel = new JPanel();
		dadosPanel.setBounds(10, 21, 695, 224);
		cadastroPanel.add(dadosPanel);
		dadosPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Dados do Bovino", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dadosPanel.setLayout(null);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeLabel.setBounds(52, 34, 46, 27);
		dadosPanel.add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(108, 37, 120, 20);
		dadosPanel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		brincoLabel = new JLabel("Brinco:");
		brincoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		brincoLabel.setBounds(52, 89, 46, 14);
		dadosPanel.add(brincoLabel);
		
		brincoTextField = new JTextField();
		brincoTextField.setBounds(108, 86, 120, 20);
		dadosPanel.add(brincoTextField);
		brincoTextField.setColumns(10);
		
		brincoMaeLabel = new JLabel("Brinco M\u00E3e:");
		brincoMaeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		brincoMaeLabel.setBounds(27, 179, 71, 14);
		dadosPanel.add(brincoMaeLabel);
		
		brincoPaiLabel = new JLabel("Brinco Pai:");
		brincoPaiLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		brincoPaiLabel.setBounds(27, 132, 71, 14);
		dadosPanel.add(brincoPaiLabel);
		
		brincoMaeTextField = new JTextField();
		brincoMaeTextField.setBounds(108, 176, 120, 20);
		dadosPanel.add(brincoMaeTextField);
		brincoMaeTextField.setColumns(10);
		
		brincoPaiTextField = new JTextField();
		brincoPaiTextField.setBounds(108, 129, 120, 20);
		dadosPanel.add(brincoPaiTextField);
		brincoPaiTextField.setColumns(10);
		
		situacaoComboBox = new JComboBox<String>();
		situacaoComboBox.setModel(new DefaultComboBoxModel<String>(Constantes.SITUACAO));
		situacaoComboBox.setBounds(525, 36, 120, 22);
		dadosPanel.add(situacaoComboBox);
		
		situacaoLabel = new JLabel("Situa\u00E7\u00E3o:");
		situacaoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		situacaoLabel.setBounds(444, 40, 71, 14);
		dadosPanel.add(situacaoLabel);
		
		sexoLabel = new JLabel("Sexo:");
		sexoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sexoLabel.setBounds(469, 112, 46, 14);
		dadosPanel.add(sexoLabel);
		
		racaLabel = new JLabel("Ra\u00E7a:");
		racaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		racaLabel.setBounds(470, 179, 46, 14);
		dadosPanel.add(racaLabel);
		
		racaComboBox = new JComboBox<String>();
		racaComboBox.setModel(new DefaultComboBoxModel<String>(Constantes.RACA));
		racaComboBox.setBounds(525, 175, 120, 22);
		dadosPanel.add(racaComboBox);
		
		dataNascLabel = new JLabel("Data de nacimento:");
		dataNascLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dataNascLabel.setBounds(261, 112, 94, 14);
		dadosPanel.add(dataNascLabel);
		
		try {
			dataNascTextField = new JFormattedTextField(new MaskFormatter(Constantes.MASCARA_DATA));
			dataPrechesTextField = new JFormattedTextField(new MaskFormatter(Constantes.MASCARA_DATA));
			dataProxPartoTextField = new JFormattedTextField();
			dataUltPartoTextField = new JFormattedTextField(new MaskFormatter(Constantes.MASCARA_DATA));
		} catch (ParseException e3) {
			EntradaESaida.exibirMensagemDeErro(Constantes.MENSAGEM_ERRO_DATA, Constantes.TITULO_ERRO);
		}
		
		//dataNascTextField = new JTextField();
		dataNascTextField.setBounds(365, 109, 86, 20);
		dadosPanel.add(dataNascTextField);
		dataNascTextField.setColumns(10);
		
		sexoComboBox = new JComboBox<String>();
		
		sexoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(sexoComboBox.getSelectedItem() == "F") {
					mudaAtributo(true);
				}
				else
					mudaAtributo(false);
				
			}
		});
		
		sexoComboBox.setModel(new DefaultComboBoxModel<String>(Constantes.SEXO));
		sexoComboBox.setBounds(525, 109, 54, 20);
		dadosPanel.add(sexoComboBox);
		
		femeaPanel = new JPanel();
		femeaPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Dados bovino f\u00EAmea", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		femeaPanel.setBounds(10, 256, 376, 144);
		cadastroPanel.add(femeaPanel);
		femeaPanel.setLayout(null);
		
		dataPrechesLabel = new JLabel("Data de Preches:");
		dataPrechesLabel.setBounds(85, 25, 121, 14);
		femeaPanel.add(dataPrechesLabel);
		dataPrechesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		dataProxPartoLabel = new JLabel("Data do pr\u00F3ximo parto:");
		dataProxPartoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dataProxPartoLabel.setBounds(85, 61, 121, 14);
		femeaPanel.add(dataProxPartoLabel);
		
		dataUltPartoLabel = new JLabel("Data do \u00FAltimo parto:");
		dataUltPartoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dataUltPartoLabel.setBounds(85, 100, 121, 14);
		femeaPanel.add(dataUltPartoLabel);
		
		//dataPrechesTextField = new JTextField();
		dataPrechesTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calculaProximoParto(dataPrechesTextField.getText());
			}
		});
		
		dataPrechesTextField.setColumns(10);
		dataPrechesTextField.setBounds(216, 22, 86, 20);
		dataPrechesTextField.setEditable(false);
		femeaPanel.add(dataPrechesTextField);
		
		//dataProxPartoTextField = new JTextField();
		dataProxPartoTextField.setColumns(10);
		dataProxPartoTextField.setBounds(216, 58, 86, 20);
		dataProxPartoTextField.setEditable(false);
		femeaPanel.add(dataProxPartoTextField);
		
		//dataUltPartoTextField = new JTextField();
		dataUltPartoTextField.setColumns(10);
		dataUltPartoTextField.setBounds(216, 97, 86, 20);
		dataUltPartoTextField.setEditable(false);
		femeaPanel.add(dataUltPartoTextField);
		
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setBounds(455, 293, 191, 63);
		cadastroPanel.add(cadastrarButton);
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Calendar data = Calendar.getInstance(),
						 data_1 = Calendar.getInstance(),
						 data_2 = Calendar.getInstance();
				
				String nome = nomeTextField.getText(),
					   brinco= brincoTextField.getText(),
					   brincoMae = brincoMaeTextField.getText(),
					   brincoPai = brincoPaiTextField.getText(),
					   dataNascimento = dataNascTextField.getText(),
					   dataPrenches = null,
					   dataUltParto = null,
					   situacao = situacaoComboBox.getSelectedItem().toString(),
					   raca = racaComboBox.getSelectedItem().toString(),
					   sexo = sexoComboBox.getSelectedItem().toString()
					   ;
				
				Bovino bovino = new Bovino();
				
							
				bovino.setNome(nome);
				bovino.setBrinco(brinco);
				bovino.setBrincoMae(brincoMae);
				bovino.setBrincoPai(brincoPai);
				
				
				try {
					data.setTime(formato.parse(dataNascimento));
					bovino.setDataNascimento(data);
					
					if(sexo=="F") {
						dataPrenches = dataPrechesTextField.getText();
						dataUltParto = dataUltPartoTextField.getText();
						
						data_1.setTime(formato.parse(dataPrenches));
						bovino.setDataPrenches(data_1);
						data_2.setTime(formato.parse(dataUltParto));
						bovino.setDataUltParto(data_2);
						
					}

				} catch (ParseException e1) {
					EntradaESaida.exibirMensagemDeErro(Constantes.MENSAGEM_ERRO_DATA, Constantes.TITULO_ERRO);
				}
				
				
				bovino.setSituacao(situacao);
				bovino.setSexo(sexo);
				bovino.setRaca(raca);
				
				String mensagem = validaBovino(bovino);
				
				if( mensagem.equalsIgnoreCase(Constantes.MENSAGEM_SUCESSO))
				{					
					BovinoBean bBean = new BovinoBean();
					
					bBean.setBovino(bovino);
					
					bBean.gravar();
					
					limparCampos();	
				}
				else
				{
					EntradaESaida.exibirMensagemDeErro(mensagem, Constantes.TITULO_ERRO);
					limparCampos();
				}
			
			}
		});
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_2, null);
		panel_2.setLayout(null);
		
		cansultaPanel = new JPanel();
		cansultaPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Consuluta Bovino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cansultaPanel.setBounds(10, 11, 695, 327);
		panel_2.add(cansultaPanel);
		
		modelo = new BovinoTableModel();
		
		bovinoTable = new JTable(modelo);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(bovinoTable);
		GroupLayout gl_cansultaPanel = new GroupLayout(cansultaPanel);
		gl_cansultaPanel.setHorizontalGroup(
			gl_cansultaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cansultaPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_cansultaPanel.setVerticalGroup(
			gl_cansultaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cansultaPanel.createSequentialGroup()
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		cansultaPanel.setLayout(gl_cansultaPanel);
		
		cansultaButton = new JButton("Consultar");
		cansultaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bovinos = dao.listaTodos();
				
				modelo.limpar();
				
				modelo.addListaDeBovinos(bovinos);
			}
		});
		cansultaButton.setBounds(297, 353, 134, 47);
		panel_2.add(cansultaButton);
		
	}
	
	private void mudaAtributo(boolean valor) {
		dataPrechesTextField.setEditable(valor);
		dataUltPartoTextField.setEditable(valor);
	}
	
	private void limparCampos() {
		nomeTextField.setText("");
		brincoTextField.setText("");
		brincoMaeTextField.setText("");
		brincoPaiTextField.setText("");
		dataNascTextField.setText("");
		dataPrechesTextField.setText("");
		dataProxPartoTextField.setText("");
		dataUltPartoTextField.setText("");
			
		situacaoComboBox.setSelectedIndex(0);
		racaComboBox.setSelectedIndex(0);
		sexoComboBox.setSelectedIndex(0);
		
	}
	
	private String validaBovino(Bovino bovino) {
		
		Bovino bovinoParente;
		
		if(bovino.getNome().isEmpty() || bovino.getNome().length() > Constantes.TAM_NOME)
			return Constantes.MENSAGEM_ERRO_NOME;
		
		if(bovino.getBrinco().isEmpty()  || bovino.getBrinco().length() > Constantes.TAM_BRINCO)
			return Constantes.MENSAGEM_ERRO_BRINCO;
		
		if(bovino.getBrincoPai().length() > Constantes.TAM_BRINCO)
			return Constantes.MENSAGEM_ERRO_BRINCO_PAI;
		
		if(bovino.getBrincoMae().length() > Constantes.TAM_BRINCO)
			return Constantes.MENSAGEM_ERRO_BRINCO_MAE;
		
		
		if(!bovino.getBrincoPai().isEmpty()) {
			bovinoParente = pesquisaParente(bovino.getBrincoPai());
			
			if(bovinoParente!=null) {
				if(bovinoParente.getSexo().equalsIgnoreCase("M")==false)
					return Constantes.PAI_INVALIDO;
				
			}
			else
				return Constantes.PAI_INVALIDO;
		}
		
		
		if(!bovino.getBrincoMae().isEmpty()) {
			bovinoParente = pesquisaParente(bovino.getBrincoMae());
			
			if(bovinoParente!=null) {
				if(bovinoParente.getSexo().equalsIgnoreCase("F")==false)
					return Constantes.MAE_INVALIDA;
			}
			else
				return Constantes.MAE_INVALIDA;
		}
		
		return Constantes.MENSAGEM_SUCESSO;
		
	}
	
	private void calculaProximoParto(String data) {
		
		
		try {
			
			Calendar calendar = Calendar.getInstance();
			int dia, mes, ano;
			
			System.out.println(data);
			calendar.setTime(formato.parse(data));
			
			calendar.add(Calendar.DAY_OF_MONTH, Constantes.GESTACAO);
			
			dia = calendar.get(Calendar.DAY_OF_MONTH);
			mes = calendar.get(Calendar.MONTH)+1;
			ano = calendar.get(Calendar.YEAR);
			
			dataProxPartoTextField.setText(String.format((dia>10?"%d":"0%d")+(mes>10?"//%d":"//0%d")+ "//%d", dia, mes, ano));
			
		} catch (ParseException e1) {
			EntradaESaida.exibirMensagemDeErro(Constantes.MENSAGEM_ERRO_DATA, Constantes.TITULO_ERRO);
		}
		
		
	}
	
	private Bovino pesquisaParente(String brinco) {
		
		DAO<Bovino> dao = new DAO<Bovino>(Bovino.class);
		
		Bovino bovino = dao.buscaPorld(brinco);
		
		return bovino;
	}
}
