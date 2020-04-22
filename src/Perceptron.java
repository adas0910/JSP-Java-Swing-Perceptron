public class Perceptron {
    public static int[][][] targetdata = {{{0,0},{0}},
                                            {{0,0},{0}},
                                            {{0,0},{0}},
                                            {{0,0},{0}}}; //default 3d array of target results
    public static double LEARNING_RATE;
    public static double[] INTIAL_WEIGHTS = new  double[2];
    public double calculateWeightedsum(int[] data, double[] weights){
        double weightedsum = 0;
        for(int x=0;x< data.length; x++) 
            weightedsum += data[x]*weights[x];
        return weightedsum;
    }
    public int applyActivationFunction(double weightedsum){
        int result = 0;
        if(weightedsum>1)result = 1;
        return result;
    }
    public double[] adjustweight(int[] data, double[] weights, double error){
        double[] adjustedweights = new double[weights.length];
        for(int x= 0; x< weights.length;x++) adjustedweights[x]= LEARNING_RATE * error * data[x] + weights[x];
        return adjustedweights;
    }



}
