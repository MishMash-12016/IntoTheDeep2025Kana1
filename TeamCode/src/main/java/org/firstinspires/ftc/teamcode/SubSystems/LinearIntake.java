package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class LinearIntake extends SubsystemBase {

    CuttleServo rightServo;
    CuttleServo leftServo;

    final double OPEN = 0;
    final double CLOSE = 0.3;
    final double MAX_OPENING_VALUE = 0.7;

    public LinearIntake() {
        rightServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.RIGHT_LINEAR_INTAKE);
        leftServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.LEFT_LINEAR_INTAKE);
    }
    public void setPosition(double position) {
        rightServo.setPosition(1-position * MAX_OPENING_VALUE);
        leftServo.setPosition (position * MAX_OPENING_VALUE);
    }

    public double getPosition() {
        return rightServo.getPosition();
    }



}
