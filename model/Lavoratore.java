package it.accademiaformaweb.giorno8.ditta.model;

public class Lavoratore extends Persona {

	private String contratto;
	private String id = "lavoratore";
	private double stipendio;
	
	
	public Lavoratore(String nome, String cognome, int annoNascita, String contratto, double stipendio) {
		super(nome, cognome, annoNascita);
		this.contratto = contratto;
		this.stipendio = stipendio;

	}

	public double getStipendio() {
		return stipendio;
	}

	public double getStipendioAnnuale() {
		double annuale = getStipendio() * 12;
		return annuale;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getContratto() {
		return contratto;
	}

	public void setContratto(String contratto) {
		this.contratto = contratto;
	}

	@Override
	public String toString() {
		StringBuilder ris = new StringBuilder();
		ris.append("\nNome: ").append(getNome()).append("\nCognome: ").append(getCognome())
				.append("\nAnno di nascita: ").append(getAnnoNascita()).append("\nContratto: ").append(contratto)
				.append(System.lineSeparator());
		return ris.toString();
	}

	@Override
	public String saveFormatter() {

		return String.format("%s,%s,%d,%s,%s,%g,", getNome(), getCognome(), getAnnoNascita(), contratto, id, stipendio);
	}

}
