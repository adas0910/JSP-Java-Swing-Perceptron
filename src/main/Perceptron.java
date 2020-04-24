public class Perceptron 
{
    // Target Data/Training Set for the perceptron
    // default 3d array representation of target data
    public static int[][][] targetdata = {{{0,0},{0}},
                                            {{0,0},{0}},
                                            {{0,0},{0}},
                                            {{0,0},{0}}};
    // Learning Rate for the perceptron
    public static double LEARNING_RATE;
    
    // Initial weights for the perceptron
    public static double[] INTIAL_WEIGHTS = new  double[2];
    
    // method calculateWeigtheddsum
    // to calculate the weighted sum depending on the input values from training set/target data and corresponding initial weights
    public double calculateWeightedsum(int[] data, double[] weights)
    {
        double weightedsum = 0;
        for(int x=0;x< data.length; x++) 
            weightedsum += data[x]*weights[x];
        return weightedsum;
    }

    // assings the actual value to the output depending on the weighted sum
    public int applyActivationFunction(double weightedsum)
    {
        int result = 0;
        if(weightedsum>1)result = 1;
        return result;
    }

    // updates and adjusts the weights depending on the error calculated
    public double[] adjustweight(int[] data, double[] weights, double error){
        double[] adjustedweights = new double[weights.length];
        for(int x= 0; x< weights.length;x++) adjustedweights[x]= LEARNING_RATE * error * data[x] + weights[x];
        return adjustedweights;
    }



}
