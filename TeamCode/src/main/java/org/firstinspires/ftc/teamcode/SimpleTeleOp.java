package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class SimpleTeleOp extends LinearOpMode {
    public DcMotorEx frontRight = hardwareMap.get(DcMotorEx.class,"frontRight");
    public DcMotorEx frontLeft = hardwareMap.get(DcMotorEx.class,"frontLeft");
    public DcMotorEx backRight = hardwareMap.get(DcMotorEx.class,"backRight");
    public DcMotorEx backLeft = hardwareMap.get(DcMotorEx.class,"backLeft");
    @Override
    public void runOpMode() throws InterruptedException {
      double lefty = gamepad1.left_stick_y;
      double leftx = gamepad1.left_stick_x;

      frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
      backRight.setDirection(DcMotorSimple.Direction.REVERSE);

      waitForStart();
      while (opModeIsActive()){
          if(lefty>0.7){
              frontRight.setPower(lefty);
              frontLeft.setPower(lefty);
              backRight.setPower(lefty);
              backLeft.setPower(lefty);
          }
          if(lefty<-0.7){
              frontRight.setPower(-lefty);
              frontLeft.setPower(-lefty);
              backRight.setPower(-lefty);
              backLeft.setPower(-lefty);
          }
          if(leftx>0.7){
              frontRight.setPower(-leftx);
              frontLeft.setPower(leftx);
              backRight.setPower(leftx);
              backLeft.setPower(-leftx);
          }
          if(leftx<-0.7){
              frontRight.setPower(leftx);
              frontLeft.setPower(-leftx);
              backRight.setPower(-leftx);
              backLeft.setPower(leftx);
          }

          }
      }
    }

