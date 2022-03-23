import java.awt.*;

public class Frame extends BaseElement {
    private final String title;
    public Element element;

    public Frame(String title, Element element) {
        super(0, 0, 0, 0);
        this.title = " " + title + " ";
        this.element = element;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        element.move(x + 1, y + 2);
    }

    @Override
    public int getWidth() {
        return width == 0 ? element.getWidth() + 2 + 2 : width; //Рамка с двух сторон + отступы с двух сторон
    }

    @Override
    public int getHeight() {
        return height == 0 ? element.getHeight() + 2 : height; //Рамка с двух сторон
    }

    @Override
    public char[][] paint(char[][] result) {
        for (int i = x; i < result.length; i++) {
            for (int j = y; j < result[i].length; j++) {
                if (i == x && j == y) {
                    result[i][j] = '╔';
                } else if (i == x && j == y + getWidth() - 1) {
                    result[i][j] = '╗';
                    break;
                } else if (i == x + getHeight() - 1 && j == y) {
                    result[i][j] = '╚';
                } else if (i == x + getHeight() - 1 && j == y + getWidth() - 1) {
                    result[i][j] = '╝';
                    return element.paint(result);
                } else if (i == x && j >= y + 2 && j < y + (title.length() + 2)) {
                    result[i][j] = title.charAt(j - y - 2);
                } else if (i == x || i == x + getHeight() - 1) {
                    result[i][j] = '═';
                } else if (j == y || j == y + getWidth() - 1) {
                    result[i][j] = '║';
                }
            }
        }
        return result;
    }
}
