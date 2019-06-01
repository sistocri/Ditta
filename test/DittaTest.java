package ditta.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import ditta.model.Ditta;
import ditta.model.DittaDAO;
import ditta.model.DittaUtils;

public class DittaTest {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Ditta ditta = new Ditta();
		DittaDAO.carica(ditta);
		System.out.println("Benvenuto nell'app di archivio dipendenti.");

		while (true) {
			System.out.println("---Cosa vuoi fare?");
			System.out.println("1) Assumi nuovo dipendente \n2) Info ditta \n3) Visualizza stipendi "
					+ "\n4) Cerca dipendente da cognome \n5) Licenzia dipendente \n0) Esci");
			try {
				int choice = Integer.parseInt(input.nextLine());

				switch (choice) {

				case 0:
					DittaUtils.resoconto();
					DittaDAO.salva(ditta);

					return;

				case 1:
					DittaUtils.assumiDipendenti(ditta);
					break;

				case 2:
					System.out.println(ditta);
					break;

				case 3:
					ditta.stipendioMensileImpiegati();
					ditta.stipendioAnnualeImpiegati();
					break;

				case 4:
					DittaUtils.searchBySurname(ditta);
					break;

				case 5:
					DittaUtils.licenziaDipendenti(ditta);
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Inserisci un numero.");
			}

		}

	}

}
