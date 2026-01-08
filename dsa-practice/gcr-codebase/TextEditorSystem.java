class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class EditorHistory {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_LIMIT = 10; // Fixed size limit

    // 1. Add New State (Action perform karna)
    public void performAction(String newText) {
        TextState newState = new TextState(newText);

        // Agar koi redo states hain, toh naya action karne par wo delete ho jayengi
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        } else {
            head = newState;
        }

        current = newState;
        size++;

        // 2. Limit check: Agar 10 se zyada states ho jayein toh purani delete karein
        if (size > MAX_LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }
        System.out.println("Typed: \"" + current.content + "\"");
    }

    // 3. Undo Functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo Done. Current State: \"" + current.content + "\"");
        } else {
            System.out.println("Nothing to Undo!");
        }
    }

    // 4. Redo Functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo Done. Current State: \"" + current.content + "\"");
        } else {
            System.out.println("Nothing to Redo!");
        }
    }

    // 5. Display Current State
    public void displayCurrent() {
        if (current != null) {
            System.out.println("\n[Editor Screen]: " + current.content);
        } else {
            System.out.println("\n[Editor Screen]: (Empty)");
        }
    }
}

public class TextEditorSystem {
    public static void main(String[] args) {
        EditorHistory editor = new EditorHistory();

        editor.performAction("Hello");
        editor.performAction("Hello World");
        editor.performAction("Hello World!");

        editor.displayCurrent();

        editor.undo(); // Wapas "Hello World" par
        editor.undo(); // Wapas "Hello" par
        
        editor.redo(); // Phir se "Hello World" par

        // Naya action after undo (Redo history clear ho jayegi)
        editor.performAction("Hello Java");
        
        editor.redo(); // Yeh "Nothing to Redo" kahega
        editor.displayCurrent();
    }
}
