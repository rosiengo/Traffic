/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcl.keepitclean.main.policy;
import java.util.Random;


/**
 *
 * @author RosieNgo
 */
public class Policy {
    /*
    1) SIMULATION ENGINE: AT THE BEGINNING OF EACH SESSION, CALL setPolicy(PARAMEMTERS) METHOD TO GENERATE POLICY BASED ON USER INPUTS
    
    PARAMETERS:
    
    - MODE: 0 (DEFAULT), 1(CUSTOMISED), 2 (RANDOM)
    
    - SPEEDLIMITFROM/ SPEEDLIMITTO: ARRAY OF SPEED LIMIT RANGE SETTINGS  [1]: JUNCTION SPEED LIMIT, [2] STRAIGHT ROAD SPEED LIMIT, [3]: CURVY ROAD SPEED LIMIT
    IN CASE OF CUSTOMISED POLICY, SPEEDLIMITTO  = NULL;
    
   -  TRAFFICLIGHTFROM/TRAFFICLIGHTTO: ARRAY OF TRAFFIC LIGHT TIMING SETTINGS: [1]: GREEN; [2]: AMBER; [3]: RED
    IN CASE OF CUSTOMISED POLICY: TRAFFICLIGHTTO = NULL;
    
    2) OTHER CLASSES: CALL getPolicyInstance() TO GET POLICY INSTANCE.
    
    INDIVIDUAL POLICY SETTINGS CAN BE ACCESSED VIA RELEVANT GET METHODS    
      
     */ 
    
    private SpeedLimit speedLimit;
    private TrafficLight trafficLight;
    private static Policy instance = new Policy();
    
private Policy(int[] userSpeedLimit, int[] userTrafficLight) //customised policy
{
    //TO DO LIST: EXCEPTION HANDLER
    
      speedLimit = new SpeedLimit(userSpeedLimit[0], userSpeedLimit[1], userSpeedLimit[2]);
      trafficLight = new TrafficLight(userTrafficLight[0], userTrafficLight[1],userTrafficLight[2]);
    
    
}

private Policy(int[] speedLimitFrom, int[] speedLimitTo,int[] trafficLightFrom, int[] trafficLightTo) /* random generated policy*/
{
    //TO-DO: EXCEPTION HANDLING 
     int straightRoadLimit;
     int curvyRoadLimit;
     int junctionLimit;
     int greenTiming;
     int amberTiming;
     int redTiming;
     Random generator = new Random();
     
     junctionLimit = speedLimitFrom[0] + generator.nextInt(speedLimitTo[0]);
     straightRoadLimit = speedLimitFrom[1] + generator.nextInt(speedLimitTo[1]);
     curvyRoadLimit = speedLimitFrom[2] + generator.nextInt(speedLimitTo[2]);
     greenTiming = trafficLightFrom[0] + generator.nextInt(trafficLightFrom[0]);
     amberTiming = trafficLightFrom[1] + generator.nextInt(trafficLightFrom[1]);
     redTiming = trafficLightFrom[2] + generator.nextInt(trafficLightFrom[2]);
        
    speedLimit = new SpeedLimit(junctionLimit,straightRoadLimit,curvyRoadLimit);
    trafficLight = new TrafficLight(greenTiming,amberTiming,redTiming);
    
}

private Policy()  //default policy
      
{
  
    speedLimit = new SpeedLimit(30,60,40); //Junction 30mph,  Straight Road 60mph, Curvy Road 40mph
    trafficLight = new TrafficLight(30,5,10); //green 30s, amber 5s, red 10s)   
}




public static Policy setPolicy(int mode,int[] speedLimitFrom, int[] speedLimitTo,int[] trafficLightFrom, int[] trafficLightTo){
    
    //TO DO: EXCEPTION HANDLING
    
    //this.resetPolicy();
    instance = null;
    if (mode == 0)
        instance = new Policy();
    else if (mode == 1)
        instance = new Policy(speedLimitFrom,trafficLightFrom);
    else if (mode == 2)
        instance = new Policy(speedLimitFrom, speedLimitTo,trafficLightFrom,trafficLightTo);
     
  
    return instance;
}
public static Policy getPolicyInstance()
{
    if (instance == null)
    {
        instance = new Policy();  //default policy
    }
    return instance;
}
public int getJunctionSpeedLimit()
{
    return this.speedLimit.junction;
   
}    
public int getStraightRoadSpeedLimit(){
    return this.speedLimit.straightRoad;
    
} 
public int getCurvyRoadSpeedLimit(){
    return this.speedLimit.curvyRoad;
    
}
public int getGreenTrafficLightTime(){
     return this.trafficLight.green;
 }
public int getAmberTrafficLightTime(){
    return this.trafficLight.amber;
}
public int getRedTrafficLightTime(){
    return this.trafficLight.red;
}
private static void resetPolicy()
{
    instance = null;
}

}

