import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TestGraphParser {

    
    public Map<String, List<String>> loadGraph(String filePath) throws ConfigException {
        Map<String, List<String>> testGraph = new HashMap<>();
        Path path = Path.of(filePath);

        try {
            
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(":");
                
                if (parts.length == 0) continue;

                
                String packageName = parts[0].trim();
                List<String> dependencies = new ArrayList<>();

                
                if (parts.length > 1) {
                    String depsString = parts[1].trim();
                    
                    
                    if (!depsString.isEmpty()) {
                        String[] depsArray = depsString.split(",");
                        for (String dep : depsArray) {
                            String cleanDep = dep.trim();
                            if (!cleanDep.isEmpty()) {
                                dependencies.add(cleanDep);
                            }
                        }
                    }
                }
                
                
                testGraph.put(packageName, dependencies);
            }
        } catch (IOException e) {
            throw new ConfigException("Не удалось прочитать тестовый граф: " + e.getMessage());
        }

        return testGraph;
    }
}
