package mycom.currency.logic;

import java.util.HashMap;

public class Rates {
    HashMap<String,InfoRates> data;

    @Override
    public String toString() {
        return "Rates{" +
                "data=" + data +"\n"+
                "}";
    }

    public  class InfoRates{
        String code;
        String value;

        @Override
        public String toString() {
            return this.code+" : {" +
                    "\ncode: "+this.code+
                    "\nvalue: "+this.value+
                    "\n}";
        }
    }
}


