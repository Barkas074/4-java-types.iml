import java.awt.*;
import java.util.List;

public class Rectangle extends BaseElement{
    public Element element;

    public Rectangle(Element element) {
        super(0, 0,0, 0, Color.GREEN);
        this.element = element;
    }

    @Override
    public void setWidth(int width){
        this.width = width;
        element.setWidth(width);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        element.move(x, y);
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
                if (i == x && j == y)
                    result[i][j] = '┌';
                else if (i == x && j == result[i].length - 1)
                    result[i][j] = '┐';
                else if (i == result.length - 1 && j == y)
                    result[i][j] = '└';
                else if (i == result.length - 1 && j == result[i].length - 1)
                    result[i][j] = '┘';
                else if (i == x || i == result.length - 1)
                    result[i][j] = '─';
                else if (j == y || j == result[i].length - 1)
                    result[i][j] = '│';
                else if (j == y + 1 || j == result[i].length - 2)
                    result[i][j] = ' ';
            }
        }
        element.move(1,2);
        return element.paint(result);
    }
}
