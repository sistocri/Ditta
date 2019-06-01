package ditta.model;

import java.util.Scanner;
import it.accademiaformaweb.giorno8.ditta.model.Persona;

public class DittaUtils {

	static Scanner scanner = new Scanner(System.in);

	public static void assumiDipendenti(Ditta ditta) {

		while (true) {
			try {
				System.out.println("\nInserisci nome");
				String nome = scanner.nextLine();

				System.out.println("\nInserisci cognome");
				String cognome = scanner.nextLine();

				System.out.println("\nInserisci anno di nascita");
				Integer annoNascita = Integer.parseInt(scanner.nextLine());

				System.out.println("\nInserisci tipo di contratto");
				String contratto = scanner.nextLine();

				System.out.println("\nIl dipendente verrà assunto come: \n1) Lavoratore \n2) Stagista");

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1:

					System.out.println("\nInserisci stipendio mensile");
					Double stipendio = Double.parseDouble(scanner.nextLine());

					Lavoratore lavoratore = new Lavoratore(nome, cognome, annoNascita, contratto, stipendio);
					ditta.assumiPersona(lavoratore);
					break;

				case 2:

					Studente studente = new Studente(nome, cognome, annoNascita, contratto);
					ditta.assumiPersona(studente);
					break;
				}
				return;

			} catch (NumberFormatException e) {
				System.out.println("Scelta effettuata non valida. Riprova.\n");
			}
		}

	}

	public static void licenziaDipendenti(Ditta ditta) {
		@SuppressWarnings("unused")
		Persona persona;
		StringBuilder sb = new StringBuilder();

		System.out.println("---Quale dipendente si vuole licenziare?\n(scegliere un numero)");
		ditta.mostraRisorseOrdinate();

		try {
			int x = Integer.parseInt(scanner.nextLine());

			sb.append("Hai licenziato ").append(ditta.getRisorseUmane().get(x - 1).getNome()).append(" ")
					.append(ditta.getRisorseUmane().get(x - 1).getCognome()).append(".").append(System.lineSeparator());

			System.out.println(sb.toString());

			ditta.licenziaPersona(persona = ditta.getRisorseUmane().get(x - 1));

		} catch (NumberFormatException e) {
			System.out.println("Scelta effettuata non valida. Riprova.\n");
		}

	}
	
	
	public static void resoconto() {
		StringBuilder sb = new StringBuilder();
		sb.append("----Operazioni svolte durante questa sessione di lavoro: ").append(System.lineSeparator())
		.append("Assunzioni: ").append(Ditta.getAssunzioni()).append(System.lineSeparator())
		.append("Licenziamenti: ").append(Ditta.getLicenziamenti()).append(System.lineSeparator());
		System.out.println(sb.toString());
	}

	public static void searchBySurname(Ditta ditta) {
		System.out.println("\n---Inserire cognome del dipendente");
		String cognome = scanner.nextLine();
		System.out.println(ditta.getBySurname(cognome));

	}

}
