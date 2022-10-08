package Ch4;

import java.util.HashMap;
import java.util.Map;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionImporter = new HashMap<String, Importer>();

    public DocumentManagementSystem() {
        extensionImporter.put("jpg", new ImageImporter());
    }
}
