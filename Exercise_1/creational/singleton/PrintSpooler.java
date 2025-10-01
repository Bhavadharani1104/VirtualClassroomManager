
public class PrintSpooler {
    private static PrintSpooler instance;

    private PrintSpooler() {
        System.out.println("Print Spooler initialized...");
    }

    public static synchronized PrintSpooler getInstance() {
        if (instance == null) {
            instance = new PrintSpooler();
        }
        return instance;
    }

    public void printDocument(String doc) {
        System.out.println("Printing: " + doc);
    }
}
