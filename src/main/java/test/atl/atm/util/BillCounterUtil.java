package test.atl.atm.util;

import java.util.HashMap;
import java.util.Map;

public class BillCounterUtil {
  public static Map<String,Integer> returnBills(Double withdraw) throws Exception {
    Map<String,Integer> billNums = new HashMap<>();
    Double billsCount;
    while (withdraw>0){
      if(Math.floorDiv(withdraw.intValue(),100)>0){
        billsCount = withdraw/100;
        billNums.put("$100",billsCount.intValue());
        withdraw-=100*billsCount.intValue();
      }else if(Math.floorDiv(withdraw.intValue(),50)>0){
        billsCount = withdraw/50;
        billNums.put("$50",billsCount.intValue());
        withdraw-=50*billsCount.intValue();
      }else if(Math.floorDiv(withdraw.intValue(),20)>0){
        billsCount = withdraw/20;
        billNums.put("$20",billsCount.intValue());
        withdraw-=20*billsCount.intValue();
     }else if(Math.floorDiv(withdraw.intValue(),10)>0){
        billsCount = withdraw/10;
        billNums.put("$10",billsCount.intValue());
        withdraw-=10*billsCount.intValue();
      }else if(Math.floorDiv(withdraw.intValue(),5)>0 && withdraw%5>=2){
        billsCount = withdraw/5;
        billNums.put("$5",billsCount.intValue());
        withdraw-=5*billsCount.intValue();
      }else if(Math.floorDiv(withdraw.intValue(),2)>0){
        billsCount = withdraw/2;
        billNums.put("$2",billsCount.intValue());
        withdraw-=2*billsCount.intValue();
      }else if(withdraw==1){
        throw new Exception("Available bills are 100, 50, 20, 10, 5, 2.");
      }
    }
    return billNums;
  }
}
