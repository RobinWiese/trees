package trees;

import trees.BinBaum;
import trees.Knoten;

import java.util.Scanner;


public class TierAkinator extends BinBaum{

    public String[] array = new String[500];

    Scanner tastatur = new Scanner(System.in);

    public int zusatzcounter = 0;

    public TierAkinator(){

        wurzel = new Knoten(0);
        array[0] = "ist es ein Vogel";
        wurzel.links = new Knoten(1);
        array[1] = "hat es beine?";
        wurzel.rechts = new Knoten(2);
        array[2] = "kann es fliegen?";
        wurzel.links.links = new Knoten(3);
        array[3] = "Schlange?";
        wurzel.links.rechts = new Knoten(4);
        array[4] = "ist es ein Säugetier?";
        wurzel.rechts.links = new Knoten(5);
        array[5] = "huhn?";
        wurzel.rechts.rechts = new Knoten(6);
        array[6] = "ist es ein Raubvogel?";

        wurzel.links.rechts.rechts = new Knoten(7);
        array[7] = "Hase";
        wurzel.links.rechts.rechts.links = new Knoten(8);
        array[8] = "Elefant";
        wurzel.rechts.rechts.rechts = new Knoten(9);
        array[9] = "Adler";
        wurzel.rechts.rechts.rechts.links = new Knoten(10);
        array[10] = "Bussard";

        starteAkinator();
    }

    public void starteAkinator(){
        System.out.println("Hallo! Willkommen bei meinem Tiere-Akinator!");
        System.out.println("antworten sie mit y/n");
        System.out.println("Die erste Frage: ");
        System.out.println(" ");

        Knoten i = wurzel;
        while(true){
            System.out.println(array[i.data]);
            String input = tastatur.next();

            if(input.equals("y") ){

                if(i.rechts == null){
                    System.out.println("War dass dein Tier? (y|n)");
                    String ende = tastatur.next();
                    if(ende.equals("y") ){
                        restart();
                    }else{

                    }
                }else{
                    i = i.rechts;
                }

            }else if(input.equals("n") ){

                if(i.links == null){
                    System.out.println("War dein Tier nicht dabei? (y|n)");
                    String neuesTier = tastatur.next();

                    if(neuesTier.equals("n") ){
                        zusatzcounter++;

                        System.out.println("Gebe den namen deines Tieres bitte ein;");
                        neuesTier = tastatur.next();
                        array[i.data + zusatzcounter] = neuesTier;
                        i.links = new Knoten(i.data + zusatzcounter);

                        restart();
                    }
                }else{
                    i = i .links;
                }

            }else{

            }
        }
    }

    public void restart(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Herzlichen Glückwunsch! Du hast gewonnen!");
        starteAkinator();
    }

    public static void main(String[] args) {
        new TierAkinator();
    }
}
