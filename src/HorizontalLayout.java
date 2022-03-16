import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HorizontalLayout extends BaseElement {
    public List<Element> elementList;

    public HorizontalLayout(List<Element> elementList) {
        super(0, 0,0, 0, Color.GREEN);
        this.elementList = elementList;
    }

    @Override
    public int getWidth() {
        int elementWidth = 0;
        int sumWidth = 0;
        for (int i = 0; i < elementList.size(); i++) {
            if (i != 0)
                elementList.get(i).move(elementWidth + 1, 0);
            elementWidth = elementList.get(i).getWidth();
            sumWidth += elementWidth;
        }
        return sumWidth + elementList.size() - 1; //Убираем лишнюю клетку
    }

    @Override
    public int getHeight() {
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
        return minHeight;
    }

    @Override
    public char[][] paint(char[][] result) {
        for (Element element : elementList) {
            result = element.paint(result);
        }
        return result;
    }
}
