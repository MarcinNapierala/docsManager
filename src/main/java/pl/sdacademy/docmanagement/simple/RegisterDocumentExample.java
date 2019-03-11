package pl.sdacademy.docmanagement.simple;

public class RegisterDocumentExample {
	public static void main(String[] args) {
		DocumentService service = DocumentServiceFactory.createServiceInstance();
		service.registerDocument("23");
	}
}
