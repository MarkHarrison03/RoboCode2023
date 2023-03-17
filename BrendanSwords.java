package bs;
import robocode.*;
import java.lang.Math.*;
import java.awt.Color;

 

public class BrendanSwords extends AdvancedRobot
{
int forwardOrBack = 1;	
boolean forwardVelocity = false;
Color bodyColor = new Color(0.38f, 1.0f, 0.31f);
Color gunColor =  new Color(0.97f,0.48f,1f);
Color radarColor = new Color(0f, 1f, 0.945f);
int noOfRobots = 0;
public void run(){
setColors(bodyColor, gunColor, radarColor);
		noOfRobots = getOthers();
		boolean start = true;
		while(start){	
		if(noOfRobots>16){
		setTurnRight(10000);
			
		setMaxVelocity(5);
			
		setAhead(10000);
		execute();
		}else{
		setAdjustRadarForRobotTurn(true);
		turnRadarRight(360000);
		}
			
		}
}
		
	public void onScannedRobot(ScannedRobotEvent e) {
	if(noOfRobots > 16){
	System.out.println("AAA");
			setFire(3);
			execute();
			return;
}
	
if(e.isSentryRobot()){
    double centerAngle = Math.atan2(getBattleFieldWidth()/2-getX(), getBattleFieldHeight()/2-getY());
    setTurnRightRadians(fixAim(centerAngle - getHeadingRadians()));
    setAhead(100);

	return;
}

	if((Math.random() * 1000) > 998){
		setTurnRight(90);
}

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

	
public void onHitRobotEvent(HitRobotEvent e){
	if(e.isMyFault()){
	setBack(50);
	}
}
	
	
public	double fixAim(double angle){
	if(angle > 180){return angle-360;}
	if(angle < -180){return angle+360;}
	return angle;
}
	 
public void onHitWall(HitWallEvent e) {
	if(noOfRobots > 16){	
		
	
		if(forwardVelocity){
			setBack(1000);
			forwardVelocity = false;
		}else{
			setAhead(1000);
			forwardVelocity = true;
		}
}else{
	forwardOrBack *= -1;
}
}

	

}