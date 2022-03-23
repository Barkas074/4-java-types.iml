import java.awt.*;
import java.util.List;

public class HorizontalLayout extends BaseElement {
    public List<Element> elementList;

    public HorizontalLayout(List<Element> elementList) {
        super(0, 0, 0, 0);
        this.elementList = elementList;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        elementList.get(0).move(x, y);
        for (int i = 1; i < elementList.size(); i++) {
            int width = 0;
            for (int j = 0; j < i; j++) {
                width += elementList.get(j).getWidth();
            }
            elementList.get(i).move(x, y + width + 1);
        }
    }

    @Override
    public int getWidth() {
        if (width == 0) {
            int elementWidth;
            int sumWidth = 0;
            for (Element element : elementList) {
                elementWidth = element.getWidth();
                element.setWidth(elementWidth);
                sumWidth += elementWidth;
            }
            setWidth(sumWidth + elementList.size() - 1);
        }
        return width; //Убираем лишнюю клетку
    }

    @Override
    public int getHeight() {
        if (height == 0) {
            int minHeight = 0;
            int elementHeight;
            for (Element element : elementList) {
                elementHeight = element.getHeight();
                if (elementHeight > minHeight)
                    minHeight = elementHeight;
            }
            for (Element element : elementList) {
                element.setHeight(minHeight);
            }
            setHeight(minHeight);
        }
        return height;
    }

    @Override
    public char[][] paint(char[][] result) {
        for (Element element : elementList) {
            result = element.paint(result);
        }
        return result;
    }
}
