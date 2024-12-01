package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem2 {

    public static void run() {
        try {
            File myObj = new File("./resources/Day1.txt");
            Scanner myReader = new Scanner(myObj);
            List<Integer> leftSide = new ArrayList<>();
            Map<Integer, Integer> rightSide = new HashMap<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitted = data.trim().split("   ");
                leftSide.add(Integer.parseInt(splitted[0]));
                int right = Integer.parseInt(splitted[1]);
                rightSide.put(right, rightSide.getOrDefault(right, 0) + 1);
            }

            leftSide.sort(Integer::compare);
            int similarityScore = 0;
            for (int x = 0; x < leftSide.size(); x++) {
                similarityScore += leftSide.get(x) * rightSide.getOrDefault(leftSide.get(x), 0);
            }
            System.out.println(similarityScore);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
