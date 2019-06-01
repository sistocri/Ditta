package ditta.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import ditta.model.Persona;

public class DittaDAO {

	static final File file = new File("C:\\Users\\Cristian\\Desktop\\Formaweb\\dittaTest.txt");

	// MAC
//	static final File File = new File("/Users/corso/Desktop/corso Formaweb Sisto/dittaTest.txt");
	public static void salva(Ditta ditta) {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			for (Persona persona : ditta.getRisorseUmane()) {
				bw.write(persona.saveFormatter());
				bw.newLine();
			}

			bw.flush();
			bw.close();

			System.out.println("Salvataggio e termine del programma...\nSpento.");

		} catch (IOException e) {
			System.out.println("File non trovato");
		}

	}

	public static void carica(Ditta ditta) {

		Persona persona;
		Scanner input = null;

		try {

			input = new Scanner(new BufferedReader(new FileReader(file)));
			input.useDelimiter(",");

			while (input.hasNext()) {
				String nome = input.next();
				String cognome = input.next();
				Integer annoNascita = input.nextInt();
				String contratto = input.next();
				String id = input.next();

				if (id.equalsIgnoreCase("lavoratore")) {

					Double stipendio = input.nextDouble();
					persona = new Lavoratore(nome, cognome, annoNascita, contratto, stipendio);
					ditta.getRisorseUmane().add(persona);

				} else if (id.equalsIgnoreCase("studente")) {

					persona = new Studente(nome, cognome, annoNascita, contratto);
					ditta.getRisorseUmane().add(persona);
				} else {

					System.out.println("La persona non ha trovato collocazione all'interno della ditta.");
				}

				input.nextLine();

			}

		} catch (IOException e) {
			System.out.println("File non caricato correttamente.");
		} catch (NoSuchElementException e) {
			input.close();
		}

	}

}
