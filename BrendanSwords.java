package bs;
import robocode.*;
import java.lang.Math.*;
import java.awt.Color;

 

public class BrendanSwords extends AdvancedRobot
{
int forwardOrBack = 1;	
public void run(){
		boolean start = true;
		while(start){	
		
		setAdjustRadarForRobotTurn(true);
		turnRadarRight(360000);
			
		}
}
		
	public void onScannedRobot(ScannedRobotEvent e) {

	setTurnRadarLeft(getRadarTurnRemaining());
	if(e.getDistance() >= 150){
	
		double turnDistance = fixAim( e.getBearing() + getHeading() - getGunHeading() );
		if(e.getVelocity() < 5){
	
			setTurnGunRight(turnDistance);
		}else{
			setTurnGunRight(turnDistance + 20);
			}
	
		setAhead((e.getDistance() - 100) * forwardOrBack);
		setFire(2);
		System.out.println("2!");
	}else{
		double turnDistance = fixAim( e.getBearing() + getHeading() - getGunHeading() );
			
			setTurnGunRight(turnDistance);
		
		setFire(3);
		System.out.println("3!");

}
		
	}

	

	
	double fixAim(double angle){
	if(angle > 180){return angle-360;}
	if(angle < -180){return angle+360;}
	return angle;
	}
	 
	public void onHitWall(HitWallEvent e) {
	if(getVelocity() == 0){
	forwardOrBack *= -1;
 	}

	}	
}
