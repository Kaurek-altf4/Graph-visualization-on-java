public class Config {
    public String packageName;
    public String repositoryUrl;
    public String mode;          
    public int maxDepth;         

    @Override
    public String toString() {
        return "packageName: " + packageName + "\n" +
               "repositoryUrl: " + repositoryUrl + "\n" +
               "mode: " + mode + "\n" +
               "maxDepth: " + maxDepth;
    }
}
