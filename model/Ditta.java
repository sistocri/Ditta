package ditta.model;

import java.util.ArrayList;

public class Ditta {

	private String ragioneSociale;
	private String citta;
	private String indirizzo;
	private String tipologia;
	private ArrayList<Persona> risorseUmane;
	private static int licenziamenti;
	private static int assunzioni;

	public Ditta(String ragioneSociale, String citta, String indirizzo, String tipologia) {
		this.ragioneSociale = ragioneSociale;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.tipologia = tipologia;
		this.risorseUmane = new ArrayList<Persona>();
	}

	public Ditta() {
		this("TC-Web", "Torino", "via Venaria", "Srl");
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public ArrayList<Persona> getRisorseUmane() {
		return risorseUmane;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public static int getLicenziamenti() {
		return licenziamenti;
	}

	public static int getAssunzioni() {
		return assunzioni;
	}

	public void stipendioMensileImpiegati() {
		double somma = 0;
		System.out.println("\n---Stipendi mensili dei dipendenti:");
		for (Persona p : risorseUmane) {
			if (p instanceof Lavoratore) {

				StringBuilder sb = new StringBuilder();
				sb.append(((Lavoratore) p).getNome()).append(" ").append(((Lavoratore) p).getCognome()).append(": ")
						.append(((Lavoratore) p).getStipendio()).append("€");

				System.out.println(sb.toString());
				somma += ((Lavoratore) p).getStipendio();
			}
		}

		System.out.println("\nTotale da versare: " + somma + "€");
	}

	public void stipendioAnnualeImpiegati() {
		double somma = 0;
		System.out.println("\n---Stipendi annuali dei dipendenti:");
		for (Persona p : risorseUmane) {
			if (p instanceof Lavoratore) {

				StringBuilder sb = new StringBuilder();
				sb.append(((Lavoratore) p).getNome()).append(" ").append(((Lavoratore) p).getCognome()).append(": ")
						.append(((Lavoratore) p).getStipendioAnnuale()).append("€");

				System.out.println(sb.toString());
				somma += ((Lavoratore) p).getStipendioAnnuale();
			}
		}

		System.out.println("\nTotale da versare: " + somma + "€");
	}

	@Override
	public String toString() {
		StringBuilder ris = new StringBuilder();
		ris.append("\n---Info ditta").append("\nLa ditta si chiama ").append(ragioneSociale).append(", si trova a ")
				.append(citta).append(" all'indirizzo ").append(indirizzo).append(". Nel suo organico ci sono ")
				.append(risorseUmane.size()).append(" dipendenti, che rispettivamente sono:\n ");

		for (int i = 0; i < risorseUmane.size(); i++) {
			ris.append(risorseUmane.get(i).toString());
		}
		return ris.toString();
	}

	public boolean assumiPersona(Persona persona) {
		boolean ris = true;
		risorseUmane.add(persona);
		assunzioni++;

		return ris;
	}

	public boolean licenziaPersona(Persona persona) {
		boolean ris = true;
		risorseUmane.remove(persona);
		licenziamenti++;

		return ris;
	}

	public void mostraRisorseOrdinate() {
		for (int x = 0; x < risorseUmane.size(); x++) {
			System.out.println((x + 1) + ") " + risorseUmane.get(x));
		}
	}

	public ArrayList<Persona> getBySurname(String cognome) {

		ArrayList<Persona> listaPersone = new ArrayList<>();

		if (cognome != null) {
			for (Persona i : risorseUmane) {
				if (i.getCognome().equalsIgnoreCase(cognome)) {
					listaPersone.add(i);
				}
			}
			return listaPersone;

		} else {
			System.out.println("Nessun dipendente risponde a questo cognome");
		}

		return null;

	}

}
