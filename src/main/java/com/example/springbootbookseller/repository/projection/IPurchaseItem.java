package com.example.springbootbookseller.repository.projection;

import java.time.LocalDateTime;

public interface IPurchaseItem {

	String getTitle();
	Double getPrice();
	LocalDateTime getPurchaseTime();
}
