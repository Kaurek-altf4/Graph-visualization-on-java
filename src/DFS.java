import java.util.*;
public class DFS{

  public void dfs(PackageNode startNode, int maxDepth, Map<String, List<String>> graph, Map<String, List<String>> testGraph)throws ConfigException{
    Deque <PackageNode> stack = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    stack.push(startNode);
    while(!stack.isEmpty()){

      PackageNode current = stack.pop();

      if (visited.contains(current.name)){
        continue;
      }else{visited.add(current.name);}

      if(current.dep < maxDepth){
        List<String> children = testGraph.getOrDefault(current.name, new ArrayList<>());
      
        graph.put(current.name,children);
        for(String child : children){
          stack.push(new PackageNode(child, current.dep +1));
          }
      }
      else{graph.putIfAbsent(current.name,new ArrayList<>());}

      
      

    }
    
    
  }
}
