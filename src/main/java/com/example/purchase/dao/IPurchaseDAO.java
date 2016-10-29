package com.example.purchase.dao;

import java.util.List;

import com.example.purchase.model.Detail;
import com.example.purchase.model.Purchase;

public interface IPurchaseDAO {
	
	/**
	 * Method that verifies if a certain purchase exists in the Data Base.
	 * 
	 * @param Long id purchase
	 * @return boolean true if the purchase exists and false if purchase doesn't exist
	 */
	public boolean purchaseExists(Long id);
	
	/**Method that querys the data base and returns and returns all the Purchases available
	 * 
	 * @return List<{@link Purchase}> 
	 */
	public List<Purchase> getAllPurchases();
	
	/**Method that updates a single purchase in the dataBase 
	 * 
	 * @param {@link Purchase} purchase;
	 * @return boolean true if the transaction finished successfully or false if the transaction had a problem.
	 * 
	 */
	public Purchase updatePurchase(Purchase purchase);
	
	/**Method that create a single purchase in the dataBase 
	 * 
	 * @param {@link Purchase} purchase;
	 * @return boolean true if the transaction finished successfully or false if the transaction had a problem.
	 * 
	 */
	public Purchase createPurchase(Purchase purchase);
	
	
	public List<Detail> getDetailForValidPurchases(List<Long> purchasesIds);

}
