package org.firstinspires.ftc.teamcode.MMLib.Examples.TeleOps;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CuttlefishFTCBridge.src.devices.MMServo;
import org.firstinspires.ftc.teamcode.MMLib.MMTeleOp;
import org.firstinspires.ftc.teamcode.MMLib.Utils.MMUtils;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.OpModeType;

@TeleOp
public class CartridgeTest extends MMTeleOp {
    public CartridgeTest() {
        super(OpModeType.NonCompetition.EXPERIMENTING);
    }

    MMRobot mmRobot = MMRobot.getInstance();

    @Override
    public void onInit() {
        MMServo servo = mmRobot.mmSystems.expansionHub.getServo(4);

        mmRobot.mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whileActiveOnce(
                new CommandBase() {
                    @Override
                    public void execute() {
                        servo.setPosition(
                                1 - MMUtils.joystickToServo(
                                        mmRobot.mmSystems.gamepadEx1.getLeftX()
                                )
                        );
                    }
                }
        );

    }
}
