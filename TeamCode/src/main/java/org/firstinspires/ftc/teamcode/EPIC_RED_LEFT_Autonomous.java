package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotObjects.EPIC.Claw;
import org.firstinspires.ftc.teamcode.RobotObjects.EPIC.Mecanum_Wheels;
import org.firstinspires.ftc.teamcode.tfrec.Detector;
import org.firstinspires.ftc.teamcode.tfrec.classification.Classifier;

import java.util.List;

@Autonomous(name="EPIC_RED_LEFT_Autonomous", group="Robot19587")
public class EPIC_RED_LEFT_Autonomous extends LinearOpMode {
    //Configuration used: 6wheelConfig
    private Detector tfDetector = null;

    private static String MODEL_FILE_NAME = "EPIC_red_left_model.tflite";
    private static String LABEL_FILE_NAME = "EPIC_red_left_labels.txt";
    private static Classifier.Model MODEl_TYPE = Classifier.Model.FLOAT_EFFICIENTNET;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        double distance = 0;
        double correctionFactor = 1;
        try {
            try {
                tfDetector = new Detector(MODEl_TYPE, MODEL_FILE_NAME, LABEL_FILE_NAME, hardwareMap.appContext, telemetry);
                tfDetector.parent = this;
                tfDetector.activate();

            } catch (Exception ex) {
                telemetry.addData("Error", String.format("Unable to initialize Detector. %s", ex.getMessage()));
                sleep(3000);
                return;
            }
            double speed = 0.6;
            Mecanum_Wheels mecanum = new Mecanum_Wheels(hardwareMap);
            mecanum.parent = this;
            Claw claw = new Claw(hardwareMap);
            claw.parent = this;
            claw.telemetry = this.telemetry;
            //sleep(5000);
            mecanum.IsAutonomous = true;
            mecanum.velocity = 400;
            mecanum.telemetry = this.telemetry;
            mecanum.initialize();
            String id = "";
            runtime.reset();
            telemetry.addData("Opmode Active", "No");
            telemetry.update();
            waitForStart();
            // run until the end of the match (driver presses STOP)
            int i =0;
            while (opModeIsActive()) {
                List<Classifier.Recognition> results = tfDetector.getLastResults();
                if (results == null || results.size() == 0) {
                    telemetry.addData("Info", "No results");
                } else {
                    for (Classifier.Recognition r : results) {
                        String item = String.format("%s: %.2f", r.getTitle(), r.getConfidence());
                        if (r.getConfidence() > 0.5) {
                            id = r.getId();
                            telemetry.addData("id", "[" + id + "]");
                            telemetry.addData("Found", item);
                            telemetry.update();
                            //sleep(20000);
                            break;
                        }
                    }
                }
                i++;
                if(i==100 || !id.equals(""))
                {
                    break;
                }
                else
                    sleep(100);
                telemetry.addData("id", "[" + id + "]");

                telemetry.addData("Opmode Active", "Yes");
                telemetry.update();
//
//
//
//                telemetry.addData("Info", "No results");
//                telemetry.update();
//                sleep(1000);
//                //}
            }

            int level = 1;
            //tfDetector.
            if(id.contains("0 red_left_left"))
                level = 1;
            else if(id.contains("1 red_left_middle"))
                level = 2;
            else if(id.contains("2 red_left_right"))
                level = 3;
            telemetry.addData("level", level);
            telemetry.update();
            claw.lift(level);
            sleep(500);
            correctionFactor = 1.444;//.4;
            distance = 27 * correctionFactor;
                mecanum.encoderDrive(speed,distance,distance/4,distance/4,distance,2);
                //sleep(2000);
                claw.release();
                sleep(1000);
                //sleep(2000);
                mecanum.encoderDrive(speed,-10,-10,-10,-10,2);
                //sleep(10000);

            //}
            claw.lift(0);
        }
        catch (Exception ex){
            telemetry.addData("Init Error", ex.getMessage());
            telemetry.update();
        }
        finally {
            if (tfDetector != null){
                tfDetector.stopProcessing();
            }
        }

    }

}