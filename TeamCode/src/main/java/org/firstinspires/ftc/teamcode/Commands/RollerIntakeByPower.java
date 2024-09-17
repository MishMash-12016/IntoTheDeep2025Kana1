package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.RollerIntake;

public class RollerIntakeByPower extends CommandBase {
    RollerIntake intake = MMRobot.getInstance().mmSystems.intake;
    double power;

    public RollerIntakeByPower(double power){
        this.power = power;
        this.addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.setPower(power);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setPower(0);
    }

}
