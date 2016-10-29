package com.example.purchase.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;

@Repository
public class PurchaseDAOImpl implements IPurchaseDAO {

	@Override
	public boolean purchaseExists(Long id) {
		
		return false;
	}

	@Override
	public List<Purchase> getAllPurchases() {
		
		return null;
	}

	@Override
	public Purchase updatePurchase(Purchase purchase) {
		
		return null;
	}

	@Override
	public Purchase createPurchase(Purchase purchase) {
		
		return null;
	}

	@Override
	public List<Detail> getDetailForValidPurchases(List<Long> purchasesIds) {
		
		return null;
	}



}
