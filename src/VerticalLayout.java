import java.awt.*;
import java.util.List;

public class VerticalLayout extends BaseElement {
    public List<Element> elementList;

    public VerticalLayout(List<Element> elementList) {
        super(0, 0, 0, 0);
        this.elementList = elementList;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        if (elementList.get(0).getClass() == Text.class) {
            x -= 1;
            y -= 2;
        }
        elementList.get(0).move(x, y);
        for (int i = 1; i < elementList.size(); i++) {
            int height = 0;
            for (int j = 0; j < i; j++) {
                height += elementList.get(j).getHeight();
            }
            elementList.get(i).move(x + height, y);
        }
    }

    @Override
    public int getWidth() {
        if (width == 0) {
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
            setWidth(minWidth);
        }
        return width;
    }

    @Override
    public int getHeight() {
        if (height == 0) {
            int elementHeight;
            int sumHeight = 0;
            for (Element element : elementList) {
                elementHeight = element.getHeight();
                element.setHeight(elementHeight);
                sumHeight += elementHeight;
            }
            setHeight(sumHeight);
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
