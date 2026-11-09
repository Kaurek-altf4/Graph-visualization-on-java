public class Main{
	public static void main(String[] args){
	
		configLoader confld = new configLoader();

		try{
			Config config = confld.load("config/config.csv");

			System.out.println("<=== Конфигурация успешно загружена ===>");
			System.out.println(config);
		}
		catch(ConfigException error){
			System.out.println("Ошибка конфига " + error.getMessage());
		}

	}
}
