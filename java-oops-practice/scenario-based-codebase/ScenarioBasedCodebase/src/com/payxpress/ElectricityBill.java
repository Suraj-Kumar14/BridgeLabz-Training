package com.payxpress;
import java.time.LocalDate;

public class ElectricityBill extends Bill implements IPayable{

	public ElectricityBill() {
		super(
		        "Electric Bill",
		        5000.0,
		        LocalDate.of(2026, 1, 12),
		        false
		    );
	}

	public void pay(double amount) {
		if(amount>0 && amount<=getAmount()) {
			int currentBill =(int)(calculatePayableAmount()-amount);
			if(currentBill==0) {
				setPaid(true);
			}
			setAmount(currentBill);
			System.out.println("\nElectric Bill Amount paid success.");
		}else {
			System.out.println("\nInvalid amount.");
		}
	}

	
	protected double getLateFee() {
	    return 60.0; 
	}
	
	protected double calculatePayableAmount() {
	    if (isOverdue()) {
	        return getAmount() + getLateFee(); 
	    }
	    return getAmount();
	}
	
	@Override
	public void sendRemainder() {
		if(isOverdue()) {
			System.out.println("---Please Must Pay the bill--------");
			System.out.println("Due date: "+getDueDate());
		}else {
			System.out.println("---Please pay the bills before due date----");
			System.out.println("Due date: "+getDueDate());
		}
	}
	
	protected boolean isOverdue() {
	    return LocalDate.now().isAfter(getDueDate());
	}

	public void showBill() {
		System.out.println("Current Electric Bill Amount: "+getAmount());
		sendRemainder();
	}

}