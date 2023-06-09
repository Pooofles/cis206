/*
Author: Jessica Sandoval
Date: June 05, 2023
Email: sandovalj51506@student.vvc.edu
Description: Write a program that will include the following:
A class that will store mountain details which will included the following:

Member for the name, (make it private for java or c++)
Member for the country, (make it private for java or c++)
Member for the elevation, (make it private for java or c++)
Setters and getters for all the data members. (Make them public for java or c++)

A member function call toMeters that will take the elevation and convert the value from feet to meters and return the converted value. 
The relationship for feet to meters is 1 meter per 3.2808 feet

In the main function of the Main class(for java, main function for c++ and  a main function for python with the 
__name__=="__main__" structure) , create 7 instances of Mountain objects and put the mountain data from the table above.
Put the mountain objects in an appropriate data structure for the language that you are writing this for.
Write a method called minElevation in the (Main class for java, main module for python, or the file that has main for c++) that will 
return the minimum elevation.
Iterate over the data structure that contains the Mountain objects and print out the Mountain details similar to the table above, with 
the addition of the elevation in feet and in meters.
Programmatically print out the elevation and name of the shortest mountain (do not hard code this)

Table provided:
Mountain                                       Country                                        Elevation
Chimborazo                                     Ecuador                                         20,549 ft
Matterhorn                                   Switzerland                                       14,692 ft
Olympus                                    Greece (Macedonia)                                   9,573 ft
Everest                                       N  epal                                          29,029 ft
Mount Marcy - Adirondacks                   United States                                       5,344 ft
Mount Mitchell - Blue Ridge                 United States                                       6,684 ft
Zugspitze                                    Switzerland                                        9,719 ft
*/

import java.util.ArrayList;
import java.util.List;

//  Step 1: Create Mountain class with private data members name, country, and elevation 
class Mountain {
    private String name;
    private String country;
    private double elevation;

    public Mountain(String name, String country, double elevation) {
        this.name = name;
        this.country = country;
        this.elevation = elevation;
    }
    //Create and define setters and getters member-functions
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double toMeters() { // Convert elevation from feet to meters
        return elevation / 3.2808;  // 1 meter/3.2808 ft
    }
}

public class Main {
    public static void main(String[] args) {
        List<Mountain> mountains = new ArrayList<>();
      
        /* 
        Step 2: Create 7 instances of Mountain objects and add them as the table provided        
        Step 3: Put the Mountain objects in an appropriate data structure 
        */
        mountains.add(new Mountain("Chimborazo", "Ecuador", 20549));
        mountains.add(new Mountain("Matterhorn", "Switzerland", 14692));
        mountains.add(new Mountain("Olympus", "Greece (Macedonia)", 9573));
        mountains.add(new Mountain("Everest", "Nepal", 29029));
        mountains.add(new Mountain("Mount Marcy - Adirondacks", "United States", 5344));
        mountains.add(new Mountain("Mount Mitchell - Blue Ridge", "United States", 6684));
        mountains.add(new Mountain("Zugspitze", "Switzerland", 9719));
     
       
        double minElevation = minElevation(mountains);
        System.out.println("Minimum elevation: " + minElevation + " ft");

        // Sterp 5: Iterate over the mountains and print their details
        System.out.println("Mountain Details:");
        for (Mountain mountain : mountains) {
            System.out.println("Name: " + mountain.getName());
            System.out.println("Country: " + mountain.getCountry());
            System.out.println("Elevation (feet): " + mountain.getElevation());
            System.out.println("Elevation (meters): " + mountain.toMeters());
            System.out.println();
        }

        // Step 6 1/2: Find and print the shortest mountain
        Mountain shortestMountain = getShortestMountain(mountains);
        System.out.println("Shortest Mountain:");
        System.out.println("Name: " + shortestMountain.getName());
        System.out.println("Elevation: " + shortestMountain.getElevation() + " ft");
    }
    // Step 4: Write a method called minElevation in the Main class 
    public static double minElevation(List<Mountain> mountains) {
        double min = Double.MAX_VALUE;
        for (Mountain mountain : mountains) {
            if (mountain.getElevation() < min) {
                min = mountain.getElevation();
            }
        }
        return min; // return minimum elevation 
    }

  // Step 6 2/2: Programmatically print out the elevation and name of the shortest mountain. 
    public static Mountain getShortestMountain(List<Mountain> mountains) {
        Mountain shortestMountain = null;
        double minElevation = Double.MAX_VALUE;
        for (Mountain mountain : mountains) {  // DO NOT hard code.
            if (mountain.getElevation() < minElevation) {
                minElevation = mountain.getElevation();
                shortestMountain = mountain;
            }
        }
        return shortestMountain; 
    }
}
