/**
 * Khoi Tran
 * CMSC 401
 * Professor Bulut
 * This assignment is to find the second cheapest path from Richmond to Los Angeles using Dijkstra's algorithm
 */
package sample;

import java.util.*;

public class assignment3 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        //Start taking input for the cities and the roads in between
        int cities = input.nextInt();
        int roads = input.nextInt();
        int[] motelCost = new int[cities + 1];
        int[] citiesNum = new int[cities + 1];
        motelCost[0] = 0;
        motelCost[1] = 0;
        motelCost[2] = 0;
        citiesNum[0] = 0;
        citiesNum[1] = 0;
        citiesNum[2] = 0;
        List<City> visitNode = new ArrayList<City>();
        List<City> nonVisitNode = new ArrayList<City>();

        City zeroCity = new City(0, 0);
        nonVisitNode.add(zeroCity);
        visitNode.add(zeroCity);

        //For the loop it has to be cities - 2 because taken in account for Richmond and LA no being count
        for (int i = 0; i <= cities - 2; i++){
            citiesNum[i] = input.nextInt();
            motelCost[i] = input.nextInt();
        }

        for (int c = 1; c <= cities; c++){
            City temporary = new City(citiesNum[c], motelCost[c]);
            nonVisitNode.add(temporary);
        }

        int[][] gas = new int[cities + 1][cities + 1];
        for (int[] row: gas){
            Arrays.fill(row, 0);
        }
        //Generate the distance or gas cost between two cities
        int cityA;
        int cityB;
        int gasCost;
        for (int j = 1; j <= roads; j++){
            cityA = input.nextInt();
            cityB = input.nextInt();
            gasCost = input.nextInt();
            gas[cityA][cityB] = gasCost;
            gas[cityB][cityA] = gasCost;
        }
        //Total cost from one city to another
        int[][] totalCost = new int[cities + 1][cities + 1];
        for (int a = 1; a <= cities; a++){
            for (int b = 1; b <= cities; b++){
                totalCost[a][b] = gas[a][b] + motelCost[b];
            }
        }
        //So the cost from the start of Richmond holds the shortest mileage between all the cities
        int[] startCost = new int[cities + 1];
        Arrays.fill(startCost, 999);
        startCost[0] = 0;
        startCost[1] = 0;
        int currentCity = 1;
        //This is to track whether the city is finalized or whether it has been visited or not
        boolean[] finalCityBool = new boolean[cities + 1];
        Arrays.fill(finalCityBool, false);
        finalCityBool[0] = true;
        int closestNonVisitCity = 999;

        while (visitNode.size() <= cities){
            //Start checking for the next city
            for (int checkCity = 1; checkCity <= cities; checkCity++){
                if (!finalCityBool[checkCity]){
                    if (startCost[checkCity] < closestNonVisitCity){
                        currentCity = checkCity;
                        closestNonVisitCity = startCost[checkCity];
                    }
                }
            }
            closestNonVisitCity = 1000;
            visitNode.add(nonVisitNode.get(currentCity));
            //Now we can start checking it neighbors to determine the cost
            for (int neighbor = 1; neighbor <= cities; neighbor++){
                if (gas[currentCity][neighbor] > 0){
                    if (startCost[currentCity] + totalCost[currentCity][neighbor] < startCost[neighbor]){
                        startCost[neighbor] = totalCost[currentCity][neighbor] + startCost[currentCity];
                    }
                }
            }
            finalCityBool[currentCity] = true;

        }
        System.out.println(startCost[2]);
    }
}
//The city class to take in the city number between the edges and the previous city to take in
//account that it's already being calculated.
class City{
    private int cityNum;
    private int motelCost;
    private City previousCity;

    public City(int inCityNum){
        this.cityNum = inCityNum;
        this.previousCity = null;
    }
    public City(int inCityNum, int inMotelCost){
        this.cityNum = inCityNum;
        this.motelCost = inMotelCost;
        this.previousCity = null;
    }
    //Now have setter and getter for cityNum, motelCost and previousCity
    public int getCityNum(){
        return this.cityNum;
    }
    public void setCityNum(int inCityNum){
        this.cityNum = inCityNum;
    }
    public int getMotelCost(){
        return this.motelCost;
    }
    public void setMotelCost(int inMotelCost){
        this.motelCost = inMotelCost;
    }
    public City getPreviousCity(){
        return this.previousCity;
    }
    public void setPreviousCity(City inPreviousCity){
        this.previousCity = inPreviousCity;
    }
}
