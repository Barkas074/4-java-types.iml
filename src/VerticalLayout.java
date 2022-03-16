import java.awt.*;
import java.util.List;

public class VerticalLayout extends BaseElement{
    public List<Element> elementList;

    public VerticalLayout(List<Element> elementList) {
        super(0, 0,0, 0, Color.GREEN);
        this.elementList = elementList;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        elementList.get(0).move(x, y);
    }

    @Override
    public int getWidth() {
        int minWidth = 0;
        int elementWidth;
        for (Element element : elementList) {
            elementWidth = element.getWidth();
            if (elementWidth > minWidth)
                minWidth = elementWidth;
        }
        for (Element element : elementList) {
            element.setWidth(minWidth);
        }
        return minWidth;
    }

    @Override
    public int getHeight() {

        int elementHeight = 0;
        int sumHeight = 0;
        for (int i = 0; i < elementList.size(); i++) {
            if (i != 0)
                elementList.get(i).move(0, elementHeight);
            elementHeight = elementList.get(i).getHeight();
            sumHeight += elementHeight;
        }
        return sumHeight; //Убираем лишнюю клетку
    }

    @Override
    public char[][] paint(char[][] result) {
        for (Element element : elementList) {
            result = element.paint(result);
        }
        return result;
    }
}
