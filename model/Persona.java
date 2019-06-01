package it.accademiaformaweb.giorno8.ditta.model;

public abstract class Persona {

	private String nome;
	private String cognome;
	private int annoNascita;

	public Persona() {

	}

	public Persona(String nome, String cognome, int annoNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}

	public int getAnnoNascita() {
		return annoNascita;
	}

	@Override
	public String toString() {
		StringBuilder ris = new StringBuilder();
		ris.append("\nNome: ").append(nome).append("\nCognome: ").append(cognome).append("\nAnno di nascita: ")
				.append(annoNascita).append(System.lineSeparator());
		return ris.toString();
	}

	public abstract String saveFormatter();

}
