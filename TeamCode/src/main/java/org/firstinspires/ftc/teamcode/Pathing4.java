package com.example.meepmeeplibrary;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Pathing4 {

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(90), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(36, -59.4, Math.toRadians(90)))
                                .forward(30)
                                .splineTo(new Vector2d(30,-6),Math.toRadians(145))
                                .setReversed(true)
                                .splineTo(new Vector2d(52, -12.2),Math.toRadians(0))
                                .setReversed(false)
                                .splineTo(new Vector2d(30,-6),Math.toRadians(145))
                                .setReversed(true)
                                .splineTo(new Vector2d(52, -12.2),Math.toRadians(0))
                                .setReversed(false)
                                .splineTo(new Vector2d(30,-6),Math.toRadians(145))
                                .setReversed(true)
                                .splineTo(new Vector2d(52, -12.2),Math.toRadians(0))
                                .setReversed(false)
                                .splineTo(new Vector2d(30,-6),Math.toRadians(145))
                                .setReversed(true)
                                .splineTo(new Vector2d(52, -12.2),Math.toRadians(0))
                                .setReversed(false)
                                .splineTo(new Vector2d(30,-6),Math.toRadians(145))
                                .setReversed(true)
                                .splineTo(new Vector2d(52, -12.2),Math.toRadians(0))
                                .setReversed(false)
                                .build()


                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
