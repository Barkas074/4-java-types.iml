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
                elementList.get(i + 1).move(0, elementList.get(i).getWidth() + 1);
            }
        }
        //for (int i = 0; i < elementList.size(); i++){
        //    //elementList.get(i).move(x, y);
        //
        //    if (i + 1 >= elementList.size())
        //        break;
        //    elementList.get(i + 1).move(0, elementList.get(i).getWidth() + 1);
        //}
        //elementList.get(0).move(x, y);
    }

    @Override
    public int getWidth() {
        int elementWidth = 0;
        int sumWidth = 0;
        for (int i = 0; i < elementList.size(); i++) {
            if (i != 0)
                elementList.get(i).move(elementWidth + 1, y);
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
        short counter = 0;
        for (Element element : elementList) {
            counter++;
            if (counter != 1)
                element.move(3,0);
            result = element.paint(result);
        }
        return result;
    }
}
