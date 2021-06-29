package datastructurecw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fileReader {

    //method to load the data from the TXt file  
    public static void loadData(String fileRead, HashMap<String, person> inMap) {

        try {

            Scanner in = new Scanner(new java.io.FileReader(fileRead));
            String s = "";

            while (in.hasNextLine()) {
                String[] token = in.nextLine().split(", ");

                String name;
                String fact;
                String relation;
                String related;
                String parent;
                String mother;
                String father;
                String married;
                String status;

                // check if is a fact or a relation token size 2 = fact size 3 = relation
                if (token.length == 2) {

                    name = token[0].trim();
                    fact = token[1].trim();

                    //check if the map contains the key if the map contains it just update if not add the entry
                    if (inMap.containsKey(token[0])) {
                        inMap.get(token[0]).setGender(token[1]);
                        System.out.println("Updating " + name + " Gender");
                    } else {
                        inMap.put(token[0], new person(token[0], token[1], "", "", "", ""));
                        System.out.println("Adding " + name);

                    }

                }
                // check if tolen is fact or relation and if its a killed
                if (token.length == 3) {
                    parent = token[0];
                    relation = token[1];
                    name = token[2];

                    if (token[1].equals("killed")) {
                        if (inMap.containsKey(token[2])) {
                            inMap.get(token[2]).setStatus(token[0]);
                            System.out.println("Updating " + token[2] + " Status to killed by " + token[0]);
                        } else {
                            if (!"Unknown".equals(token[2])) {
                                inMap.put(token[2], new person(token[2], "", "", "", "", token[0]));
                                System.out.println("Adding " + name);

                            }
                        }

                    }

                    if ("married".equals(relation)) {
                        married = parent;
                    } else {
                        married = null;
                    }

                    if ("father".equals(relation)) {
                        father = parent;
                    } else {
                        father = null;
                    }

                    if ("mother".equals(relation)) {
                        mother = parent;
                    } else {
                        mother = null;
                    }

                    //checkj if the map contains the key
                    if (inMap.containsKey(name)) {
                        if (father != null) {
                            inMap.get(name).setFather(father);
                            System.out.println("Updating " + name + " Father name to " + father + " ");

                        } else if (mother != null) {
                            inMap.get(name).setMother(mother);
                            System.out.println("Updating " + name + " Mother name to " + mother + " ");
                        } else if (relation.equals("married")) {
                            System.out.println("Updating " + name + " Married to " + token[0] + " ");
                            inMap.get(name).setMarried(token[0]);

                        }

                    } else {
                        inMap.put(name, new person(name, null, mother, father, married, ""));
                        System.out.println("Adding " + name);
                    }
                }

            }
            try {

            } catch (Exception e) {
                System.out.println("Error");
            }

        } catch (Exception e) {
            System.out.println("Error while reading the txt file");
            e.printStackTrace();

        }
        Map<String, person> map = inMap;

        for (String key : map.keySet()) {

            if ("".equals(inMap.get(key).getFather()) || inMap.get(key).getFather() == null) {
                inMap.get(key).setFather("Unknown");

            }

            if ("".equals(inMap.get(key).getMother()) || inMap.get(key).getMother() == null) {
                inMap.get(key).setMother("Unknown");

            }

            if ("".equals(inMap.get(key).getGender()) || inMap.get(key).getGender() == null) {
                inMap.get(key).setGender("Unknown");

            }

            if ("".equals(inMap.get(key).getMarried()) || inMap.get(key).getMarried() == null) {
                inMap.get(key).setMarried("Not Married or Unknown");

                for (String keyy : map.keySet()) {
                    if (inMap.get(key).getName().equals(inMap.get(keyy).getMarried())) {

                        inMap.get(key).setMarried(inMap.get(keyy).getName());

                    }
                }

            }

            if ("".equals(inMap.get(key).getStatus())) {

                inMap.get(key).setStatus("Alive");

            }
            if ("Unknown".equals(inMap.get(key).getStatus())) {

                inMap.get(key).setStatus("Dead");

            }

        }
    }
}
