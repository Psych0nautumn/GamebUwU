import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Loader {
    public static void loadRom() {


        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream("C:/Users/Autumn/Documents/untitled/src/main/java/pokemon.gb");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            int length = inputStream.available();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (BufferedInputStream romStream = new BufferedInputStream(inputStream)) {
            int i;
            int count = 0;
            while ((i = romStream.read()) != -1) {
                System.out.printf("%02x ", i);
                System.out.println("hi");
                count++;

                if (count == 16) {
                    System.out.println();
                    count = 0;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
