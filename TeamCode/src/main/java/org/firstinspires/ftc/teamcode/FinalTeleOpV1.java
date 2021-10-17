/* This program makes it easier to control the robot by letting the left stick control
forward and backward movement and letting the right stick x control the rotating of
the robot just like an Rc Car.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "Mecanum_TeleOp_test")
public class FinalTeleOpV1 extends LinearOpMode {

    //Declaring Motors
    private DcMotor TopRight;
    private DcMotor TopLeft;
    private DcMotor BottomRight;
    private DcMotor BottomLeft;
    private DcMotor MiddleRight;
    private DcMotor MiddleLeft;

    double lefty = 0.0;
    double leftx = 0.0;
    double righty = 0.0;
    double rightx = 0.0;


    public void move_forwardback(){
        TopRight.setPower(-lefty);
        TopLeft.setPower(lefty);
        BottomRight.setPower(-lefty);
        BottomLeft.setPower(lefty);
        MiddleRight.setPower(-lefty);
        MiddleLeft.setPower(lefty);
    }

    public void move_side(){
        TopRight.setPower(leftx);
        TopLeft.setPower(leftx);
        BottomRight.setPower(-leftx);
        BottomLeft.setPower(-leftx);

    }

    //top right, bottom left diagonal directions
    public void diagonal(){
        if (rightx>0 && lefty>0) {
            TopLeft.setPower(lefty);
            BottomRight.setPower(-lefty);
        }
        else if (rightx<0 && lefty<0){
            TopLeft.setPower(-lefty);
            TopRight.setPower(lefty);
        }

    }
    //top left, bottom right diagonal directions
    public void diagonal2(){
        if (rightx<0 && lefty>0) {
            TopRight.setPower(-lefty);
            BottomLeft.setPower(lefty);
        }
        else if (rightx>0 && lefty<0){
            TopRight.setPower(lefty);
            BottomLeft.setPower(-lefty);
        }

    }



    @Override
    public void runOpMode() throws InterruptedException {
        //Hardware Mapping
        Rightmotor1 = hardwareMap.get(DcMotor.class, "Topright");
        Leftmotor1 = hardwareMap.get(DcMotor.class, "Topleft");
        Rightmotor2 = hardwareMap.get(DcMotor.class, "Bottomright");
        Leftmotor2 = hardwareMap.get(DcMotor.class, "Bottomleft");

        waitForStart();
        while (opModeIsActive()) {
            double reset = 0;
            Rightmotor1.setPower(reset);
            Leftmotor1.setPower(reset);
            Leftmotor2.setPower(reset);
            Rightmotor2.setPower(reset);

            lefty = gamepad1.left_stick_y;
            leftx = gamepad1.left_stick_x;
            righty = gamepad1.right_stick_y;
            rightx = gamepad1.right_stick_x;

            move_forwardback();
            move_side();
            diagonal();
            diagonal2();

            //Displays power of each motor on the robot controller
            telemetry.addData("top left motor", "%.2f", Leftmotor1.getPower());
            telemetry.addData("top right motor", "%.2f", Rightmotor1.getPower());
            telemetry.addData("bottom left motor", "%.2f", Leftmotor2.getPower());
            telemetry.addData("bottom right motor", "%.2f", Rightmotor2.getPower());

            telemetry.addData("lefty", "%.2f", lefty);
            telemetry.addData("leftx", "%.2f", leftx);

            telemetry.addData("rightx", "%.2f", rightx);
            telemetry.addData("righty", "%.2f", righty);

            telemetry.update();


        }




    }


}