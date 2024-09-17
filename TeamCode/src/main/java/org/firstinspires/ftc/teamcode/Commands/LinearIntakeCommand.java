package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.LinearIntake;

public class LinearIntakeCommand extends CommandBase {
    LinearIntake linearIntake = MMRobot.getInstance().mmSystems.linearIntake;
    double position;

    public LinearIntakeCommand(double position){
        this.position = position;
    }
    @Override public void initialize(){

}

}
