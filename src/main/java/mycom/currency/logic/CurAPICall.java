package mycom.currency.logic;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.text.DecimalFormat;

public final class CurAPICall {

        private static CurAPICall instance;
        private Float dolarRate;
        private Float euroRate;
        private Float poundRate;
        private Float yenRate;
        private Float koreanWonRate;

        public Float getDolarRate() {
                return dolarRate;
        }

        public Float getYenRate() {
                return yenRate;
        }

        public Float getEuroRate() {
                return euroRate;
        }

        public Float getPoundRate() {
                return poundRate;
        }

        public Float getKoreanWonRate() {
                return koreanWonRate;
        }

        public void setRates(){
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme("https")
                        .host("api.currencyapi.com")
                        .addPathSegment("v3")
                        .addPathSegment("latest")
                        .addQueryParameter("apikey","cur_live_skzpOTimDeosr1RlFsb1nXrus9el6qF8zBCwLoaH")
                        .addQueryParameter("base_currency","COP")
                        .build();
                System.out.println(httpUrl);
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(httpUrl).build();

                Response response = null;
                String jsonData = "";

                try {
                        response = client.newCall(request).execute();
                }catch (Exception e){
                        System.out.println("Error al llamar la API:  "+e);
                }

                System.out.println("El codigo es: "+response.code());

                try {
                        jsonData = response.body().string();
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

                Gson gson = new Gson();

                Rates rates =  gson.fromJson(jsonData, Rates.class);
                /*
                * "USD"
                * "EUR"
                * "GBP"
                * "JPY"
                * "KRW"
                * */
                this.dolarRate = Float.parseFloat(rates.data.get("USD").value);
                this.euroRate = Float.parseFloat(rates.data.get("EUR").value);
                this.poundRate = Float.parseFloat(rates.data.get("GBP").value);
                this.yenRate =  Float.parseFloat(rates.data.get("JPY").value);
                this.koreanWonRate = Float.parseFloat(rates.data.get("KRW").value);

        }
        private CurAPICall() {
        }

        public static CurAPICall getInstance() {
                if (instance == null) {
                        instance = new CurAPICall();
                }
                return instance;
        }

        //DecimalFormat df = new DecimalFormat("#.#####");
        //df.setRoundingMode(RoundingMode.FLOOR);

}
