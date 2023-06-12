package forms;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class CustomOutputStream extends OutputStream {
    private JTextPane textPane;

    public CustomOutputStream(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void write(int b) throws IOException {
        Document doc = textPane.getDocument();
        try {
            doc.insertString(doc.getLength(), String.valueOf((char) b), null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        textPane.setCaretPosition(doc.getLength());
    }
}
