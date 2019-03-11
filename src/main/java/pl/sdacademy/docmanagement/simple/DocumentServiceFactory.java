package pl.sdacademy.docmanagement.simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DocumentServiceFactory {
	public static DocumentService createServiceInstance() {
		try {
			Path tempDirectory = Files.createTempDirectory("doc-nanagement");
			return new DocumentServiceImpl(new JsonDocumentRepository(tempDirectory));
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
