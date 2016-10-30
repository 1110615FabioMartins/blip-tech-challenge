package com.example.purchase.dao;

import java.util.List;

import com.example.purchase.exception.GenericPurchaseException;
import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;

/**
 * DAO Interface that provides access to an underlying database to
 * fetch/create/update date from purchases and their details.
 * 
 * @author fabio.martins
 * @since 30-10-2016
 * @version 0.0.1
 *
 */
public interface IPurchaseDAO {

	/**
	 * Method that verifies if a certain purchase exists in the Data Base.
	 * 
	 * @param Long
	 *            id purchase
	 * @return boolean true if the purchase exists and false if purchase doesn't
	 *         exist
	 * @throws GenericPurchaseException
	 */
	public boolean purchaseExists(Long id) throws GenericPurchaseException;

	/**
	 * Method that querys the data base and returns and returns all the
	 * Purchases available
	 * 
	 * @return List<{@link Purchase}>
	 * @throws GenericPurchaseException
	 */
	public List<Purchase> getAllPurchases() throws GenericPurchaseException;

	/**
	 * Method that creates/updates a single purchase in the dataBase
	 * 
	 * @param {@link
	 * 			Purchase} purchase;
	 * @return boolean true if the transaction finished successfully or false if
	 *         the transaction had a problem.
	 * @throws GenericPurchaseException
	 * 
	 */
	public Purchase savePurchase(Purchase purchase) throws GenericPurchaseException;


	/**
	 * Method that , given a List of purchase id's, retrieves a List of details
	 * from the data base.
	 * 
	 * @param {@link
	 * 			Purchase} purchase;
	 * @return boolean true if the transaction finished successfully or false if
	 *         the transaction had a problem.
	 * @throws GenericPurchaseException
	 * 
	 */
	public List<Detail> getDetailForValidPurchases(List<Long> purchasesIds) throws GenericPurchaseException;

}
