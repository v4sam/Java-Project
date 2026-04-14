import java.util.Scanner;

class Document {

    private StringBuffer textBuffer;

    public Document() {
        textBuffer = new StringBuffer();
    }

    public void addText(String input) {
        textBuffer.append(input);
    }

    public void clearText() {
        textBuffer.setLength(0);
    }

    public void reverseText() {
        textBuffer.reverse();
    }

    public void deleteText(int start, int end) {
        if (start < 0 || end > textBuffer.length() || start > end) {
            System.out.println("[!] Invalid range. Please check start/end indexes.");
            return;
        }
        textBuffer.delete(start, end);
    }

    public void replaceText(int start, int end, String newText) {
        if (start < 0 || end > textBuffer.length() || start > end) {
            System.out.println("[!] Invalid range for replace.");
            return;
        }
        textBuffer.replace(start, end, newText);
    }

    public void insertText(int offset, String text) {
        if (offset < 0 || offset > textBuffer.length()) {
            System.out.println("[!] Invalid offset for insert.");
            return;
        }
        textBuffer.insert(offset, text);
    }

    public void displayText() {
        System.out.println("Current text: \"" + textBuffer.toString() + "\"");
    }

    public int getLength() {
        return textBuffer.length();
    }

    public String getText() {
        return textBuffer.toString();
    }
}

public class TextEditor {

    static void line() {
        System.out.println("─────────────────────────────────────────");
    }

    public static void main(String[] args) {

        Scanner sc     = new Scanner(System.in);
        Document doc   = new Document();
        boolean running = true;

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║ Simple Text Editor (Java OOP) ║");
        System.out.println("╚══════════════════════════════════════════╝");

        while (running) {
            System.out.println();
            line();
            System.out.println("MENU");
            line();
            System.out.println("1. Add Text");
            System.out.println("2. Reverse Text");
            System.out.println("3. Delete a Portion");
            System.out.println("4. Replace a Portion");
            System.out.println("5. Insert at Position");
            System.out.println("6. Clear All Text");
            System.out.println("7. Display Current Text");
            System.out.println("8. Show Text Length");
            System.out.println("9. Run Demo (auto test all features)");
            System.out.println("0. Exit");
            line();
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {

                case "1":
                    System.out.print("Enter text to add: ");
                    String toAdd = sc.nextLine();
                    doc.addText(toAdd);
                    System.out.println("[✓] Text added.");
                    doc.displayText();
                    break;

                case "2":
                    doc.reverseText();
                    System.out.println("[✓] Text reversed.");
                    doc.displayText();
                    break;

                case "3":
                    System.out.println("Current length: " + doc.getLength());
                    System.out.print("Enter start index: ");
                    int dStart = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter end index  : ");
                    int dEnd   = Integer.parseInt(sc.nextLine().trim());
                    doc.deleteText(dStart, dEnd);
                    System.out.println("[✓] Portion deleted.");
                    doc.displayText();
                    break;

                case "4":
                    System.out.println("Current length: " + doc.getLength());
                    System.out.print("Enter start index : ");
                    int rStart = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter end index   : ");
                    int rEnd   = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter replacement : ");
                    String replacement = sc.nextLine();
                    doc.replaceText(rStart, rEnd, replacement);
                    System.out.println("[✓] Text replaced.");
                    doc.displayText();
                    break;

                case "5":
                    System.out.println("Current length: " + doc.getLength());
                    System.out.print("Enter offset position: ");
                    int offset = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter text to insert : ");
                    String toInsert = sc.nextLine();
                    doc.insertText(offset, toInsert);
                    System.out.println("[✓] Text inserted.");
                    doc.displayText();
                    break;

                case "6":
                    doc.clearText();
                    System.out.println("[✓] Text cleared.");
                    doc.displayText();
                    break;

                case "7":
                    doc.displayText();
                    break;

                case "8":
                    System.out.println("Text length: " + doc.getLength() + " character(s)");
                    break;

                case "9":
                    runDemo(doc);
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye! Editor closed.");
                    break;

                default:
                    System.out.println("[!] Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    static void runDemo(Document doc) {

        System.out.println("=== AUTO DEMO MODE ===");
        line();

        doc.clearText();

        doc.addText("Hello World");
        System.out.print("After addText(\"Hello World\") → ");
        doc.displayText();

        doc.reverseText();
        System.out.print("After reverseText() → ");
        doc.displayText();

        doc.reverseText();
        System.out.print("After reverseText() again → ");
        doc.displayText();

        doc.insertText(6, "Beautiful ");
        System.out.print("After insertText(6,\"Beautiful\") → ");
        doc.displayText();

        doc.deleteText(6, 16);
        System.out.print("After deleteText(6,16) → ");
        doc.displayText();

        doc.replaceText(6, 11, "Java");
        System.out.print("After replaceText(6,11,\"Java\") → ");
        doc.displayText();

        doc.clearText();
        System.out.print("After clearText() → ");
        doc.displayText();

        line();
        System.out.println("=== DEMO COMPLETE ===");
    }
}