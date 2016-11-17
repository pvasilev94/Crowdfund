package ie.cit.crowdfund.application.utils;

import java.text.DecimalFormat;

/**
 * Created by Pavel on 17/11/2016.
 */
public class NewFormat {
        public static double roundNumber(double value){
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(value));
        }
}

