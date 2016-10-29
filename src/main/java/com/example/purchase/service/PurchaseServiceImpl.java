package com.example.purchase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.purchase.dao.IPurchaseDAO;
import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

	private IPurchaseDAO purchaseDAO;
	private final CounterService counterService;
	private final static Long DB_SLA_LIMIT_IN_MILLI = 2000L;

	@Autowired
	public PurchaseServiceImpl(IPurchaseDAO purchaseDAO, CounterService counterService) {

		this.purchaseDAO = purchaseDAO;
		this.counterService = counterService;

	}

	@Override
	public List<Purchase> getAllValidPurchases() {

		// This logic of selecting the valid Purchases could be achieved by
		// adding some SQL in the DAOImpl and probably would be more clean and
		// faster. But for the exercise purpose i implemented
		// this in java.
		
		long startTime = System.currentTimeMillis();
		List<Purchase> allPurchases = this.purchaseDAO.getAllPurchases();
		long endTime = System.currentTimeMillis();
		verifySLA(startTime, endTime);

		List<Purchase> validPurchases = new ArrayList<Purchase>();

		for (Purchase p : allPurchases) {

			if (!p.getExpires().isBeforeNow()) {

				validPurchases.add(p);
			}

		}

		return validPurchases;
	}

	@Override
	public List<Detail> getDetailsForValidPurchases() {

		List<Detail> detailList = new ArrayList<Detail>();
		List<Long> validPurchadeIdsList = new ArrayList<Long>();

		for (Purchase p : getAllValidPurchases()) {

			validPurchadeIdsList.add(p.getId());
		}

		long startTime = System.currentTimeMillis();
		detailList = purchaseDAO.getDetailForValidPurchases(validPurchadeIdsList);
		long endTime = System.currentTimeMillis();
		verifySLA(startTime, endTime);

		return detailList;

	};

	@Override
	public Purchase savePurchase(Purchase p) {
		Purchase pResponde = null;
		long startTime = System.currentTimeMillis();
		pResponde = purchaseDAO.createPurchase(p);
		long endTime = System.currentTimeMillis();
		verifySLA(startTime, endTime);
		return pResponde;
	}


	/**
	 * Method that calculates the elapsed time between to longs (time in
	 * milliseconds) verifies if the has exceed de SLA expected. If the elapsed
	 * time is superior to the limit the metric counter.sla.db.exceded will be
	 * incremented.
	 * 
	 * @param long start
	 * @param long end
	 */
	private void verifySLA(long start, long end) {
		long elapsed = end - start;
		if (elapsed > DB_SLA_LIMIT_IN_MILLI) {
			counterService.increment("counter.sla.db.exceded");
		}
	}

}
