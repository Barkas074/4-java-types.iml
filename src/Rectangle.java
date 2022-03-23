import java.awt.*;

public class Rectangle extends BaseElement {
    public Element element;

    public Rectangle(Element element) {
        super(0, 0, 0, 3);
        this.element = element;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
        element.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        element.setHeight(height);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        element.move(x, y);
    }

    @Override
    public int getWidth() {
        return width == 0 ? element.getWidth() + 2 + 2 : width; //Рамка с двух сторон + отступы с двух сторон
    }

    @Override
    public int getHeight() {
        return height == 3 ? element.getHeight() + 2 : height; //Рамка с двух сторон
    }

    @Override
    public char[][] paint(char[][] result) {
        for (int i = x; i < result.length; i++) {
            for (int j = y; j < result[i].length; j++) {
                if (i == x && j == y) {
                    result[i][j] = '┌';
                } else if (i == x && j == y + width - 1) {
                    result[i][j] = '┐';
                    break;
                } else if (i == x + height - 1 && j == y) {
                    result[i][j] = '└';
                } else if (i == x + height - 1 && j == y + width - 1) {
                    result[i][j] = '┘';
                    return element.paint(result);
                } else if (i == x || i == x + height - 1) {
                    result[i][j] = '─';
                } else if (j == y || j == y + width - 1) {
                    result[i][j] = '│';
                }
            }
        }
        return result;
    }
}
