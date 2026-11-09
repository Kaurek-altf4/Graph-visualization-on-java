import java.util.List;
public class Main{
	public static void main(String[] args){
    
    String url = "https://raw.githubusercontent.com/expressjs/express/refs/heads/master/package.json";
      
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
        System.out.println("Скачиваем " + url + "...");
        List<String> jsonlines = reader.fetchFile(url);

        System.out.println("Ищем зависимости...");
        List<String> dependencies = parser.ParserJson(jsonlines);

        System.out.println("<=== Прямые зависимости пакета ===>");
        for(String dep : dependencies){
            System.out.println(dep + "\n");
        }
    }
    catch(Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
    }

	  
  }
}
