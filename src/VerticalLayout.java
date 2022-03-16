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
        for (Element element : elementList) {
            element.move(x, y);
        }
        for (int i = 0; i < elementList.size(); i++){
            //elementList.get(i).move(x, y);
            if (i + 1 >= elementList.size())
                break;
            for (int j = 0; j < i; j++){
                elementList.get(i + 1).move(elementList.get(i).getHeight(), 0);
            }
        }
        //elementList.get(0).move(x, y);
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
                elementList.get(i).move(x, elementHeight);
            elementHeight = elementList.get(i).getHeight();
            elementList.get(i).setHeight(elementHeight);
            sumHeight += elementHeight;
        }
        return sumHeight; //Убираем лишнюю клетку
    }

    @Override
    public char[][] paint(char[][] result) {
        short counter = 0;
        for (Element element : elementList) {
            counter++;
            if (counter != 1)
                element.move(0,0);
            result = element.paint(result);
        }
        return result;
    }
}
