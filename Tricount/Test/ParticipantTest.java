package dev.java.tricount.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dev.java.tricount.model.Participant;
import dev.java.tricount.model.Remboursement;
import junit.framework.Assert;

public class ParticipantTest {

	@Test
	public void testCalculerRemboursements() {
		Participant p1 = new Participant(10,"p1N","p1P","EUR","Paypal",20);
		Participant p2 = new Participant(11,"p2N","p2P","EUR","Paypal",10);
		Participant p3 = new Participant(12,"p3N","p3P","EUR","Paypal",-12);
		Participant p4 = new Participant(13,"p4N","p4P","EUR","Paypal",-18);
		
		ArrayList<Participant> input4 = new ArrayList<Participant>();
		input4.add(p1);
		input4.add(p2);
		input4.add(p3);
		input4.add(p4);
		
		ArrayList<Remboursement> rembs = Participant.calculerRemboursements(input4);
		assertEquals(3, rembs.size());
		for (Participant p : input4) {
			assertTrue(0 == p.getSolde());
			
		}
		//System.out.println(rembs);
		//fail("Not yet implemented");
	}

}
