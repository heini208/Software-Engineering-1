package Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import GrundKlassen.Parkhaus;

class ParkhausTest {
    Parkhaus p = new Parkhaus();
    String[] params = {"enter","1","1600209640220","_","_","4905a278e4071a2f5d0577c32c1ee688","39c69b","71","Any","PKW","7"};
	String[] params2 = {"enter","2","1600209640220","_","_","4905a278e4071a2f5d0577c32c1ee688","39c69b","71","Any","Motorrad","7"};
	String[] frau1 = {"enter","3","1600373313838","_","_","0ff82c92d5e43fa36f95a8ff095b6f98","#32de36","93","Frau","PKW","19"};
	String[] behinderung = {"enter","3","1600373313838","_","_","0ff82c92d5e43fa36f95a8ff095b6f98","#32de36","93","Behinderung","PKW","19"};
	String[] familie = {"enter","3","1600373313838","_","_","0ff82c92d5e43fa36f95a8ff095b6f98","#32de36","93","Familie","PKW","19"};
	
	@Test
	@DisplayName("getParked")
	void getParkedTest(){
		p.enter(params);
		p.enter(params2);
		assertEquals(2,p.getParked());
	}
	
	@Test
	@DisplayName("enter")
	void enterTest() {
		p.enter(params);
		p.enter(params2);
		
		assertEquals(2,p.getParked());
		assertEquals(96,p.getParkhaus().get(1).getSpace());
		assertEquals(1,p.getParkhaus().get(0).getSpace());
		assertEquals(true,p.getParkplatzBelegung()[95]);
		for (int i=0;i<7;i++) {
			p.enter(frau1);
		}
		assertEquals(9,p.getParked());
		assertEquals(85,p.getParkhaus().get(6).getSpace());
		assertEquals(3,p.getParkhaus().get(8).getSpace());
		assertEquals(false,p.getParkplatzBelegung()[86]);
		
		
	}
	
	@Test
	@DisplayName("leave, clearall")
	void leaveTest() throws Exception {
		p.enter(params);
		p.enter(params2);
		p.enter(frau1);
		assertEquals(true,p.getParkplatzBelegung()[80]);
		assertEquals(3,p.getParked());
		p.leave(frau1);
		assertEquals(false,p.getParkplatzBelegung()[80]);
		assertEquals(2,p.getParked());
		p.enter(frau1);
		assertEquals(81,p.getParkhaus().get(2).getSpace());
		p.clearall();
		assertEquals(0,p.getParked());
	}
	@Test
	@DisplayName("IsFull")
	void isFullTest() {
		for (int i=0; i<85; i++) {
			p.enter(frau1);
		}
		assertEquals(false,p.isFull());
		for (int i=0; i<5; i++) {
			p.enter(params2);
			p.enter(params2);
			p.enter(behinderung);
			p.enter(familie);
			System.out.println(i);
		}
		assertEquals(true,p.isFull());
	}
	

}
