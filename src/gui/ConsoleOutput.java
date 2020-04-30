import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsoleOutput{

    private class GuiOutputStream extends OutputStream 
    {
        JTextArea textArea;

        public GuiOutputStream(JTextArea textArea) 
        {
            this.textArea = textArea;
        }

        @Override
        public void write(int data) throws IOException 
        {
            textArea.append(new String(new byte[] { (byte) data }));
        }
    }

    public void guiConsole() {
        System.out.println("Normal java console output");
        // Output text area
        JTextArea textArea = new JTextArea();
        // Remember old output stream 
        PrintStream stdout = System.out;
        stdout.println("Starting gui for console output");
        // Stream for output to gui
        GuiOutputStream rawout = new GuiOutputStream(textArea);
        // Set new stream for System.out
        System.setOut(new PrintStream(rawout, true));

        // Demo gui
        JFrame window = new JFrame("Console test");
        window.add(new JScrollPane(textArea));
        window.setSize(500, 500);
        window.setVisible(true);

        // Calling main method from driver class
       Driver.runDriver();
    }

    public static void guiOutput()
    {
        new ConsoleOutput().guiConsole();
    }
}