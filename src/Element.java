public interface Element {
    int getX();
    int getY();
    void setWidth(int width);
    void setHeight(int height);
    int getWidth();
    int getHeight();
    void move(int x, int y);
    void calculate();
    char[][] paint(char[][] result);
}
