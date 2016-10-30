package com.example.purchase.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.purchase.exception.GenericPurchaseException;
import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;

//TODO Another team will implement the logic in this methods. 

@Repository
public class PurchaseDAOImpl implements IPurchaseDAO {

	@Override
	public boolean purchaseExists(Long id) throws GenericPurchaseException{
		
		return false;
	}

	@Override
	public List<Purchase> getAllPurchases() throws GenericPurchaseException{
		
		return null;
	}

	@Override
	public List<Detail> getDetailForValidPurchases(List<Long> purchasesIds) {
		
		return null;
	}

	@Override
	public Purchase savePurchase(Purchase purchase) throws GenericPurchaseException {
		
		return null;
	}



}
