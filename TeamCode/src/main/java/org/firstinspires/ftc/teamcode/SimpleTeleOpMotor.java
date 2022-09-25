package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class SimpleTeleOpMotor extends LinearOpMode {
    public DcMotorEx frontRight;
    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.get(DcMotorEx.class,"frontRight");
        double lefty = 0;
        boolean dpad_left = false;
        boolean dpad_right = false;
        boolean x = false;
        boolean b = false;

      frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

      waitForStart();
      while (opModeIsActive()){
          lefty = gamepad1.left_stick_y;
          dpad_left = gamepad1.dpad_left;
          dpad_right = gamepad1.dpad_right;
          x = gamepad1.x;
          b = gamepad1.b;
          if(dpad_left){
              frontRight.setPower(0.1);
              sleep(5000);
          }
          if(dpad_right){
              frontRight.setPower(0.3);
              sleep(5000);
          }
          if(x){
              frontRight.setPower(0.6);
              sleep(5000);
          }
          if(b){
              frontRight.setPower(0.9);
              sleep(5000);
          }
          frontRight.setPower(lefty);

          }
      }
    }

