import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Driver{

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

    public void guiConsoleTest() {
        System.out.println("Normal java console output");

        JTextArea textArea = new JTextArea(); // Output text area

        // Remember old output stream (optional)
        PrintStream stdout = System.out;
        stdout.println("Starting gui for console output"); // Still works
        // Stream for output to gui
        GuiOutputStream rawout = new GuiOutputStream(textArea);
        // Set new stream for System.out
        System.setOut(new PrintStream(rawout, true));

        // Demo gui
        JFrame window = new JFrame("Console test 2");
        window.add(new JScrollPane(textArea));
        window.setSize(500, 500);
        window.setVisible(true);

        // Test it (for 10 sec)
       execute();
    }

    public void execute()
    {
        int[][][] data = Perceptron.targetdata;
        double[] weights = Perceptron.INTIAL_WEIGHTS;
        Driver driver = new Driver();
        Perceptron perceptron = new Perceptron();
        int epochnumber = 0;
        boolean errorflag = true;
        double error = 0;
        double[] adjustedweights = null;
        while(errorflag){
            driver.printHeading(epochnumber++);
            errorflag = false  ;
            error = 0;
            for(int x =0; x< data.length;x++){
                double weightedsum = perceptron.calculateWeightedsum(data[x][0], weights);
                int result = perceptron.applyActivationFunction(weightedsum);
                error= data[x][1][0] - result  ;
                if(error !=0 )  errorflag = true;
                adjustedweights = perceptron.adjustweight(data[x][0], weights, error);
                driver.printvector(data[x],weights, result , error, weightedsum, adjustedweights);
                weights = adjustedweights;


            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

        }
    }

    public void printHeading( int epochNumber)
    {
        System.out.println("\n===========================================Epoch #" + epochNumber+"======================================================");
        System.out.println("    w1  |   w2   |  x1  |  x2  |  Target Result  |  Result  |  error  | Weighted sum | adjusted w1  |  adjusted w2 ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
    }
    public void printvector(int[][] data, double[] weights , int result , double error , double weightedsum , double[] adjustedweights ) {
        System.out.println(" "+String.format("%.2f",weights[0])+"    |   "+String.format("%.2f",weights[1])+"    |   "+data[0][0]+"  |   "+data[0][1]+
                            "   |   "+data[1][0]+"    |    "+result+"   |   "+error+"   |   "+String.format("%.2f", weightedsum)+
                            "   |   "+String.format("%.2f",adjustedweights[0]) + "  |   "+String.format("%.2f",adjustedweights[1]));

    }

    public static void main(String[] args) {
        new Driver().guiConsoleTest();
    }
}