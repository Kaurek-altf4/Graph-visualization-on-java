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
      
    

   try {
    DFS dfs = new DFS();
    
    
    TestGraphParser testParser = new TestGraphParser();
    Map<String, List<String>> testGraph = testParser.loadGraph("../config/test_parser.txt"); 
    
    Map<String, List<String>> resultGraph = new HashMap<>();
    System.out.println("<=== ЗАПУСК В ТЕСТОВОМ РЕЖИМЕ ===>");
    dfs.dfs(new PackageNode("A", 1), 5, resultGraph, testGraph, true);
    
    
    Map<String, List<String>> realGraph = new HashMap<>();
    System.out.println("\n<=== ЗАПУСК В РЕАЛЬНОМ РЕЖИМЕ (express) ===>");
    dfs.dfs(new PackageNode("express", 1), 2, realGraph, new HashMap<>(), false);

} catch (Exception e) {
    System.out.println("Ошибка: " + e.getMessage());
}


	}
}
