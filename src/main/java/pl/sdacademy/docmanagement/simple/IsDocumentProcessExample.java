package pl.sdacademy.docmanagement.simple;

public class IsDocumentProcessExample {
	public static void main(String[] args) {
	boolean show =  DocumentServiceFactory.createServiceInstance().isDocumentProcessed("23");
		System.out.println(show);
	}
}
