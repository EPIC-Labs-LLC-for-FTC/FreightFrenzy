package org.firstinspires.ftc.teamcode.RobotObjects.EPIC;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Touch_Sensor {
    public TouchSensor touch;
    public boolean isAutonomous =  false;
    public LinearOpMode parent;
    public Telemetry telemetry;
    public Servo servo;

    public Touch_Sensor(HardwareMap hardwareMap){
        touch = hardwareMap.get(TouchSensor.class,"touch");
    }

    public void servoRun(double position1, double position2){
        if(parent.opModeIsActive()){
            if(touch.isPressed()){
                servo.setPosition(position1);
            }
            else{
                servo.setPosition(position2);
            }
        }
    }

    public void maryam(double pos1, double pos2) {
        if(parent.opModeIsActive()){
            if(touch.isPressed()){
                servo.setPosition(pos1);
            }
            else{
                servo.setPosition(pos2);
            }
        }
    }

}
