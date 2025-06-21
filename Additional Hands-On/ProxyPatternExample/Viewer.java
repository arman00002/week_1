package ProxyPatternExample;

public class Viewer {
    public static void main(String[] args) {
        Image picture = new ProxyImage("profile_pic.jpg");

        picture.display();

        System.out.println();

        picture.display();
    }
}
