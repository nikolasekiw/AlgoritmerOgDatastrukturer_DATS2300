package Oblig.Oblig3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        ObligSBinTre<String> tre = new ObligSBinTre<>(Comparator.naturalOrder());
        System.out.println(tre.antall());  // Utskrift: 0

        ObligSBinTre<Integer> tre2 = new ObligSBinTre<>(Comparator.naturalOrder());
        System.out.println(tre2.antall());  // Utskrift: 0

        ObligSBinTre<Character> tre3 = new ObligSBinTre<>(Comparator.naturalOrder());
        System.out.println(tre3.antall());  // Utskrift: 0
    }
}
