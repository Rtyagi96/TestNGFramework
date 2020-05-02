package Framework.helper.resource;

// This class will fetch the path using the builtin user.dir
public class ResourceHelper {
    public static String getResourcePath(String path){
        String basePath = System.getProperty("user.dir");
        return basePath + path;
    }
}
