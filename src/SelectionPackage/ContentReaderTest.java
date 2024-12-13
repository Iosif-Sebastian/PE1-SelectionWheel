package SelectionPackage;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class ContentReaderTest {
    public void testImportListOfItems(){
        List<String> list = ContentReader.importListOfItems();

        final int LIMIT = 100;
        assertTrue("The list size should be between 1 and " + LIMIT,
                list.size() >= 1 && list.size() <= LIMIT);
    }
}
