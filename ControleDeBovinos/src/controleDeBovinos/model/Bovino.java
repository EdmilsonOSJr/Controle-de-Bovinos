package controleDeBovinos.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bovino {

	@Id
	private String brinco;
	private String nome;
	private String situacao;
	private String sexo;
	private String brincoMae;
	private String brincoPai;
	private String raca;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataPrenches;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataUltParto;

	
	public Calendar getDataPrenches() {
		return dataPrenches;
	}
	public void setDataPrenches(Calendar dataPrenches) {
		this.dataPrenches = dataPrenches;
	}
	public Calendar getDataUltParto() {
		return dataUltParto;
	}
	public void setDataUltParto(Calendar dataUltParto) {
		this.dataUltParto = dataUltParto;
	}
	public String getBrinco() {
		return brinco;
	}
	public void setBrinco(String brinco) {
		this.brinco = brinco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String sutiacao) {
		this.situacao = sutiacao;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getBrincoMae() {
		return brincoMae;
	}
	public void setBrincoMae(String brincoMae) {
		this.brincoMae = brincoMae;
	}
	public String getBrincoPai() {
		return brincoPai;
	}
	public void setBrincoPai(String brincoPai) {
		this.brincoPai = brincoPai;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
