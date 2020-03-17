public class Perceptron {
    public static final int[][][] anddata = {{{0,0},{0}},
                                            {{0,1},{0}},
                                            {{1,0},{0}},
                                            {{1,1},{1}}};
    public static final double LEARNING_RATE = 0.05;
    public static final double[] INTIAL_WEIGHTS = {0.33, 0.65};//{Math.random(),Math.random()};
    public double calculateWeightedsum(int[] data, double[] weights){
        double weightedsum = 0;
        for(int x=0;x< data.length; x++) weightedsum += data[x]*weights[x];
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
