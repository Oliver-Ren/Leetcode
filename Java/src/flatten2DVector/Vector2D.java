public class Vector2D {
    private int height;
    private List<List<Integer>> vec2d;
    private int row;
    private int col;
    private boolean checked;
    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d == null) {
            throw new NullPointerException();
        }
        this.vec2d = vec2d;
        this.height = vec2d.size();
        row = 0;
        col = -1;
        checked = false;
    }

    public int next() {
        if (!checked) {
            hasNext();
        }
        checked = false;
        int result = vec2d.get(row).get(col);
        return result;
    }

    public boolean hasNext() {
        if (checked) {
            return row < vec2d.size();
        }
        
        checked = true;
        col++;
        while (row < vec2d.size() && col >= vec2d.get(row).size()) {
            col = 0;
            row++;
        }
        
        if (row >= vec2d.size()) {
            return false;
        }
        
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
