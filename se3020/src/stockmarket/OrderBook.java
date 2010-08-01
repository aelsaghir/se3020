package stockmarket;

import java.sql.Time;

public class OrderBook {
	private orderList ask;
	private orderList bid;
	
	OrderBook() {
		ask = null;
		bid = null;
	}
	
	private class orderList {
		Time time;
		int price;
		int qty;
		double ID;
		orderList next;
		
		orderList(Time t, int p, int q, double i, orderList n) {
			this.time = t;
			this.price = p;
			this.qty = q;
			this.ID = i;
			this.next = n;
		}
		
	}
}
