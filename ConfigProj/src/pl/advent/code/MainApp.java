package pl.advent.code;
import java.util.logging.Logger;

public class MainApp {

    static Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        String folderLocation = "src\\pl\\advent\\code\\inputFiles";
        String inputFileDay1 = "\\day1.txt";
        String inputFileDay1test = "\\day1test.txt";

        Day1 day1test = new Day1(folderLocation + inputFileDay1test);
        day1test.convertInputStringIntoTwoLists();
        logger.info("Test total distance: " + day1test.calculateTotalDistance());
        logger.info("Test similarity score: " + day1test.calculateSimilarityScore());

        Day1 day1 = new Day1(folderLocation + inputFileDay1);
        day1.convertInputStringIntoTwoLists();
        logger.info("Total distance: " + day1.calculateTotalDistance());
        logger.info("Total distance: " + day1.calculateSimilarityScore());

    }


}
