package com.example.purchase.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;
import com.example.purchase.service.IPurchaseService;
import com.example.purchase.service.PurchaseServiceImpl;

@RestController
public class PurchaseController {

	@Autowired
	IPurchaseService purchaseService;

	public PurchaseController(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@RequestMapping("/getDetailsForValidPurchases")
	public ResponseEntity<List<Detail>> getDetailsForValidPurchases() {
		
		List<Detail> detailList = purchaseService.getDetailsForValidPurchases();

		if (detailList != null && !detailList.isEmpty()) {
			return new ResponseEntity<List<Detail>>(purchaseService.getDetailsForValidPurchases(), HttpStatus.OK);
		}
		return new ResponseEntity<List<Detail>>(new ArrayList<Detail>(), HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public ResponseEntity<Purchase> createNewPurchase( @RequestBody Purchase purchase) {

		Purchase p = purchaseService.savePurchase(purchase);

		if (p == null) {

			return new ResponseEntity<Purchase>(purchaseService.savePurchase(purchase), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Purchase>(purchaseService.savePurchase(purchase), HttpStatus.OK);

	}

	@RequestMapping(value = "/purchase/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Purchase> updatePurschase(@PathVariable Long id, @RequestBody Purchase purchase) {

		Purchase p = purchaseService.savePurchase(purchase);

		if (p == null) {
			return new ResponseEntity<Purchase>(purchaseService.savePurchase(purchase), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Purchase>(purchaseService.savePurchase(purchase), HttpStatus.OK);

	}

}
