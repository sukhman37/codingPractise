package testing;

import java.math.BigDecimal;

public class NewDateTest {
    public static void main(String[] args) {
        BigDecimal fromTxnAmount= new BigDecimal("10");
        BigDecimal txnAmount=new BigDecimal("11");
        System.out.println(fromTxnAmount.compareTo(txnAmount));
    }
}
