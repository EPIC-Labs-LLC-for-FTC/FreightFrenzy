package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous
public class DCMotorTest extends LinearOpMode {
    DcMotorEx frontRight = hardwareMap.get(DcMotorEx.class,"frontRight");
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while(opModeIsActive()){
            frontRight.setPower(0.5);
            sleep(5000);
            frontRight.setPower(-0.5);
            sleep(5000);
            frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
            frontRight.setPower(0.6);
            sleep(5000);
        }

    }
}
