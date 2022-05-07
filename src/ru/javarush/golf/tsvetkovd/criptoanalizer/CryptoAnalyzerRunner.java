package ru.javarush.golf.tsvetkovd.criptoanalizer;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class CryptoAnalyzerRunner {
    public static final char[] ALPHABET = {'а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' '};
    public static final List<Character> ALPHABETLIST = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    static Scanner scanner = new Scanner(System.in);
    public static File file = new File("Example.txt");
    private static int key;
    static String filepath;

    public static void main(String[] args) throws Exception {
        System.out.println("Добро пожаловать в криптоанализатор. Выберете неоходимое меню");

            System.out.println("1. Зашифровать данные.");
            System.out.println("2. Дешифровать данные используя ключ");
            System.out.println("3. Дешифровать данные с помощью \"brute force \"");
            System.out.println("4. Выход");
            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Введите адрес файла");
                    scanner.nextLine();
                    filepath = scanner.nextLine();
                    System.out.println("Введите ключ шифра для шифрования текста");
                    key = scanner.nextInt();
                    try (BufferedReader reader = new BufferedReader(new FileReader(filepath));
                         BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        CharacterAnalyzer.Encrypt(reader, writer, key);
                    }
                    break;
                case 2:
                    System.out.println("Введите адрес файла");
                    scanner.nextLine();
                    filepath = scanner.nextLine();
                    System.out.println("Введите ключ шифра для расшифровки текста");
                    key = scanner.nextInt();
                    try (BufferedReader reader = new BufferedReader(new FileReader(filepath));
                         BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        CharacterAnalyzer.Decrypt(reader, writer, key);
                    }
                    break;

                case 3:
                    System.out.println("Введите адрес файла");
                    scanner.nextLine();
                    filepath = scanner.nextLine();
                    try (BufferedReader reader = new BufferedReader(new FileReader(filepath));
                         BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        BruteForce.bruteForce(reader, writer);
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }



