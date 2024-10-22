package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CommandGroup.AutoIntake;
import org.firstinspires.ftc.teamcode.CommandGroup.ElevatorBackTo_0;
import org.firstinspires.ftc.teamcode.CommandGroup.Intake;
import org.firstinspires.ftc.teamcode.CommandGroup.Scoring;
import org.firstinspires.ftc.teamcode.Commands.ClawSetState;
import org.firstinspires.ftc.teamcode.Commands.ElevatorGetToPosition;
import org.firstinspires.ftc.teamcode.Commands.LinearIntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.SetLinearPosition;
import org.firstinspires.ftc.teamcode.Commands.TrajectroryFollowerCommend;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.AutoMecanumDrive;
import org.firstinspires.ftc.teamcode.SubSystems.Claw;
import org.firstinspires.ftc.teamcode.utils.OpModeType;

@Autonomous
public class CommandPractice extends CommandOpMode {

    @Override
    public void initialize() {

        MMRobot.getInstance().init(OpModeType.NonCompetition.EXPERIMENTING,hardwareMap,gamepad1,gamepad2,telemetry);
        MMRobot.getInstance().mmSystems.initElevator();
        MMRobot.getInstance().mmSystems.initLinearIntake();
        MMRobot.getInstance().mmSystems.initClaw();
        MMRobot.getInstance().mmSystems.initIntakeArm();
        MMRobot.getInstance().mmSystems.initScoringArm();
        MMRobot.getInstance().mmSystems.initIntakeRoller();

        final AutoMecanumDrive drive = new AutoMecanumDrive(new SampleMecanumDrive(hardwareMap));


        Pose2d startPose = new Pose2d(-60, 0, 0);

        drive.setPoseEstimate(startPose);

        TrajectorySequence START_POINT_TO_BASCET = drive.trajectorySequenceBuilder(startPose)

                .splineToLinearHeading(
                        new Pose2d(-52, 52,Math.toRadians(-45)),
                        Math.toRadians(90)  //tangent
                ).build();

        TrajectorySequence FROM_THE_FIRST_SCORING_TO_THE_FIRST_INTAKE = drive.trajectorySequenceBuilder(START_POINT_TO_BASCET.end())
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(
                        new Pose2d(-44,30,Math.toRadians(40)),
                        Math.toRadians(0)  //tangent
                ).build();

        TrajectorySequence FROM_FIRST_INTAKE_TO_SCORING = drive.trajectorySequenceBuilder(FROM_THE_FIRST_SCORING_TO_THE_FIRST_INTAKE.end())
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(
                        new Pose2d(-55,55,Math.toRadians(-45)),
                        Math.toRadians(97))//tangent
                .build();

        TrajectorySequence FROM_SCORING_TO_PARKING = drive.trajectorySequenceBuilder(FROM_FIRST_INTAKE_TO_SCORING.end())
                .splineToLinearHeading(
                        new Pose2d(-60,-55,Math.toRadians(-90)),
                        Math.toRadians(-90))//tangent
                .build();


        schedule(
                new SequentialCommandGroup(
                        new InstantCommand(),
                        new TrajectroryFollowerCommend(START_POINT_TO_BASCET, drive),
                        new Scoring(73),
                        new WaitCommand(500),
                        new ElevatorBackTo_0(),
                        new TrajectroryFollowerCommend(FROM_THE_FIRST_SCORING_TO_THE_FIRST_INTAKE, drive),
                        new AutoIntake(),
                        new TrajectroryFollowerCommend(FROM_FIRST_INTAKE_TO_SCORING,drive),
                        new Scoring(73),
                        new ElevatorBackTo_0(),
                        new TrajectroryFollowerCommend(FROM_SCORING_TO_PARKING,drive)
                )
        );






    }
}

