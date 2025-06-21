package BuilderPatternExample;

public class Test {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        gamingPC.showConfiguration();

        System.out.println();

        Computer officePC = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Windows 10")
                .build();

        officePC.showConfiguration();
    }
    
}
