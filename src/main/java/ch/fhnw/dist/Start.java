package ch.fhnw.dist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws FileNotFoundException {

        File words = new File("words.txt");

        Scanner FileReader = new Scanner(words);

        //- Test erste 10 Wörter
        for(int i = 0; i < 10; i++)
        {
            System.out.println(FileReader.next());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the desired false positive percentage: ");
        double p = scanner.nextDouble();

        System.out.println("Please enter the amount of expected elements: ");
        int n = scanner.nextInt();

        BloomFilter bloomFilter = new BloomFilter(n, p);
    }
}
