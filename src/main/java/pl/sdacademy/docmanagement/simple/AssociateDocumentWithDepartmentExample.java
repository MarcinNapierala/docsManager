package pl.sdacademy.docmanagement.simple;

public class AssociateDocumentWithDepartmentExample {
	public static void main(String[] args) {
		DocumentService service = DocumentServiceFactory.createServiceInstance();
		service.associateDocumentWithDepartment("23", "Księgowość");
	}
}
