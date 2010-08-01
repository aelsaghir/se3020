package stockmarket;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CliTest extends TestCase {
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	
	public CliTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		t1 = "#Instrument,Date,Time,Record Type,Price,Volume,Value,Trans ID,Bid ID,Ask ID,Bid/Ask";
		t2 = "#Instrument,Bid/Ask,Date,Time,GMT Offset,Value,Trans ID,Type,Ex/Cntrb.ID,Record Type,Price,Volume,VWAP,Buyer ID,Bid,Bid ID,Ask ID";
		t3 = "Bid/Ask,Ask ID,Bid ID,Trans ID,Value,Volume,Price,Record Type,Time,Date,#Instrument";
		t4 = "#Instrument,,Date,,Time,,Record Type,,Price,,Volume,,Value,,Trans ID,,Bid ID,,Ask ID,,Bid/Ask";
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		t1 = null;
		t2 = null;
		t3 = null;
		t4 = null;
	}

	public void basic1(){
		int[] n = Cli.getOrder(t1);
		for (int i = 0; i < n.length; i++) {
			assertTrue(n[i]==i);
		}
	}
	
	public void basic2(){
		int[] n = Cli.getOrder(t2);
		assertTrue(n[0]==0);
		assertTrue(n[1]==2);
		assertTrue(n[2]==3);
		assertTrue(n[3]==9);
		assertTrue(n[4]==10);
		assertTrue(n[5]==11);
		assertTrue(n[6]==5);
		assertTrue(n[7]==6);
		assertTrue(n[8]==15);
		assertTrue(n[9]==16);
		assertTrue(n[10]==1);         
	}
	
	public void basic3(){
		int[] n = Cli.getOrder(t3);
		int j = 10;
		for (int i = 0; i<10; i++, j--) {
			assertTrue(n[i]==j);
		}
	}
	
	public void basic4(){
		int[] n = Cli.getOrder(t4);
		for (int i = 0; i < n.length; i++) {
			assertTrue(n[i]==i*2);
		}
	}
	
	public static Test suite(){
	      TestSuite suite = new TestSuite();
	      suite.addTest(new CliTest("basic1"));
	      suite.addTest(new CliTest("basic2"));
	      suite.addTest(new CliTest("basic3"));
	      suite.addTest(new CliTest("basic4"));
		return suite;
	}
}
