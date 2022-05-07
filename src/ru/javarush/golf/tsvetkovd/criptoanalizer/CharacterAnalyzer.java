package ru.javarush.golf.tsvetkovd.criptoanalizer;
import java.io.*;
public class CharacterAnalyzer {
    static boolean containsAlphabet(char c, char[] array) {
        for (char x : CryptoAnalyzerRunner.ALPHABET) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }
    public static void Encrypt(BufferedReader reader, BufferedWriter writer, int key) throws IOException {
        while (reader.ready()) {
            String line = reader.readLine().toLowerCase();
            for (char character : line.toCharArray()) {
                if (containsAlphabet(character, CryptoAnalyzerRunner.ALPHABET)) {
                    int origposition = CryptoAnalyzerRunner.ALPHABETLIST.indexOf(character);
                    int newposition = (origposition + key)% CryptoAnalyzerRunner.ALPHABET.length;
                    char newchar = CryptoAnalyzerRunner.ALPHABETLIST.get(newposition);
                    writer.write(newchar);
                } else {
                    writer.write(character);
                    continue;
                }
            }
            writer.write("\n");
        }
    }
    public static void Decrypt(BufferedReader reader, BufferedWriter writer, int key) throws IOException {
        while (reader.ready()) {
            String line = reader.readLine().toLowerCase();
            for (char character : line.toCharArray()) {
                if (containsAlphabet(character, CryptoAnalyzerRunner.ALPHABET)) {
                    int originalposition = CryptoAnalyzerRunner.ALPHABETLIST.indexOf(character);
                    int newposition = (originalposition - key)% CryptoAnalyzerRunner.ALPHABET.length;
                    if (newposition<0) {
                        newposition = CryptoAnalyzerRunner.ALPHABETLIST.size() + newposition;
                    }
                    char newchar = CryptoAnalyzerRunner.ALPHABETLIST.get(newposition);
                    writer.write(newchar);
                } else {
                    writer.write(character);
                    continue;
                }
            }
            writer.write("\n");
        }
    
    }
    }






