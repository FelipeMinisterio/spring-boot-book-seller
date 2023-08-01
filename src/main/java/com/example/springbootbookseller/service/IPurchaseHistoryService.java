package com.example.springbootbookseller.service;

import java.util.List;

import com.example.springbootbookseller.model.PurchaseHistory;
import com.example.springbootbookseller.repository.projection.IPurchaseItem;

public interface IPurchaseHistoryService {

	List<IPurchaseItem> findPurchasedItemsOfUser(Long userId);

	PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

}
