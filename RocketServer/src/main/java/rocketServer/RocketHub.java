package rocketServer;

import java.io.IOException;

import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message received.");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;

			try{
				lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
			}
			catch(RateException re){
				System.out.println("RateException: " + re.getMessage());
				re.printStackTrace();
			}
			
			lq.setdPayment(RateBLL.getPayment(lq.getdRate(), lq.getiTerm(), lq.getiDownPayment(), 0, false));
			
			sendToAll(lq);
		}
	}
}
