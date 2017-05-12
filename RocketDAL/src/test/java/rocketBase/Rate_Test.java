package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import rocketDomain.RateDomainModel;

public class Rate_Test {


	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rate Size:" + rates.size());
		assert(rates.size() > 0);
		assert(1==1);
	}

	//Check that rates in tblRate are >0
	@Test
	public void testGetAllRates() {
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		assertTrue(rates.size() > 0);
	}
}