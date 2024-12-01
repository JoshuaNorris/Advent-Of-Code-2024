package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    public static void run() {
        try {
            File myObj = new File("./resources/Day1.txt");
            Scanner myReader = new Scanner(myObj);
            List<Integer> leftSide = new ArrayList<>();
            List<Integer> rightSide = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitted = data.trim().split("   ");
                leftSide.add(Integer.parseInt(splitted[0]));
                rightSide.add(Integer.parseInt(splitted[1]));
            }

            leftSide.sort(Integer::compare);
            rightSide.sort(Integer::compare);
            int total = 0;
            for (int x = 0; x < leftSide.size(); x++) {
                total += Math.abs(leftSide.get(x) - rightSide.get(x));
            }
            System.out.println(total);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
