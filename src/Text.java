import java.awt.*;

public class Text extends BaseElement {
    private String text;
    public int x;
    public int y;
    private int width;
    private int height;

    public Text(String text) {
        super(0, 0,0, 0, Color.GREEN);
        this.text = text;
    }

    public String getTitle() {
        return text;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public int getWidth() {
        return width == 0 ? text.length() : width;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public char[][] paint(char[][] result) {
        for (int i = x; i < text.length(); i++) {
                result[y][i] = text.charAt(i);
        }
        return result;
    }
}
