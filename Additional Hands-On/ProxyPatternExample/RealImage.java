package ProxyPatternExample;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        connectToServer();
        loadFromRemote();
    }

    private void connectToServer() {
        System.out.println("Connecting to remote image server...");
    }

    private void loadFromRemote() {
        System.out.println("Downloading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}
