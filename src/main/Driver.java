public class Driver 
{
    public static void runDriver()
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

        }

    }
    public void printHeading( int epochNumber)
    {
        System.out.println("\n====================================Epoch #" + epochNumber+"====================================");
        System.out.println("    w1   |   w2      |  x1  |  x2  |  Target Result  |  Result  |  error  | Weighted sum | adjusted w1  |  adjusted w2 ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void printvector(int[][] data, double[] weights , int result , double error , double weightedsum , double[] adjustedweights ) {
        System.out.println(" "+String.format("%.2f",weights[0])+"    |   "+String.format("%.2f",weights[1])+"    |   "+data[0][0]+"  |   "+data[0][1]+
                            "   |            "+data[1][0]+"             |      "+result+"      |   "+error+"   |         "+String.format("%.2f", weightedsum)+
                            "         |        "+String.format("%.2f",adjustedweights[0]) + "        |   "+String.format("%.2f",adjustedweights[1]));

    }
}
