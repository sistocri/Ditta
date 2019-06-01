package it.accademiaformaweb.giorno8.ditta.model;

public class Studente extends Persona {

	private String contratto;
	private String id = "studente";

	public Studente(String nome, String cognome, int annoNascita, String contratto) {
		super(nome, cognome, annoNascita);
		this.contratto = contratto;
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

		return String.format("%s,%s,%d,%s,%s,", getNome(), getCognome(), getAnnoNascita(), contratto, id);
	}

}
