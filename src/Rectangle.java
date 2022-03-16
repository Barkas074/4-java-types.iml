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
    public void setHeight(int height){
        this.height = height;
        element.setHeight(height);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        element.move(x + 1, y + 2);
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
                else if (i == x && j == width - 1) {
                    result[i][j] = '┐';
                    break;
                }
                else if (i == height + x - 1 && j == y)
                    result[i][j] = '└';
                else if (i == height + x - 1 && j == width - 1) {
                    result[i][j] = '┘';
                    element.move(height + x - 1, 0);
                    return element.paint(result);
                }
                else if (i == x && i <= x + width - 1 || i == height + x - 1 && i <= x + width - 1)
                    result[i][j] = '─';
                else if ((j == y || j == width - 1) && i >= x && i <= height + x - 1)
                    result[i][j] = '│';
                //else if (j == y + 1 || j == width - 2)
                //    result[i][j] = ' ';
            }
        }

        return result;
    }
}
