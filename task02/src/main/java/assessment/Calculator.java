package assessment;

import java.util.List;

public class Calculator {

    public Float calculate(List<Integer> list) {
        System.out.println(list);
        int denominator = list.size();
        float numerator = 0;
        for (Integer integer : list) {
            numerator += integer;
        }
        Float average = numerator / denominator;
        return average;
    }
}
