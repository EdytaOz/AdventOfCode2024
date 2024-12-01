package pl.advent.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

public class Day1 {

    private List<Integer> leftList = new ArrayList<>();
    private List<Integer> rightList = new ArrayList<>();
    private String puzzleInputPath;
    private int lines = 0;

    Day1(String inputFilePath) {
        this.puzzleInputPath = inputFilePath;
    }

    private String readFileContent(String inputFile) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String content;
            while ((content = br.readLine()) != null) {
                sb.append(content).append("\n");
                lines++;
            }
        } catch (IOException e) {
            System.out.println("Invalid file");
        }
        return sb.toString();
    }

    public void convertInputStringIntoTwoLists() {
        String locations = readFileContent(puzzleInputPath);
        String[] contentTable = locations.split("   |\\n");
        for (int i = 0; i < contentTable.length; i++) {
            if ((i % 2) == 0)
                leftList.add(Integer.parseInt(contentTable[i]));
            else rightList.add(Integer.parseInt(contentTable[i]));
        }
    }

    public Integer calculateTotalDistance() {
        Collections.sort(leftList);
        Collections.sort(rightList);
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < leftList.size(); i++)
            distances.add(abs(leftList.get(i) - rightList.get(i)));
        return distances.stream().mapToInt(Integer::intValue).sum();
    }

    public Integer calculateSimilarityScore() {
        List<Integer> similarityScore = new ArrayList<>();
        for(Integer num : leftList) {
            int occurrences = Collections.frequency(rightList, num);
            similarityScore.add(num * occurrences);
        }
        return similarityScore.stream().mapToInt(Integer::intValue).sum();
    }
}
