import java.util.List;
import java.util.ArrayList;

/**
 * The first solution.
 * Time complexity: 
 * Space compleixty:
 * Test cases: "", "/", "//", "/asdf/", "/adfs", "././", "../../"
 * Status: Accepted.
 */
public class Solution {
    public String simplifyPath(String path) {
        // precondition: path is not null and the path is valid.
        if (path == null) throw new NullPointerException();

        List<String> paths = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        String[] dirs = path.split("/+");
        
        for (String s : dirs) {
            if (s.equals("..")) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!s.equals(".") && !s.equals("")) {
                paths.add(s);
            }
        }

        sb.append("/");
        for (String s : paths) {
            sb.append(s + "/");
        }
        
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
        

    }
}
