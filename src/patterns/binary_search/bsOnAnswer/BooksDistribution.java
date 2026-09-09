//https://www.scaler.com/academy/mentee-dashboard/class/523678/homework/problems/270/submissions
package patterns.binary_search.bsOnAnswer;

import java.util.ArrayList;
import java.util.Arrays;

public class BooksDistribution {

    public int books(ArrayList<Integer> bookPages, int students) {
        if (students > bookPages.size())
            return -1;
        int max = 0;
        int min = 0;

        for (Integer pages : bookPages) {
            max += pages;
            min = Math.max(min, pages);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;

            int distrubuted = 0;
            int sum = 0;
            for (int index = 0; index < bookPages.size(); index++) {
                int pages = bookPages.get(index);
                if (sum + pages > mid) {
                    distrubuted++;
                    sum = pages;
                } else {
                    sum += pages;
                }
            }
            distrubuted++;

            if (distrubuted <= students) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new BooksDistribution().books(new ArrayList<>(Arrays.asList(3, 4, 5, 6)),2));
        System.out.println(new BooksDistribution().books(new ArrayList<>(Arrays.asList(12, 34, 67, 90)),2));
//        113
    }
}

// A = [12, 34, 67, 90]
// B = 2

