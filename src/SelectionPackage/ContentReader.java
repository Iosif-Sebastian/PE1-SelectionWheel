package SelectionPackage;

import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;

public class ContentReader extends MainWheel {
    public static ArrayList<String> importListOfItems() {
        ArrayList<String> listOfItems = new ArrayList<>();
        try {
            listOfItems = new ArrayList<>(Files.readAllLines(Paths.get("itemlist.txt")));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return listOfItems;
    }
}
