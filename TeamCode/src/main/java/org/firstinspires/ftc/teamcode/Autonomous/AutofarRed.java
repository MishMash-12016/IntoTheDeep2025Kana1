package org.firstinspires.ftc.teamcode.Autonomous;

//RR imports
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// non RR imports
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.MecanumDrive;


@Config
@Autonomous(name = "AutofarRed", group = "Autonomous")
public class AutofarRed extends CommandOpMode {

    Action traj;



    @Override
    public void initialize() {


        Pose2d initialPose = new Pose2d(14.83, -16.13, Math.toRadians(90.00));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

        traj = drive.actionBuilder(initialPose)

                .turn(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-58.85 , -38.37),Math.toRadians(90.00))
                .splineToConstantHeading(new Vector2d(-58.55 , -60.99),Math.toRadians(90.00))


                .build();

    }

    @Override
    public void run() {

        super.run();

        Actions.runBlocking(
                traj
        );

    }
}

