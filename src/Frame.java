import java.awt.*;

public class Frame extends BaseElement {
    private final String title;
    public Element element;

    public Frame(String title, Element element) {
        super(0, 0, 0, 0, Color.GREEN);
        this.title = " " + title + " ";
        this.element = element;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        element.move(x, y);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int getWidth() {
        return element.getWidth() + 2 + 2; //Рамка с двух сторон + отступы с двух сторон
    }

    @Override
    public int getHeight() {
        return element.getHeight() + 2; //Рамка с двух сторон
    }

    @Override
    public char[][] paint(char[][] result) {
        for (int i = x; i < result.length; i++) {
            for (int j = y; j < result[i].length; j++) {
                if (i == 0 && j == 0)
                    result[i][j] = '╔';
                else if (i == 0 && j == result[i].length - 1)
                    result[i][j] = '╗';
                else if (i == result.length - 1 && j == 0)
                    result[i][j] = '╚';
                else if (i == result.length - 1 && j == result[i].length - 1)
                    result[i][j] = '╝';
                else if (i == 0 && j >= 2 && j < (title.length() + 2))
                    result[i][j] = title.charAt(j - 2);
                else if (i == 0 || i == result.length - 1)
                    result[i][j] = '═';
                else if (j == 0 || j == result[i].length - 1)
                    result[i][j] = '║';
                else if (j == 1 || j == result[i].length - 2)
                    result[i][j] = ' ';
            }
        }
        element.move(1,2);
        return element.paint(result);
    }
}
