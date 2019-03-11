package pl.sdacademy.docmanagement.simple;

public class FullScenarioExample {
	public static void main(String[] args) {
		DocumentService service = DocumentServiceFactory.createServiceInstance();

		String id = "101";
		service.registerDocument(id);
		String department = "MegaUberCEODepartment";
		service.associateDocumentWithDepartment(id, department);
		boolean documentProcessed = service.isDocumentProcessed(id);

		System.out.println(documentProcessed);
	}
}
