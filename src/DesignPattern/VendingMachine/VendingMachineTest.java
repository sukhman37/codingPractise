package DesignPattern.VendingMachine;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



public class VendingMachineTest {
    private static VendingMachine vm;
   
    @BeforeClass
    public static void setUp(){
        vm = VendingMachineFactory.createVendingMachine();
    }
   
    @AfterClass
    public static void tearDown(){
        vm = null;
    }
   
    @Test
    public void testBuyItemWithExactPrice() {
    	System.out.println("testBuyItemWithExactPrice");
        //select item, price in cents
        long price = vm.selectItemAndGetPrice(Item.COKE); 
        //price should be Coke's price    
        assertEquals(Item.COKE.getPrice(), price);
        //25 cents paid              
        vm.insertCoin(Coin.QUARTER);                           
       
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst();
        List<Coin> change = bucket.getSecond();
        System.out.println("Item = "+item);
        //should be Coke
        assertEquals(Item.COKE, item);
        System.out.println("change = "+change);
        //there should not be any change                              
        assertTrue(change.isEmpty());                              
    }
   /*
    @Test
    public void testBuyItemWithMorePrice(){
    	System.out.println("testBuyItemWithMorePrice");
    	//vm = VendingMachineFactory.createVendingMachine();
    	
        long price = vm.selectItemAndGetPrice(Item.SODA);
        
        assertEquals(Item.SODA.getPrice(), price);
       
        vm.insertCoin(Coin.QUARTER);       
        vm.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
       
        Item item = bucket.getFirst();
        List<Coin> change = bucket.getSecond();
        //should be Coke
        assertEquals(Item.SODA, item);
        //there should not be any change                                     
        assertTrue(!change.isEmpty());        
        //comparing change                             
        assertEquals(50 - Item.SODA.getPrice(), getTotal(change));  
       
    }  */
  
   /*
    @Test
    public void testRefund(){
    	System.out.println("testRefund");
        long price = vm.selectItemAndGetPrice(Item.PEPSI);
        assertEquals(Item.PEPSI.getPrice(), price);       
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKLE);
        vm.insertCoin(Coin.PENNY);
        vm.insertCoin(Coin.QUARTER);
       
        assertEquals(41, getTotal(vm.refund()));       
    }
   
    @Test(expected=SoldOutException.class)
    public void testSoldOut(){
    	System.out.println("testSoldOut");
    	try{
        for (int i = 0; i < 5; i++) {
            vm.selectItemAndGetPrice(Item.COKE);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange();
        }
    	}catch(SoldOutException ex){
    		throw ex;
    	}
     
    }
   
    @Test(expected=NotSufficientChangeException.class)
    public void testNotSufficientChangeException(){
    	System.out.println("testNotSufficientChangeException");
    	try{
        for (int i = 0; i < 5; i++) {
            vm.selectItemAndGetPrice(Item.SODA);
            vm.insertCoin(Coin.QUARTER);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange().getSecond();
           
            vm.selectItemAndGetPrice(Item.PEPSI);
            vm.insertCoin(Coin.QUARTER);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange().getSecond();
        }
    	}catch(NotSufficientChangeException ex){
    		vm.refund();
    		throw ex;
    	}
    }
   
   
    @Test(expected=SoldOutException.class)
    public void testReset(){
    	System.out.println("testReset()");
        VendingMachine vmachine = VendingMachineFactory.createVendingMachine();
        vmachine.reset();
       
        vmachine.selectItemAndGetPrice(Item.COKE);
       
    }*/
   
    @Ignore
    public void testVendingMachineImpl(){
        VendingMachineImpl vm = new VendingMachineImpl();
    }
   
    private long getTotal(List<Coin> change){
        long total = 0;
        for(Coin c : change){
            total = total + c.getDenomination();
        }
        return total;
    }
}