import java.util.List;
import java.util.ArrayList;


public class JsonParser{

  public List<String> ParserJson(List<String> lines){

    List<String> deps = new ArrayList<>();
    
    boolean dependencies = false;

    for(String line : lines ){
      line = line.trim();
      if(line.isEmpty()) continue;

      if (line.startsWith("\"dependencies\"")){
        dependencies = true;
        continue;
        }


      if(dependencies){  
        if (line.contains("}")){
          dependencies = false;
          break;
        }
        if(!line.isEmpty() && line.indexOf(":") != -1){
            String express = line.substring(0,line.indexOf(":")).trim();
            express = express.replace("\"", "");
            deps.add(express);
          }
        }
      }
    
    
    return deps;
  }
}
