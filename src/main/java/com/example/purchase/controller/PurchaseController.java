package com.example.purchase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.purchase.exception.GenericPurchaseException;
import com.example.purchase.exception.InvalidParametersException;
import com.example.purchase.exception.NotFoundException;
import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;
import com.example.purchase.service.IPurchaseService;

/**
 * This class it's a Spring Rest Controller that maps a Http Request to a
 * specific method.
 * This specific Rest Controller handles the requests to create/update purchases and also obtain information about purchase and their detail. 
 * For more information about Sprin Rest Controller's please consult the official information
 * {@link http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html}
 * 
 * @author fabio.martins
 * @version 0.0.1
 * @since 29/10/2016
 *
 */

@RestController
public class PurchaseController {
	
	/**The service that connects to the data base**/
	@Autowired
	IPurchaseService purchaseService;

	public PurchaseController(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	/**Return a list of Detail for all the valid purchases stored in the data base **/
	@RequestMapping("/getDetailsForValidPurchases")
	public ResponseEntity<List<Detail>> getDetailsForValidPurchases()
			throws NotFoundException, GenericPurchaseException {

		List<Detail> detailList = purchaseService.getDetailsForValidPurchases();

		if (detailList != null && !detailList.isEmpty()) {
			return new ResponseEntity<List<Detail>>(purchaseService.getDetailsForValidPurchases(), HttpStatus.OK);
		} else {
			throw new NotFoundException(HttpStatus.NO_CONTENT.value(), "There are no results for this request");
		}
	}
	
	/**Creates a new purchase**/
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public ResponseEntity<Purchase> createNewPurchase(@RequestBody Purchase purchase) throws GenericPurchaseException {
		return new ResponseEntity<Purchase>(purchaseService.savePurchase(purchase), HttpStatus.OK);
	}
	
	/**Update a purchase. The id of the purchase is passe in the url **/
	@RequestMapping(value = "/purchase/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Purchase> updatePurschase(@PathVariable Long id, @RequestBody Purchase purchase)
			throws GenericPurchaseException {
		if (id <= 0 || id == null) {
			throw new InvalidParametersException(HttpStatus.BAD_REQUEST.value(),
					"Please check the Url path variable id");
		} else {

			purchase.setId(id);
			return new ResponseEntity<Purchase>(purchaseService.savePurchase(purchase), HttpStatus.OK);
		}

	}

}
