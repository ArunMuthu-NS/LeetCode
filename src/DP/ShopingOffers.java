package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ShopingOffers {
    static class Solution {
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int min = Integer.MAX_VALUE;
            int itemsSize = price.size();

            HashMap<String,Integer> map = new HashMap<String,Integer>();

            int sum = 0;
            for(int i = 0;i < itemsSize;i++)
                sum += (price.get(i) * needs.get(i));

            min = Math.min(sum, min);

            for(int i = 0;i < special.size();i++){
                List<Integer> offer = special.get(i);
                int offerTimes = 1;
                boolean isOfferApplicableAgain = true;
                do{
                    sum = 0;
                    boolean isOfferApplicable = true;
                    isOfferApplicableAgain = true;
                    StringBuffer s = new StringBuffer();
                    StringBuffer bal = new StringBuffer();
                    for(int j = 0;j < offer.size() - 1;j++){
                        if(offer.get(j) * offerTimes <= needs.get(j)){
                            sum += (needs.get(j) - (offer.get(j) * offerTimes)) * price.get(j);
                        }
                        else
                            isOfferApplicable = false;
                        isOfferApplicableAgain = isOfferApplicableAgain && (offer.get(j) * (offerTimes + 1) <= needs.get(j));
                        s.append((offer.get(j) * offerTimes) + ",");
                        bal.append((needs.get(j) - (offer.get(j) * offerTimes)) + ",");
                    }

                    if(isOfferApplicable){
                        map.put(s.toString(), (offer.get(itemsSize) * offerTimes));
                        sum += (offer.get(itemsSize) * offerTimes);
                        min = Math.min(sum, min);

                        if(map.get(bal.toString()) != null){
                            min = Math.min(map.get(bal.toString()) + (offer.get(itemsSize) * offerTimes), min);
                        }
                    }

                    offerTimes++;
                } while(isOfferApplicableAgain);
            }

            return min;
        }
    }

    public static void main(String args[]) {
        List<Integer> price = Arrays.asList(2,5);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(3,0,5));
        special.add(Arrays.asList(1,2,10));

        List<Integer> needs = Arrays.asList(3,2);


        List<Integer> price1 = Arrays.asList(9,9);
        List<List<Integer>> special1 = new ArrayList<>();
        special1.add(Arrays.asList(1,1,1));

        List<Integer> needs1 = Arrays.asList(6,6);

//        System.out.println(new Solution().shoppingOffers(price, special, needs));
        System.out.println(new Solution().shoppingOffers(price1, special1, needs1));
    }
}
