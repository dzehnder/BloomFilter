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

        Scanner scanner = new Scanner(System.in);

        //- Init FileReader
        File words = new File("words.txt");
        Scanner FileReader = new Scanner(words);

        BloomFilter bloomFilter = new BloomFilter(n, p);

        //- Add every second Word from File
        while(FileReader.hasNext())
        {
            if(selWordControl)
            {
                bloomFilter.add(FileReader.next());
            }

            selWordControl = (selWordControl==false) ? true : false;
        }

       //- Check every second Word from File
        while(FileReader.hasNext())
        {
            if(chckWordControl)
            {
                bloomFilter.hasWord(FileReader.next());
            }

            chckWordControl = (chckWordControl==false) ? true : false;
        }


        //- Close Open Scanner
        FileReader.close();

    }
}
