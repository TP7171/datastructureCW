/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurecw;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author thiag
 */
public class Saver {

    //Method to save all the array information in the file
    public static void saver(List<person> listIn) {

        //Using of the trycatch to avoid exception
        try (
                FileWriter personFile = new FileWriter("file.txt");
                PrintWriter personSaver = new PrintWriter(personFile);) {

            //Loop to save all items 
            for (person item : listIn) {
                String status;
                if ((!"Alive".equals(item.getStatus())) && ((!"Dead".equals(item.getStatus())))) {
                    personSaver.println("Name: " + item.getName() + " Gender: " + item.getGender() + " Mother: " + item.getMother() + " Father: " + item.getFather() + " Married to " + item.getMarried() + " Status: killed by " + item.getStatus());
                } else {
                    personSaver.println("Name: " + item.getName() + " Gender: " + item.getGender() + " Mother: " + item.getMother() + " Father: " + item.getFather() + " Married to " + item.getMarried() + " Status: " + item.getStatus());

                }

            }
        } catch (IOException e) {
            System.out.println("There was a problem writing the file");
        }

    }
}
