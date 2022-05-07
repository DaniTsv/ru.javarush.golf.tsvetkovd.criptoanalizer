package ru.javarush.golf.tsvetkovd.criptoanalizer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class BruteForce {
    public static List<Character> arrayList = new ArrayList<>();
    public static int key;
    static int counter;
    public static void bruteForce(BufferedReader Reader, BufferedWriter Writer) throws Exception {
        while (Reader.ready()) {
            String line = Reader.readLine().toLowerCase();
            if (line == null) {
                continue;
            }
            for (char character : line.toCharArray()) {
                arrayList.add(character);
            }
            arrayList.add('\n');
        }
        for (key = 1; key < CryptoAnalyzerRunner.ALPHABET.length; key++) {
            for (char character : arrayList) {
                if (CharacterAnalyzer.containsAlphabet(character, CryptoAnalyzerRunner.ALPHABET)) {
                    int originalposition = CryptoAnalyzerRunner.ALPHABETLIST.indexOf(character);
                    int newposition = (originalposition - key)% CryptoAnalyzerRunner.ALPHABET.length;
                    if (newposition<0) { newposition = CryptoAnalyzerRunner.ALPHABETLIST.size() + newposition; }
                    char newchar = CryptoAnalyzerRunner.ALPHABETLIST.get(newposition);
                    if (newchar == 'а' || newchar == 'о' || newchar == 'e') {
                        counter++;
                    }
                }
            }
            double structure = (double) counter / arrayList.size() * 100;
            if (structure >= 10 && structure <= 30) {
                System.out.println("Доля букв а,о,е в структуре текста = " + structure);
                System.out.println("Ключ расшифровки - " + key);
                for (char character : arrayList) {
                    if (CharacterAnalyzer.containsAlphabet(character, CryptoAnalyzerRunner.ALPHABET)) {
                        int origposition = CryptoAnalyzerRunner.ALPHABETLIST.indexOf(character);
                        int newposition = (origposition - key)% CryptoAnalyzerRunner.ALPHABET.length;
                        if (newposition < 0) {
                            newposition = CryptoAnalyzerRunner.ALPHABETLIST.size() + newposition;
                        }
                        char newchar = CryptoAnalyzerRunner.ALPHABETLIST.get(newposition);
                        Writer.write(newchar);
                    } else {
                        Writer.write(character);
                    }
                }
                Writer.write("\n");
                counter = 0;
            } else {
                counter =0;
                continue;
            }
        }
    }
}



