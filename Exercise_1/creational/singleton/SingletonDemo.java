
public class SingletonDemo {
    public static void main(String[] args) {
        PrintSpooler spooler1 = PrintSpooler.getInstance();
        PrintSpooler spooler2 = PrintSpooler.getInstance();

        spooler1.printDocument("Resume.pdf");
        spooler2.printDocument("ProjectReport.docx");

        System.out.println("Both are same instance? " + (spooler1 == spooler2));
    }
}
