package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.RobotObjects.EPIC.Touch_Sensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;
@Autonomous
public class touchSensorRun extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        Touch_Sensor touch = new Touch_Sensor(hardwareMap);
        touch.isAutonomous = true;
        touch.parent = this;
        touch.servo = hardwareMap.get(Servo.class,"servo");
        while (opModeIsActive()) {
            touch.maryam(0.5,1);
        }




    }
}
