package com.medistore;

import java.time.LocalDate;

public interface ISellable {
	void sell(int quantity);
	boolean checkExpiry(LocalDate date);
}
