package ie.cit.crowdfund.application.utils;

import java.text.DecimalFormat;


public class NewFormat {
        public static double roundNumber(double value){
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(value));
        }
}

