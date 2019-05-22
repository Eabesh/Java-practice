package PracticeExample;

public class ArrayExamples {


    public class Stock{
        int buy;
        int sell;
        int profit;
        public int getBuy() {
            return buy;
        }

        public void setBuy(int buy) {
            this.buy = buy;
        }

        public int getSell() {
            return sell;
        }

        public void setSell(int sell) {
            this.sell = sell;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

    }

    public static void main(String[] args){

        boolean ll = true;
        String k = "koaml";
        System.out.println("value before "+ll +" and name "+k);

        changeValue(ll,k);
        System.out.println("value  "+ll +" and name "+k);

    }

    public static void changeValue(boolean xvy,String k){
        xvy = false;
        k ="neha";
    }

}
