import java.awt.*;

abstract class BaseElement implements Element {
    public int x;
    public int y;
    public int width;
    public int height;

    BaseElement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }


    @Override
    public void calculate() {
        setWidth(getWidth());
        setHeight(getHeight());
        move(0, 0);
    }

    @Override
    public char[][] paint(char[][] result) {
        return result;
    }
}
