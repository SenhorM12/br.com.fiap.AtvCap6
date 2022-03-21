package br.com.fiap.AtvCap6.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="tab_cliente")
public class Cliente {
	
	@Id
	@SequenceGenerator(name="cliente", sequenceName="sq_tb_clientes", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente")
	@Column(name="freq_cliente")
	private Integer freq;
	
	@Column(name="cel_cliente", length=11, nullable=false)
	private Integer cel;

	@Column(name="nm_cliente", length=80)
	private String nome;
	
	@Column(name="tp_cerveja")
	private String tpCerveja;
	
	@Column(name="vl_total")
	private double valor;
	
	@Column(name="dt_visita")
	private String dataVisita = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	
	@Column(name="ticket_cliente")
	private double ticket;

	public Integer getCel() {
		return cel;
	}

	public void setCel(Integer cel) {
		this.cel = cel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoCerveja() {
		return tpCerveja;
	}

	public void setTipoCerveja(String tpCerveja) {
		this.tpCerveja = tpCerveja;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(String dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public double getTicket() {
		return ticket;
	}

	public void setTicket(double ticket) {
		this.ticket = ticket;
	}
	
	}
	
	