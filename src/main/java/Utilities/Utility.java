package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    
    public static String getDateTime(){
        return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
    }
    
}
