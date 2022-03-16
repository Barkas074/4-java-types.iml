import java.awt.*;

abstract class BaseElement implements Element {
    public int x;
    public int y;
    public int width;
    public int height;
    public Color color;
    private boolean selected = false;

    BaseElement(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public int getX(){
        return x;
    }
    @Override
    public int getY(){
        return y;
    }
    @Override
    public void setWidth(int width){
        this.width = width;
    }
    @Override
    public void setHeight(int height){
        this.height = height;
    }
    @Override
    public int getWidth(){
        return 0;
    }
    @Override
    public int getHeight(){
        return 0;
    }
    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }


    @Override
    public void calculate() {
        getWidth();
        getHeight();
    }

    @Override
    public char[][] paint(char[][] result) {
        return result;
    }
}
