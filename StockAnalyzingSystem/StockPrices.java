/*
 * Compilation: javac stockPrices.java
 * Execution: java stockPrices
 * 
 * The program computes the average of stock prices, finds the highest stock price,
 * counts how many times a specific price appears and computes the cumulative sum of stock prices.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class stockPrices {

    /**
     * This method calculates the average stock price bys using the array of stock prices as input and returns the average price of the stocks.
     */
    public static float calculateAveragePrice(float[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("The array should not be null.");
        }
        float sum = 0;
        for (float price : prices) {
        sum += price;
        }
        return sum / prices.length;
      }

    /*
     * This method takes the array of stock prices as input and returns the maximum price among all the stocks.
     */
    public static float findMaximumPrice(float[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("The array should not be null.");
        }
        float maxPrice = prices[0];
        for (float price : prices) {
        if (price > maxPrice) {
        maxPrice = price;
        }
        }
        return maxPrice;
      }
    
    /*
     * This method takes the array of stock prices and a target price as input and returns the number of times the target price occurs in the array.
     */
    public static int countOccurrences(float[] prices, float targetPrice) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("The array should not be null.");
        }
        int count = 0;
        for (float price : prices) {
        if (price == targetPrice) {
        count++;
        }
        }
        return count;
      }

    /*
     * This method takes the ArrayList of stock prices,stockPriceList, as input and returns a new ArrayList containing the cumulative sum of prices at each position.
     */
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        if (prices == null || prices.isEmpty()) {
            throw new IllegalArgumentException("The ArrayList should not be null.");
        }
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
        sum += price;
        cumulativeSum.add(sum);
        }
        return cumulativeSum;
      }
      
    public static void main(String[] args) {
        
        float[] stockPrice;
        stockPrice = new float[10];
        stockPrice[0] = 34.2f;
        stockPrice[1] = 33.9f;
        stockPrice[2] = 33.0f;
        stockPrice[3] = 33.0f;
        stockPrice[4] = 33.7f;
        stockPrice[5] = 32.9f;
        stockPrice[6] = 32.0f;
        stockPrice[7] = 32.7f;
        stockPrice[8] = 33.1f;
        stockPrice[9] = 32.5f;
    
        // Example ArrayList of stock prices
        ArrayList<Float> stockPriceList = new ArrayList<>();
        stockPriceList.add(34.2f);
        stockPriceList.add(33.9f);
        stockPriceList.add(33.0f);
        stockPriceList.add(33.0f);
        stockPriceList.add(33.7f);
        stockPriceList.add(32.9f);
        stockPriceList.add(32.0f);
        stockPriceList.add(32.7f);
        stockPriceList.add(33.1f);
        stockPriceList.add(32.5f);

        /*
         * Calculate the average stock price and display the value.
         */
        double averagePrice = calculateAveragePrice(stockPrice);
        System.out.println("The Average Stock Price is: " + averagePrice);

        /*
         * Find the maximum stock price and display the value.
         */
        float maxPrice = findMaximumPrice(stockPrice);
        System.out.println("The Maximum Stock Price is: " + maxPrice);

        // Get user input for target price
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target price to find in the stock prices:");
        float targetPrice = scanner.nextFloat();
        scanner.close();

        /*
         * Count the occurences of the target price and display the result.
         */
        int occurrences = countOccurrences(stockPrice, targetPrice);
        System.out.println("The number of occurences of " + targetPrice + " is:" + occurrences);

        /*
         * Compute the cummulative sum of stock prices at each stock position
         */
        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPriceList);
        System.out.println("The Cumulative Sum of stock prices at each position is:" + cumulativeSum);
    
    }

    }
