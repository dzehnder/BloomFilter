package ch.fhnw.dist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws FileNotFoundException {

        //- Selection from File enable/disable
        boolean selWordControl = true;
        //- Check from file enable/disable
        boolean chckWordControl = false;
        //- --> if both have them same value: read the same Words
        int i = 0;
        int j = 0;

        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter the amount of expected elements: ");
        int n = scanner.nextInt();

        System.out.println("Please enter the desired false positive percentage: ");
        double p = scanner.nextDouble();

        //- Init FileReader
        File words = new File("words.txt");
        Scanner FileReader = new Scanner(words);

        // create the filter and divide n by 2, as only every second element is used
        BloomFilter bloomFilter = new BloomFilter(n/2, p);

        double addedWords = 0;
        //- Add every second Word from File
        while(FileReader.hasNext() & i != n)
        {
            if(selWordControl)
            {
                bloomFilter.add(FileReader.next());
                addedWords++;
            }

            selWordControl = !selWordControl;
            i++;
        }

        double containedWords = 0;
       //- Check every second Word from File
        while(FileReader.hasNext() & j != n)
        {
            if(chckWordControl)
            {
                if (bloomFilter.hasWord(FileReader.next())) {
                    containedWords++;
                }

            }

            chckWordControl = !chckWordControl;
            j++;
        }


        //- Close Open Scanner
        FileReader.close();

        System.out.println("Added words: " + addedWords);
        System.out.println("False positives: " + containedWords);
        System.out.println("True percentage: " + (containedWords/addedWords));

    }
}
