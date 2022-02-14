package testing;


import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Map<String, Integer> unitsMapping = new HashMap<String, Integer>();

    public Calculator() {
        unitsMapping.put("mm", 0);
        unitsMapping.put("cm", 1);
        unitsMapping.put("dm", 2);
        unitsMapping.put("m", 3);
        unitsMapping.put("km", 6);
    }

    public Double convertUnit(double number, String fromUnit, String toUnit) {
        return number * Math.pow(10, (double) (unitsMapping.get(fromUnit) - unitsMapping.get(toUnit)));
    }


    public String calculate(String ex, String lowest) {
        Double tmp = 0.0;

        //we check if the expression contains only valid operands
        if ((ex.contains("+") || ex.contains("-")) && !(ex.contains("*") || ex.contains("/") || ex.contains("%"))) {
            //split the input expression into an array of sub-strings by using space " " as a delimeter
            //exemple: string "18 cm + 5 mm" will result into an array of substrings {"18", "cm", "+", "5", "mm"}
            String[] s = ex.split(" ");

            //find next operand and keep the result of its operators in "tmp" = temporary result
            //tmp will be the left operator in the operation;
            //we initialize tmp with the first from the string
            tmp = convertUnit(Double.parseDouble(s[0]), s[1], lowest);
            for (int i = 2; i < s.length; i++) {
                if (s[i].equals("+")) {
                    tmp += convertUnit(Double.parseDouble(s[i + 1]), s[i + 2], lowest);
                } else if (s[i].equals("-")) {
                    tmp -= convertUnit(Double.parseDouble(s[i + 1]), s[i + 2], lowest);
                }
            }
            return (String.valueOf(tmp) + " " + lowest);
        } else
            return "Given expression contains invalid operands.";
    }
}