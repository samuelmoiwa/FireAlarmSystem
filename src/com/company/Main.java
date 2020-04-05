package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Area>> kthria = new ArrayList<ArrayList<Area>>();
        int arithmos = 0;
        int metrhths = 0;

        Scanner eLengths = new Scanner(System.in);

        System.out.print("1)Create a new building. \n2)Create a new building area. \n3)Renew the measurements.\n4)Conflagration check.\n5)Exit menu.\nPlease choose one of the above: ");
        while (arithmos != 5) {
            arithmos = eLengths.nextInt();

            if (arithmos == 1) {
                kthria.add(new ArrayList<Area>());
                System.out.print("1)Create a new building. \n2)Create a new building area. \n3)Renew the measurements.\n4)Conflagration check.\n5)Exit menu.\nPlease choose one of the above: ");

            } else if (arithmos == 2) {
                System.out.println("Please enter the number of the building you want to create an area to: ");
                int arithmos2 = eLengths.nextInt();
                kthria.get(arithmos2 - 1).add(new Area());
                kthria.get(arithmos2 - 1).get(kthria.get(arithmos2 - 1).size() - 1).setAreaCode(metrhths + 1);
                kthria.get(arithmos2 - 1).get(kthria.get(arithmos2 - 1).size() - 1).getTempSensor().setTempCode(metrhths + 1);
                kthria.get(arithmos2 - 1).get(kthria.get(arithmos2 - 1).size() - 1).getBrightSensor().setBrightCode(metrhths + 1);
                metrhths += 1;
                System.out.print("\n\n1)Create a new building. \n2)Create a new building area. \n3)Renew the measurements.\n4)Conflagration check.\n5)Exit menu.\nPlease choose one of the above: ");

            } else if (arithmos == 3) {
                if (kthria.size() == 0 || kthria.get(0).size() == 0) {


                    System.out.println("\nYou can't renew measurements if you don't create areas or buildings first.");
                    System.out.print("\n1)Create a new building. \n2)Create a new building area. \n3)Renew the measurements.\n4)Conflagration check.\n5)Exit menu.\nPlease choose one of the above: ");

                } else {


                    ArrayList<Area> topothesies = new ArrayList<Area>();

                    for (int i = 0; i < kthria.size(); i++) {
                        for (int z = 0; z < kthria.get(i).size(); z++) {
                            topothesies.add(kthria.get(i).get(z));
                        }
                    }

                    Collections.sort(topothesies);
                    PrintWriter eksodos = null;
                    try
                    {
                        eksodos = new PrintWriter(new FileOutputStream("measures.txt"));
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println("Error opening the file measures.txt.");
                        System.exit(0);
                    }

                    for (int i = 0; i < topothesies.size(); i++){
                        eksodos.println(topothesies.get(i).toString());
                    }
                    eksodos.println(kthria.get(0).get(0).toString());
                    eksodos.close();

                    for (int counter = 0; counter < kthria.size(); counter++) {
                        for (int tempor = 0; tempor < kthria.get(counter).size(); tempor++)
                            kthria.get(counter).get(tempor).renewMeasures();

                    }
                    System.out.println("\nMeasurements successfully renewed!");
                    System.out.print("\n\n1)Create a new building. \n2)Create a new building area. \n3)Renew the measurements.\n4)Conflagration check.\n5)Exit menu.\nPlease choose one of the above: ");
                }


            } else if (arithmos == 4) {
                if (kthria.size() == 0 || kthria.get(0).size() == 0) {
                    System.out.println("\nYou can't check for fire if you don't create areas or buildings first.");
                    System.out.print("\n1)Create a new building. \n2)Create a new building area. \n3)Renew the measurements.\n4)Conflagration check.\n5)Exit menu.\nPlease choose one of the above: ");
                } else {
                    System.out.println("Please enter the Area code you want to check for fire: ");
                    int temp = eLengths.nextInt();
                    Area possibleArea = new Area();
                    for (int i = 0; i < kthria.size(); i++) {
                        for (int z = 0; z < kthria.get(i).size(); z++) {
                            if (kthria.get(i).get(z).getAreaCode() == temp) {
                                possibleArea = kthria.get(i).get(z);
                                break;
                            } else
                                continue;
                        }
                    }
                    if (possibleArea.getTempSensor().getTemp() > 50 && possibleArea.getBrightSensor().getBright() > 140 && possibleArea.getTotalReliability() > 0.9 || possibleArea.getArithmospyrkagias() > 0) {
                        possibleArea.setArithmospyrkagias(possibleArea.getArithmospyrkagias() + 1);
                        System.out.println("\n " + possibleArea.toString());
                        System.out.println("There is a fire spreading through the building. Evacuate immediately or else I have bad news for you.");
                    } else {
                        System.out.println("There's nothing to worry about, you're safe.");
                        System.out.print("\n1)Create a new building. \n2)Create a new building area. \n3)Renew the measurements.\n4)Conflagration check.\n5)Exit menu.\nPlease choose one of the above: ");
                    }
                }
            }

        }
    }
}