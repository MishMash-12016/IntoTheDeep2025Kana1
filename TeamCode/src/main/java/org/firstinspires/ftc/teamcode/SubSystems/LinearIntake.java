package org.firstinspires.ftc.teamcode.SubSystems;


import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;

public class LinearIntake extends SubsystemBase {

    MMRobot mmRobot = MMRobot.getInstance();
    CuttleServo rightServo;
    CuttleServo leftServo;

    public LinearIntake() {
        rightServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, 1);
        leftServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, 2);
    }

    public void setPosition(double position){
        rightServo.setPosition(position);
        leftServo.setPosition(position);
    }

    // TODO: get position

}
