package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class IntakeArm extends SubsystemBase {

    MMRobot mmRobot = MMRobot.getInstance();

    CuttleServo servoRight;
    CuttleServo servoLeft;

    public IntakeArm(){
        servoRight = new CuttleServo(mmRobot.mmSystems.controlHub, Configuration.ARM_ANGLE_RIGHT);
        servoLeft = new CuttleServo(mmRobot.mmSystems.controlHub, Configuration.ARM_ANGEL_LEFT);
    }
        //TODO: revese one of the servos
    public void setPosition(double position){
        servoLeft.setPosition(position);
        servoRight.setPosition(position);
    }
    //TODO: got position

}
