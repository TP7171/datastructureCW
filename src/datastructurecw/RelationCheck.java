/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurecw;

import java.util.HashMap;

/**
 *
 * @author thiag
 */
public class RelationCheck {

    public static String compare(String a, String b, HashMap<String, person> inMap) {
        String relation = check(a, b, inMap);

        return relation;

    }

    private static String check(String a, String b, HashMap<String, person> inMap) {
        String relation;
        if (checkParent(a, b, inMap)) {
            if (inMap.get(a).getGender().equals("man")) {
                return "father";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "mother";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "parent";
            } else {
                return "not related";
            }

        } else if (checkDescendant(a, b, inMap)) {
            if (inMap.get(a).getGender().equals("man")) {
                return "son";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "daugther";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "descendant";
            } else {
                return "not related";
            }

        } else if (checkSibling(a, b, inMap)) {

            if (inMap.get(a).getGender().equals("man")) {
                return "brother";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "sister";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "sibling";
            } else {
                return "not related";
            }

        } else if (checkPartner(a, b, inMap)) {

            if (inMap.get(a).getGender().equals("man")) {
                return "husband";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "wife";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "partner";
            } else {
                return "not related";
            }
            //
        } else if (checkGrandParent(a, b, inMap)) {
            if (inMap.get(a).getGender().equals("man")) {
                return "grandfather";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "grandmother";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "grandparent";
            } else {
                return "not related";
            }

        } else if (checkGrandDescendant(a, b, inMap)) {
            if (inMap.get(a).getGender().equals("man")) {
                return "grandson";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "granddaugther";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "granddescendat";
            } else {
                return "not related";
            }

        } else if ((checkUncle(a, b, inMap) || (checkPartnerUncle(a, b, inMap)))) {
            if (inMap.get(a).getGender().equals("man")) {
                return "Uncle";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "Aunt";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "Uncle or Aunt";
            } else {
                return "not related";
            }

        } else if (checkNephew(a, b, inMap)) {
            if (inMap.get(a).getGender().equals("man")) {
                return "Nephew";
            }
            if (inMap.get(a).getGender().equals("woman")) {
                return "Niece";
            }
            if (inMap.get(a).getGender().equals("Unknown")) {
                return "Nepher or Niece";
            } else {
                return "not related";
            }

        } else if (checkCousin(a, b, inMap)) {

            return "Cousin";
        } else {
            return "not related";
        }

    }

    private static boolean checkParent(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {

            if (!"Unknown".equals(inMap.get(a).getName())) {

                if (!"Unknown".equals(inMap.get(b).getMother())) {

                    if (!"Unknown".equals(inMap.get(b).getFather())) {
                        if (inMap.get(a).getName().equals(inMap.get(b).getMother())) {
                            return true;
                        } else if (inMap.get(a).getName().equals(inMap.get(b).getFather())) {
                            return true;
                        }

                    }

                }

            }

        }
        return false;
    }

    private static boolean checkDescendant(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {
            if (inMap.get(a).getMother().equals(inMap.get(b).getName())) {
                return true;
            } else if (inMap.get(a).getFather().equals(inMap.get(b).getName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSibling(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {

            if (!"Unknown".equals(inMap.get(a).getMother())) {
                if (!"Unknown".equals(inMap.get(b).getMother())) {
                    if (inMap.get(a).getMother().equals(inMap.get(b).getMother())) {
                        return true;
                    }

                }

            } else if ((!"Unknown".equals(inMap.get(a).getFather()))) {
                if (!"Unknown".equals(inMap.get(b).getFather())) {
                    if (inMap.get(a).getFather().equals(inMap.get(b).getFather())) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private static boolean checkCousin(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {

            if (!"Unkown".equals(inMap.get(b).getMother())) {
                if (checkNephew(a, inMap.get(b).getMother(), inMap)) {
                    return true;
                }
            }

            if (!"Unknown".equals(inMap.get(b).getFather())) {
                if (checkNephew(a, inMap.get(b).getFather(), inMap)) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean checkGrandParent(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {

            if (!"Unknown".equals(inMap.get(b).getMother())) {
                if (checkDescendant(inMap.get(b).getMother(), a, inMap)) {
                    return true;
                } else if (checkDescendant(inMap.get(b).getFather(), a, inMap)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkGrandDescendant(String a, String b, HashMap<String, person> inMap) {

        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {

            if (checkGrandParent(b, a, inMap)) {
                return true;
            }

        }

        return false;
    }

    private static boolean checkPartner(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {
            if (inMap.get(a).getMarried().equals(inMap.get(b).getName())) {
                return true;
            } else if (inMap.get(b).getMarried().equals(inMap.get(b).getName())) {
                return true;
            } else if ("Not Married or Unknown".equals(inMap.get(a).getMarried())) {
                return false;
            } else if ("Not Married or Unknown".equals(inMap.get(b).getMarried())) {
                return false;
            }
        }

        return false;
    }

    private static boolean checkUncle(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {

            if ((!"Unknown".equals(inMap.get(b).getMother())) && ((!"Unknown".equals(b))) && (!"Unknown".equals(inMap.get(b).getFather()))) {

                if (!"Unknown".equals(inMap.get(b).getMother())) {
                    if (checkSibling(inMap.get(b).getMother(), a, inMap)) {
                        return true;
                    }

                } else if (!"Unknown".equals(inMap.get(b).getFather())) {
                    if (checkSibling(inMap.get(b).getFather(), a, inMap)) {

                        return true;

                    }

                }
            }
        }

        return false;
    }

    private static boolean checkPartnerUncle(String a, String b, HashMap<String, person> inMap) {
        if (!"Not Married or Unknown".equals(inMap.get(a).getMarried())) {

            if (checkUncle(inMap.get(a).getMarried(), b, inMap)) {

                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean checkNephew(String a, String b, HashMap<String, person> inMap) {
        if ((!"Unknown".equals(a)) && (!"Unknown".equals(b))) {

            if (checkUncle(b, a, inMap)) {
                return true;
            } else if (!"Unknown".equals(inMap.get(b).getMarried())) {
                if (checkUncle(inMap.get(b).getMarried(), a, inMap)) {

                    return true;
                }
            }

        }

        return false;
    }
}
