// GUI using Java Swing for the Perceptron
// Part of ICS-121, 2020
  
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

class NewFrame extends JFrame implements ActionListener
{
    // Components of the Interface
    private Container c;
    private JLabel title;
    private JLabel learning_rate;
    private JTextField tlearning;
    private JLabel gate;
    private JComboBox gate_type;
    private JLabel initial_weight_1;
    private JTextField tweight_1;
    private JLabel initial_weight_2;
    private JTextField tweight_2;
    private JButton submit; 
    private JButton reset;
    private JButton start;
    private JTextArea tout;

    private String gates[] = { "AND", "OR"};                        

    // constructor to initialize the components
    // with default values
    public NewFrame()
    {
        // Main Window
        setTitle("Perceptron");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c  = getContentPane();
        c.setLayout(null);

        // Heading
        title = new JLabel("Perceptron"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title);
        
        // Learning Rate
        // 0 < (double)learning rate < 1
        learning_rate = new JLabel("Learning Rate");
        learning_rate.setFont(new Font("Arial", Font.PLAIN, 20)); 
        learning_rate.setSize(150, 30); 
        learning_rate.setLocation(50, 100); 
        c.add(learning_rate);

        tlearning = new JTextField();
        tlearning.setFont(new Font("Arial", Font.PLAIN, 15));
        tlearning.setSize(50, 20);
        tlearning.setLocation(250, 100);
        c.add(tlearning);
        
        // Logic Gate Type
        // AND or OR Gate
        gate = new JLabel("Logic Gate");
        gate.setFont(new Font("Arial", Font.PLAIN, 20)); 
        gate.setSize(150, 30); 
        gate.setLocation(50, 150); 
        c.add(gate);

        gate_type = new JComboBox(gates); 
        gate_type.setFont(new Font("Arial", Font.PLAIN, 15)); 
        gate_type.setSize(100, 20); 
        gate_type.setLocation(250, 150); 
        c.add(gate_type);

        // Initial Weights for the perceptron
        // 0 < (double)weigths < 1
        initial_weight_1 = new JLabel("Initial Weight 1");
        initial_weight_1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        initial_weight_1.setSize(150, 30); 
        initial_weight_1.setLocation(50, 200); 
        c.add(initial_weight_1);

        tweight_1 = new JTextField();
        tweight_1.setFont(new Font("Arial", Font.PLAIN, 15));            
        tweight_1.setSize(50, 20);
        tweight_1.setLocation(250, 200);
        c.add(tweight_1);

        initial_weight_2 = new JLabel("Initial Weight 2");
        initial_weight_2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        initial_weight_2.setSize(150, 30); 
        initial_weight_2.setLocation(50, 250); 
        c.add(initial_weight_2);

        tweight_2 = new JTextField();
        tweight_2.setFont(new Font("Arial", Font.PLAIN, 15));
        tweight_2.setSize(50, 20);
        tweight_2.setLocation(250, 250);
        c.add(tweight_2);

        // Submit button
        submit = new JButton("Submit"); 
        submit.setFont(new Font("Arial", Font.PLAIN, 15)); 
        submit.setSize(100, 20); 
        submit.setLocation(150, 350); 
        submit.addActionListener(this); 
        c.add(submit);

        // Reset button
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20); 
        reset.setLocation(210, 450); 
        reset.addActionListener(this); 
        c.add(reset);

        // Start button
        start = new JButton("START");
        start.setFont(new Font("Arial", Font.PLAIN, 15));
        start.setSize(100, 20); 
        start.setLocation(270, 350); 
        start.addActionListener(this); 
        c.add(start);

        // Text Display Area
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(300, 400); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout);
    }

    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit){
            String data = "Learning Rate: " + tlearning.getText() + "\n";
            String data1 = "Logic Gate: " + (String)gate_type.getSelectedItem() + "\n";
            String data2 = "Initial Weight 1: " + tweight_1.getText() + "\n";
            String data3 = "Initial Weight 2: " + tweight_2.getText() + "\n";

            // assigning the values to perceptron class objects
            TruthTable.assigndata(tweight_1.getText(), tweight_2.getText(), tlearning.getText());
            
            if ((String)gate_type.getSelectedItem() == "AND")
            {
                TruthTable.assignanddata();
            }
            else
            {
                TruthTable.assignordata();
            }
            
            tout.setText(data + data1 + data2 + data3);
            tout.setEditable(false);
        }
        else if (e.getSource() == reset)
        {
            String def = "";
            tlearning.setText(def);
            gate_type.setSelectedIndex(0);
            tweight_1.setText(def);
            tweight_2.setText(def);
            tout.setText(def);
        }
        // Starts the Driver
        else if (e.getSource() == start)
        {
            ConsoleOutput.guiOutput();
        }

    }

}


class MainForm{
    public static void main(String[] args) throws Exception 
    { 
         new NewFrame().setVisible(true);
    } 
}
