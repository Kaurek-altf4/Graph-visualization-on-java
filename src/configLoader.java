import java.io.*;
import java.nio.file.*;
import java.util.*;

public class configLoader{
	
	public List<String> ReadFile(String filePath) throws ConfigException{
	
		Path path = Path.of(filePath); 
		
		try{
			List<String> allLines = Files.readAllLines(path);

			return allLines;
		}

		catch(IOException error){
			throw new ConfigException("не удалось прочитать файл " + filePath + ": " + error.getMessage());
		}
	
	}

	public Map<String,String> parser(List<String> lines) throws ConfigException{

		Map<String,String> configMap = new LinkedHashMap<>();


		for(String line : lines){

		line = line.trim();
		if (line.isEmpty() || line.startsWith("#")){
			continue;
		}
		
		int commaIndex = line.indexOf(',');
		if(commaIndex == -1){
			throw new ConfigException("отсутствует знак , " + line);	

		}
		String key = line.substring(0,commaIndex).trim();
		String value = line.substring(commaIndex+1).trim();
		if(key.isEmpty()){
			throw new ConfigException("отсутствует key: " + line);
		}
		if(value.isEmpty()){
			throw new ConfigException("отсутствует value: " + line);
		}
		if(configMap.containsKey(key)){
			throw new ConfigException("такой key уже есть: " + key);
		}
		configMap.put(key,value);
		}
		return configMap;

	
	}
	private String requireNonEmpty(Map<String,String> map, String keyName) throws ConfigException{

		if(!map.containsKey(keyName)){
			throw new ConfigException("Отсутствует обязательный параметр: " + keyName);
		}

		String value = map.get(keyName);
		if(value == null || value.isEmpty()){
			throw new ConfigException("параметр: " + keyName + " пустой");
		}
	
		return value;
	}

	public Config load(String filePath) throws ConfigException{
	
		List<String> lines = ReadFile(filePath);

		Map<String,String> map = parser(lines);

		String packageName = requireNonEmpty(map, "packageName");
		String repositoryUrl = requireNonEmpty(map, "repositoryUrl");
		String mode = requireNonEmpty(map, "mode");
		String maxDepthStr = requireNonEmpty(map, "maxDepth"); 

		Config config = new Config();
		config.packageName = packageName;
		config.repositoryUrl = repositoryUrl;
		config.mode = mode;

		config.maxDepth = Integer.parseInt(maxDepthStr);

		return config;
	}
	
}
