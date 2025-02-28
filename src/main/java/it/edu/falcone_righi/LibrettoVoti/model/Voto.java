package it.edu.falcone_righi.LibrettoVoti.model;

import java.time.LocalDate;

public class Voto {
	private String nomeCorso;
	private int votoOttenuto;
	private LocalDate dataEsame;
	/**
	 * @param nomeCorso
	 * @param votoOttenuto
	 * @param dataEsame
	 */
	public Voto(String nomeCorso, int votoOttenuto, LocalDate dataEsame) {
		this.nomeCorso = nomeCorso;
		this.votoOttenuto = votoOttenuto;
		this.dataEsame = dataEsame;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public int getVotoOttenuto() {
		return votoOttenuto;
	}
	public void setVotoOttenuto(int votoOttenuto) {
		this.votoOttenuto = votoOttenuto;
	}
	public LocalDate getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	@Override
	public String toString() {
		return getNomeCorso() + ": voto:" + getVotoOttenuto()
				+ ", data:" + getDataEsame();
	}
	
}
