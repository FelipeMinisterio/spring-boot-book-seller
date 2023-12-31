package com.example.springbootbookseller.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootbookseller.model.PurchaseHistory;
import com.example.springbootbookseller.repository.IPurchaseHistoryRepository;
import com.example.springbootbookseller.repository.projection.IPurchaseItem;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {

	private final IPurchaseHistoryRepository purchaseHistoryRepository;

	public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
		this.purchaseHistoryRepository = purchaseHistoryRepository;
	}

	@Override
	public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
		purchaseHistory.setPurchaseTime(LocalDateTime.now());
		return purchaseHistoryRepository.save(purchaseHistory);
	}

	@Override
	public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId) {
		return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
	}

}
