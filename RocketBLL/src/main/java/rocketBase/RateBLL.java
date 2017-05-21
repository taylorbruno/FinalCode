package rocketBase;

import org.apache.poi.ss.formula.functions.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import exceptions.RateException;
import rocketDomain.RateDomainModel;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.poi.ss.formula.functions.*;
import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;

		
	ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		for(RateDomainModel r : rates)
		{
			if(r.getiMinCreditScore() < GivenCreditScore)
			{
				dInterestRate = r.getiMinCreditScore();
				return dInterestRate;
			}
		}

		return dInterestRate;
		
		
	}
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
