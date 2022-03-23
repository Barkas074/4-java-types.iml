import java.awt.*;

public class Text extends BaseElement {
    private final String text;

    public Text(String text) {
        super(1, 2, 0, 1);
        this.text = text;
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
        short counter = 0;
        for (int i = y; i < result[x].length; i++) {
            result[x][i] = text.charAt(counter);
            counter++;
            if (counter == text.length())
                break;
        }
        return result;
    }
}
