import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Frame frame = new Frame("Login",
                new HorizontalLayout(Arrays.asList(
                        new VerticalLayout(Arrays.asList(
                                new Rectangle(new Text("User")),
                                new Rectangle(new Text("Password")),
                                new HorizontalLayout(Arrays.asList(
                                        new Rectangle(new Text("Ok")),
                                        new Rectangle(new Text("Cancel"))
                                ))
                        )),
                        new Frame("Help",
                                new VerticalLayout(Arrays.asList(
                                        new Text("Please enter login"),
                                        new Text("  and password"),
                                        new Text("Then press Ok button")
                                ))
                        )
                ))
        );
        frame.calculate();
        char[][] result = new char[frame.getHeight()][frame.getWidth()];
        for (char[] chars : result) {
            Arrays.fill(chars, ' ');
        }
        frame.paint(result);
        for (char[] part : result) {
            for (char charResult : part) {
                System.out.print(charResult);
            }
            System.out.println();
        }
    }
}
