package com.example.purchase.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;

public interface IPurchaseService {
	
	public List<Purchase> getAllValidPurchases();
	
	public List<Detail> getDetailsForValidPurchases();
	
	public Purchase savePurchase(Purchase p);
	

}
