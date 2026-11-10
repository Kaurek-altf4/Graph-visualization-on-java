import java.util.*;
public class Main{
	public static void main(String[] args){
    
    String url = "https://raw.githubusercontent.com/expressjs/express/master/package.json";

    Map<String,List<String>> graph = new HashMap<>();
    
    JsonReader reader = new JsonReader();
    JsonParser parser = new JsonParser();
		configLoader confld = new configLoader();

		try{
			Config config = confld.load("../config/config.csv");

			System.out.println("<=== Конфигурация успешно загружена ===>");
			System.out.println(config);
		}
		catch(ConfigException error){
			System.out.println("Ошибка конфига " + error.getMessage());
		}
    try{
        System.out.println("\nСкачиваем " + url + "...");
        List<String> jsonlines = reader.fetchFile(url);
        

        System.out.println("Ищем зависимости...");
        List<String> dependencies = parser.ParserJson(jsonlines);
        
        System.out.println("<=== Прямые зависимости пакета ===>");

        for(String dep : dependencies){
            System.out.println(dep + "\n");

        }
    } catch(Exception e){
        System.err.println("Ошибка: " + e.getMessage());
    }
      
    TestGraphParser testParser = new TestGraphParser();

    try {
    
        Map<String, List<String>> testGraph = testParser.loadGraph("../config/test_parser.txt");
    
        Map<String, List<String>> resultGraph = new HashMap<>();
        DFS dfs = new DFS();
  
        dfs.dfs(new PackageNode("A", 1), 5, resultGraph, testGraph);
    
    
        System.out.println("<=== Результат обхода графа ===>");
        for (Map.Entry<String, List<String>> entry : resultGraph.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        } 

      } catch (ConfigException e) {
          System.out.println("Ошибка: " + e.getMessage());
      }


	}
}
