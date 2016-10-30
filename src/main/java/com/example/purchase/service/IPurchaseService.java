package com.example.purchase.service;

import java.util.List;

import com.example.purchase.exception.GenericPurchaseException;
import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;

/**
 * Service Interface that makes the bridge between the controller and the DAO.
 * 
 * @author fabio.martins
 * @since 29-10-2016
 * @version 0.0.1
 */
public interface IPurchaseService {

	/**
	 * Method that fetches all the purchases from the data base and filters that
	 * list to retrieve only the purchases that haven't expired.
	 * 
	 * @return List<Purchase>
	 * @throws GenericPurchaseException
	 */
	public List<Purchase> getAllValidPurchases() throws GenericPurchaseException;

	/**
	 * Method that gets a list of all valid purchases (getAllValidPurchases())
	 * and stores their ID's to a List of Long's. Then fetches all the detail's
	 * for that list of ID's and retrieves it.
	 * 
	 * @return List<Detail>
	 * @throws GenericPurchaseException
	 */
	public List<Detail> getDetailsForValidPurchases() throws GenericPurchaseException;
	
	/**
	 * Creates or updates a Purchase and retrieves that Purchase created/updated.
	 * 
	 * @param Purchase p
	 * @return Purchase
	 * @throws GenericPurchaseException
	 */
	public Purchase savePurchase(Purchase p) throws GenericPurchaseException;

}
