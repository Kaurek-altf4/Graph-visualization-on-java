import java.util.*;

public class DFS {

   
   
    public void dfs(PackageNode startNode, int maxDepth, Map<String, List<String>> graph, 
                    Map<String, List<String>> testGraph, boolean isTestMode) throws Exception {
        
        Deque<PackageNode> stack = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        List<String> loadOrder = new ArrayList<>(); 
        
        
        JsonReader reader = new JsonReader();
        JsonParser parser = new JsonParser();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            PackageNode current = stack.pop();

            if (visited.contains(current.name)) {
                continue;
            }
            visited.add(current.name);

            if (current.dep < maxDepth) {
                List<String> children = new ArrayList<>();

               
                if (isTestMode) {
              
                    children = testGraph.getOrDefault(current.name, new ArrayList<>());
                } else {
              
                    try {
             
                        String url = "https://unpkg.com/" + current.name + "@latest/package.json";
                        System.out.println("Скачиваем: " + current.name + " (глубина " + current.dep + ")");
                        
                        List<String> jsonLines = reader.fetchFile(url);
                        children = parser.ParserJson(jsonLines);
                    } catch (Exception e) {
                        System.out.println("Не удалось скачать " + current.name + ": " + e.getMessage());
                    }
                }

                graph.put(current.name, children);
                
                for (String child : children) {
                    stack.push(new PackageNode(child, current.dep + 1)); 
                }
            } else {
                graph.putIfAbsent(current.name, new ArrayList<>()); 
            }
            
           
            loadOrder.add(current.name);
        }

       
        Collections.reverse(loadOrder);
        System.out.println("\n<=== Порядок загрузки (топологическая сортировка) ===>");
        System.out.println(loadOrder);
    }
}
