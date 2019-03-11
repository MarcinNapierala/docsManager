package pl.sdacademy.docmanagement.simple;

import org.junit.Assert;

import java.util.Optional;

public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;


	public DocumentServiceImpl(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	@Override
	public void registerDocument(String id) {
		Document document = new Document(id);
		documentRepository.save(document);


	}

	@Override
	public void associateDocumentWithDepartment(String documentId, String department) {
		documentRepository.findById(documentId).ifPresent(doc -> {
			doc.associateWith(new Department(department));
			documentRepository.save(doc);
		});
		// droga wersja
		//		Optional<Document> optionalDocument = documentRepository.findById(documentId);
		//		if(optionalDocument.isPresent()){
		//			Document document = optionalDocument.get();
		//			document.associateWith(new Department(department));
		//			documentRepository.save(document);
		//		}

	}

	@Override
	public void finishDocumentProcessingBy(String documentId, String department) {
		documentRepository.findById(documentId).ifPresent(finish -> {
			finish.finishProcessingBy(department);
			documentRepository.save(finish);
		});
	}

	@Override
	public boolean isDocumentProcessed(String documentId) {
		return documentRepository.findById(documentId).map(Document::isProcessed).orElse(false);
	}
}
