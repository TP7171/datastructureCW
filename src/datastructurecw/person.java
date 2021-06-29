/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurecw;

/**
 *  class to save information about the persons
 * @author thiag
 */
public class person {

    private String gender;
    private String mother;
    private String father;
    private String name;
    private String married;
    private String status;

    public person(String name, String gender, String mother, String father, String married, String status) {

        this.gender = gender;
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.married = married;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return ("Name: " + name + " Gender: " + gender + " Mother: " + mother + " Father: " + father + " Married to: " + married + " Status: " + status);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ("Name: " + name + " Gender: " + gender + " Mother: " + mother + " Father: " + father + " Married to: " + married);
    }

}
