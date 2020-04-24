// Training Set for truth table for the perceptron to use 
// depending on user's choice of the type of logical operation(gate)

class TruthTable
{
    // training set for AND gate
    public static int [][][] anddata = {{{0,0},{0}},
                                            {{0,1},{0}},
                                            {{1,0},{0}},
                                            {{1,1},{1}}};
    
    // training set for OR gate
    public static int [][][] ordata = {{{0,0},{0}},
                                {{0,1},{1}},
                                {{1,0},{1}},
                                {{1,1},{1}}};

    
    // method assigndata
    // to pass initial weights and learning rate to perceptron
    // formal parameter accepted from textfields from class MainForm
    public static  void assigndata(String iniweight1, String iniweight2, String learning){
        double w1 = Double.parseDouble(iniweight1);
        double w2 = Double.parseDouble(iniweight2);
        Perceptron.LEARNING_RATE = Double.parseDouble(learning);
        Perceptron.INTIAL_WEIGHTS = new double[] {w1, w2};
    }

    // method assignanddata
    // to pass AND data as target data to perceptron
    public static void assignanddata(){
        for(int i = 0; i <4; i++){
            for (int j = 0; j<2; j++){
                for (int k = 0; k<Perceptron.targetdata[0][j].length; k++){
                    Perceptron.targetdata[i][j][k] = anddata[i][j][k];
                }
            }
        }        
    }

    // method assignordata
    // to pass OR data as target data to perceptron
    public static void assignordata(){
        for(int i = 0; i <4; i++){
            for (int j = 0; j<2; j++){
                for (int k = 0; k<Perceptron.targetdata[0][j].length; k++){
                    Perceptron.targetdata[i][j][k] = ordata[i][j][k];
                }
            }
        }
    }
}