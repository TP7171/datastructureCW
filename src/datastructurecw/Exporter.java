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
public class Exporter {

    public static void graph(List<person> listIn) {

        //Using of the trycatch to avoid exception
        try (
                FileWriter patientFile = new FileWriter("graph.DOT");
                PrintWriter patientSaver = new PrintWriter(patientFile);) {
            patientSaver.println("digraph GoT {");
            patientSaver.println("rankdir=LR;");
            patientSaver.println("size=\"20\"");
            patientSaver.println("node [shape = rectangle];");

            for (person item : listIn) {

                if (!"Unknown".equals(item.getFather())) {
                    //System.out.println(item.getName() + " Saving" + " " + item.getFather());
                    patientSaver.println("\"" + item.getFather() + "\"" + " -> " + "\"" + item.getName() + "\"" + " " + "[label=\"father\"];");
                }

                if (!"Unknown".equals(item.getMother())) {
                    //System.out.println(item.getName() + " Saving" + " " + item.getMother());
                    patientSaver.println("\"" + item.getMother() + "\"" + " -> " + "\"" + item.getName() + "\"" + " " + "[label=\"mother\"];");
                }

                if (!"Not Married or Unknown".equals(item.getMarried())) {
                    if ("man".equals(item.getGender())) {
                        //System.out.println(item.getName() + " Saving" + "Wedding Between " + item.getName()+" And "+item.getMarried());
                        patientSaver.println("\"" + item.getName() + "\"" + " -> " + "\"" + item.getMarried() + "\"" + " " + "[label=\"married\"];");
                    }

                }

            }
            patientSaver.println("}");
        } catch (IOException e) {
            System.out.println("There was a problem writing the file");
        }

    }

    public static void graphAll(List<person> listIn) {

        //Using of the trycatch to avoid exception
        try (
                FileWriter patientFile = new FileWriter("graphAll.DOT");
                PrintWriter patientSaver = new PrintWriter(patientFile);) {
            patientSaver.println("digraph GoT {");
            patientSaver.println("rankdir=LR;");
            patientSaver.println("size=\"20\"");
            patientSaver.println("node [shape = rectangle];");

            for (person item : listIn) {

                if ((!"Alive".equals(item.getStatus())) && (!"Dead".equals(item.getStatus()))) {

                    //System.out.println(item.getName() + " Saving" + "Kill of " + item.getName());
                    patientSaver.println("\"" + item.getStatus() + "\"" + " -> " + "\"" + item.getName() + "\"" + " " + "[label=\"killed\"];");

                }

                if (!"Unknown".equals(item.getFather())) {
                    //System.out.println(item.getName() + " Saving" + " " + item.getFather());
                    patientSaver.println("\"" + item.getFather() + "\"" + " -> " + "\"" + item.getName() + "\"" + " " + "[label=\"father\"];");
                }

                if (!"Unknown".equals(item.getMother())) {
                    //System.out.println(item.getName() + " Saving" + " " + item.getMother());
                    patientSaver.println("\"" + item.getMother() + "\"" + " -> " + "\"" + item.getName() + "\"" + " " + "[label=\"mother\"];");
                }

                if (!"Not Married or Unknown".equals(item.getMarried())) {
                    if ("man".equals(item.getGender())) {
                        //System.out.println(item.getName() + " Saving" + "Wedding Between " + item.getName()+" And "+item.getMarried());
                        patientSaver.println("\"" + item.getName() + "\"" + " -> " + "\"" + item.getMarried() + "\"" + " " + "[label=\"married\"];");
                    }

                }
            }

            patientSaver.println("}");
        } catch (IOException e) {
            System.out.println("There was a problem writing the file");
        }

    }

    public static void graphKills(List<person> listIn) {

        //Using of the trycatch to avoid exception
        try (
                FileWriter patientFile = new FileWriter("graphKills.DOT");
                PrintWriter patientSaver = new PrintWriter(patientFile);) {
            patientSaver.println("digraph GoT {");
            patientSaver.println("rankdir=LR;");
            patientSaver.println("size=\"12\"");
            patientSaver.println("node [shape = rectangle];");

            for (person item : listIn) {

                if ((!"Alive".equals(item.getStatus())) && (!"Dead".equals(item.getStatus()))) {

                    //System.out.println(item.getName() + " Saving" + "Kill of " + item.getName());
                    patientSaver.println("\"" + item.getStatus() + "\"" + " -> " + "\"" + item.getName() + "\"" + " " + "[label=\"killed\"];");

                }

            }
            patientSaver.println("}");
        } catch (IOException e) {
            System.out.println("There was a problem writing the file");
        }

    }
}
