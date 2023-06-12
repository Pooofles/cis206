/*
Author: Jessica Sandoval
Date: June 05, 2023
Email: sandovalj51506@student.vvc.edu
Description:
Write a program that will include the following:
1.A class that will store mountain details which will included the following:

           Member for the name, (make it private for java or c++)
           Member for the country, (make it private for java or c++)
           Member for the elevation, (make it private for java or c++)
           Setters and getters for all the data members. (Make them public for java or c++)

           A member function call toMeters that will take the elevation and convert the value from feet 
           to meters and return the converted value.  The relationship for feet to meters is 1 meter per 
           3.2808 feet

2. In the main function of the Main class(for java, main function for c++ and  a main function for python with the __name__=="__main__" structure) ,
   create 7 instances of Mountain objects and put the mountain data from the table above.
3. Put the mountain objects in an appropriate data structure for the language that you are writing this for.
4. Write a method called minElevation in the (Main class for java, main module for python, or the file that has main for c++) that will return the minimum elevation.
5. Iterate over the data structure that contains the Mountain objects and print out the Mountain details similar to the table above, with the addition of the elevation
   in feet and in meters.
6. Programmatically print out the elevation and name of the shortest mountain (do not hard code this)

Table provided:
Mountain                                       Country                                        Elevation
Chimborazo                                     Ecuador                                         20,549 ft
Matterhorn                                   Switzerland                                       14,692 ft
Olympus                                    Greece (Macedonia)                                   9,573 ft
Everest                                         Nepal                                          29,029 ft
Mount Marcy - Adirondacks                   United States                                       5,344 ft
Mount Mitchell - Blue Ridge                 United States                                       6,684 ft
Zugspitze                                    Switzerland                                        9,719 ft
*/

import java.util.ArrayList;
import java.util.List;

class Mountain {
    private String name;
    private String country;
    private double elevation;

    public Mountain(String name, String country, double elevation) {
        this.name = name;
        this.country = country;
        this.elevation = elevation;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getElevation() {
        return elevation;
    }

    // Convert elevation from feet to meters
    public double toMeters() {
        return elevation / 3.2808;
    }
}

public class Main {
    // Find the minimum elevation among the mountains
    public static double minElevation(List<Mountain> mountains) {
        if (mountains.isEmpty()) {
            return 0.0; // Return 0 if the list is empty
        }

        double minElev = mountains.get(0).getElevation();
        for (Mountain mountain : mountains) {
            if (mountain.getElevation() < minElev) {
                minElev = mountain.getElevation();
            }
        }
        return minElev;
    }

    public static void main(String[] args) {
        // Create Mountain objects
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain("Chimborazo", "Ecuador", 20549));
        mountains.add(new Mountain("Matterhorn", "Switzerland", 14692));
        mountains.add(new Mountain("Olympus", "Greece (Macedonia)", 9573));
        mountains.add(new Mountain("Everest", "Nepal", 29029));
        mountains.add(new Mountain("Mount Marcy - Adirondacks", "United States", 5344));
        mountains.add(new Mountain("Mount Mitchell - Blue Ridge", "United States", 6684));
        mountains.add(new Mountain("Zugspitze", "Switzerland", 9719));

        // Print mountain details
        System.out.println("\t\tMountain\t\t\t Country\t\t\t\tElevation (ft)\t\t\t\t Elevation (m)");
        for (Mountain mountain : mountains) {
            System.out.printf("\t\t%s \t\t\t %s   \t\t\t\t%.2f\t\t\t\t         %.2f%n",
                    mountain.getName(), mountain.getCountry(), mountain.getElevation(), mountain.toMeters());
        }

        // Find the shortest mountain
        double minElev = minElevation(mountains);
        System.out.println("\nShortest Mountain: " + minElev + " ft");
    }
}
