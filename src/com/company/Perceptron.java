package com.company;
//Import Statements
import java.util.Random;

public class Perceptron {
    //Instance Variables
    private double bias;//todo
    private double[] arrayofInputs;
    private double[] weightsForInputs;

    //Constructors
    public Perceptron(double[] arrayofInputs) {
        //Take the input in
        this.arrayofInputs = arrayofInputs;
        this.weightsForInputs = generateWeights(arrayofInputs.length);

        double[] productOfInputAndWeight = new double[arrayofInputs.length];
        double sumOfProduct = 0.0;

        for (int i = 0; i < this.arrayofInputs.length; i++) {
            productOfInputAndWeight[i] = this.arrayofInputs[i]*weightsForInputs[i];
            sumOfProduct += productOfInputAndWeight[i];
        }
        System.out.println("Sum Final : "+sumOfProduct);

        sumOfProduct += generateBias();

        if (sigmoid(sumOfProduct) > 0.5){
            System.out.println(sigmoid(sumOfProduct)+" Neuron fires");
        }else{
            System.out.println(sigmoid(sumOfProduct)+" Neuron doesn't");
        }

    }
    //Method to return the Bias
    public double generateBias(){
        Random r = new Random();
        int max = 10;
        int min = -10;

        double number = r.nextInt(max + 1 -min) + min;

        return number;
    }

    //Method to generate weights
    public double[] generateWeights(int sizeOfInputArray) {
        Random r = new Random();

        int max = 3;
        int min = -3;

        double[] arrayOfWeights = new double[sizeOfInputArray];

        for (int i = 0; i < sizeOfInputArray; i++) {
            double number = r.nextInt(max + 1 -min) + min;
            double decimal = r.nextDouble();
            arrayOfWeights[i] = number + decimal;
        }
        return arrayOfWeights;
    }

    //Sigmoid Function
    public double sigmoid(double x) {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
    }

}
