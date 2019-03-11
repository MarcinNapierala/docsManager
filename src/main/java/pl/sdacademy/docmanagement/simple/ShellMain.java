package pl.sdacademy.docmanagement.simple;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class ShellMain {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		DocumentService documentService = DocumentServiceFactory.createServiceInstance();

		while (true) {
			selectCommand(documentService);
		}
	}

	private static void selectCommand(DocumentService documentService) {
		showMenu();
		String id = null;
		String department = null;
		String documentInput = scanner.nextLine();
		switch (documentInput) {
			case "1":
				System.out.println("___>Podaj id dokumentu");
				id = scanner.nextLine();
				documentService.registerDocument(id);
				break;

			case "2":
				System.out.println("___>Podaj id dokumentu");
				id = scanner.nextLine();
				System.out.println("___>Podaj dział dokumentu");
				department = scanner.nextLine();
				documentService.associateDocumentWithDepartment(id, department);
				break;

			case "3":

				System.out.println("___>Podaj id dokumentu");
				id = scanner.nextLine();
				System.out.println("___>Podaj dział dokumentu");
				department = scanner.nextLine();
				documentService.finishDocumentProcessingBy(id, department);
				break;


			case "4":
				System.out.println("___>Podaj numer id dokumentu");
				id = scanner.nextLine();
				boolean isProcessStop = documentService.isDocumentProcessed(id);
				System.out.println("___>Dokument został przetworzony : " + isProcessStop);
				break;
			default:
				System.out.println("___>Wprowadzono bledne dane lub wybor opcji z menu");
		}
	}

	public static void showMenu() {
		System.out.println("=== MENU ===");
		System.out.println("1. Zarejestruj document");
		System.out.println("2. Przekaz dokument do działu");
		System.out.println("3. Zakończ prace nad dokumentem przez dział");
		System.out.println("4. Sprawdz status dokumentu");

	}
}

