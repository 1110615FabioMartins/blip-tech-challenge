package com.example.purchase;

import static org.mockito.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;

import com.example.purchase.dao.PurchaseDAOImpl;
import com.example.purchase.exception.GenericPurchaseException;
import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;
import com.example.purchase.service.PurchaseServiceImpl;


public class PurchaseServiceTest {
	
	  	private PurchaseServiceImpl purchaseService;
	    private PurchaseDAOImpl purchaseDAO = Mockito.mock(PurchaseDAOImpl.class);
	    
	    @Autowired
	    private CounterService counterService;

	    @Before
	    public void setUp() {
	        purchaseService = new PurchaseServiceImpl(purchaseDAO, counterService);
	    }

	    @Test
	    public void testListAllValid() throws GenericPurchaseException{
	    	
	    	List<Purchase> purchases = new ArrayList<Purchase>();
	    	Detail detail1 = new Detail();
	    	detail1.setId(1L);
	    	detail1.setDescription("MotherBoard");
	    	detail1.setQuantity(1);
	    	detail1.setValue(20.0);
	    	Detail detail2 = new Detail();
	    	detail2.setId(2L);
	    	detail2.setDescription("CPU");
	    	detail2.setQuantity(2);
	    	detail2.setValue(40.0);
	        Purchase purchase1 = new Purchase();
	        purchase1.setId(1L);
	        purchase1.setProductType("Computer Components");
	        purchase1.setExpires(new DateTime("2016-11-24T21:20:47"));
	        purchase1.setDetail(detail2);
	        Purchase purchase2 = new Purchase();
	        purchase2.setId(2L);
	        purchase2.setProductType("Computer Components");
	        purchase2.setExpires(new DateTime("2015-09-24T21:20:45"));
	        purchase2.setDetail(detail2);
	        
	        purchases.add(purchase1);
	        purchases.add(purchase2);
	        
	        when(purchaseDAO.getAllPurchases()).thenReturn(purchases);

	        List<Purchase> purchasesResponse = (List<Purchase>) purchaseService.getAllValidPurchases();
	        
	        for(Purchase p : purchasesResponse){	
	        	assertFalse(p.getExpires().isBeforeNow()); 	
	        }
	        
	    }
	    
	    @Test
	    public void testGetDetailForAllValid() throws GenericPurchaseException{
	    	
	    	List<Purchase> purchases = new ArrayList<Purchase>();
	    	List<Detail> details = new ArrayList<Detail>();
	    	Detail detail1 = new Detail();
	    	detail1.setId(1L);
	    	detail1.setDescription("MotherBoard");
	    	detail1.setQuantity(1);
	    	detail1.setValue(20.0);
	    	Detail detail2 = new Detail();
	    	detail2.setId(2L);
	    	detail2.setDescription("CPU");
	    	detail2.setQuantity(2);
	    	detail2.setValue(40.0);
	        Purchase purchase1 = new Purchase();
	        purchase1.setId(1L);
	        purchase1.setProductType("Computer Components");
	        purchase1.setExpires(new DateTime("2016-11-24T21:20:47"));
	        purchase1.setDetail(detail2);
	        Purchase purchase2 = new Purchase();
	        purchase2.setId(2L);
	        purchase2.setProductType("Computer Components");
	        purchase2.setExpires(new DateTime("2015-09-24T21:20:45"));
	        purchase2.setDetail(detail2);
	        
	        purchases.add(purchase1);
	        purchases.add(purchase2);
	        
	        when(purchaseDAO.getAllPurchases()).thenReturn(purchases);

	        List<Purchase> purchasesResponse = (List<Purchase>) purchaseService.getAllValidPurchases();
	        List<Long> validPurchaseIds = new ArrayList<Long>();
	        
	        for(Purchase p : purchasesResponse){	
	        	validPurchaseIds.add(p.getId());
	        	details.add(p.getDetail());
	        }
	        
	        when(purchaseDAO.getDetailForValidPurchases(validPurchaseIds)).thenReturn(details);
	        
	        List<Detail> detailsResponse = purchaseService.getDetailsForValidPurchases();
	        
	        assertEquals(details, detailsResponse);
	        
	    }

	    @Test
	    public void testSavePurchase() throws GenericPurchaseException{
	    	
	    	Detail detail1 = new Detail();
	    	detail1.setId(1L);
	    	detail1.setDescription("MotherBoard");
	    	detail1.setQuantity(1);
	    	detail1.setValue(20.0);
	    	Purchase purchase1 = new Purchase();
	        purchase1.setId(1L);
	        purchase1.setProductType("Computer Components");
	        purchase1.setExpires(new DateTime("2016-11-24T21:20:47"));
	        purchase1.setDetail(detail1);
	        when(purchaseDAO.savePurchase((Purchase) any(Purchase.class))).thenReturn(purchase1);
	        
	        Purchase purchaseResponse = purchaseService.savePurchase(purchase1);
	        assertEquals(purchase1, purchaseResponse);
	    }
	    
	    


}
