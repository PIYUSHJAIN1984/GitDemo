package Sec32_259_Interface;

public class Sec32_259_AustralianTraffic implements Sec32_259_1_CountryTrafficInterface ,Sec32_259_2_ContinentTrafficInterface {

	public static void main(String[] args) {
		
		//For objects from interface use implementation  from interface Sec32_259_1_CountryTrafficInterface
		Sec32_259_1_CountryTrafficInterface a = new Sec32_259_AustralianTraffic();
		a.redStop();
		a.greenGo();
		a.flashYellow();
		
		Sec32_259_2_ContinentTrafficInterface b = new Sec32_259_AustralianTraffic();
		b.trafficSignal();
		
		//For objects  from class use implementation from class Sec32_259_AustralianTraffic
		Sec32_259_AustralianTraffic at = new Sec32_259_AustralianTraffic();
		at.lightingStand();
	}

	@Override
	public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println("Green implementation");

	}

	@Override
	public void redStop() {
		// TODO Auto-generated method stub
		System.out.println("Red implementation");

	}

	@Override
	public void flashYellow() {
		// TODO Auto-generated method stub
		System.out.println("Yellow implementation");

	}

	@Override
	public void trafficSignal() {
		// TODO Auto-generated method stub
	}
	
	public void lightingStand() {
		// TODO Auto-generated method stub
		System.out.println("lightingStand implementation");

	}

}
