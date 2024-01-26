package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.Main;

import org.checkerframework.checker.initialization.qual.Initialized;

@TeleOp (name = "newteleop")


public class  newteleop  extends Main {
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        if (isStopRequested()) return;

        initHardware();
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double leftFrontPower = (y + x + rx) / denominator;
            double leftBackPower = (y - x + rx) / denominator;
            double rightFrontPower = (y - x - rx) / denominator;
            double rightBackPower = (y + x - rx) / denominator;

            leftFrontDrive.setPower(leftFrontPower);
            leftBackDrive.setPower(leftBackPower);
            rightBackDrive.setPower(rightBackPower);
            rightFrontDrive.setPower(rightFrontPower);


            if (gamepad1.a) {
                arm.setDirection(DcMotorSimple.Direction.REVERSE);
                arm.setPower(1);
                arm2.setDirection(DcMotorSimple.Direction.FORWARD);
                arm2.setPower(1);

            } else {
                arm.setPower(0);
                arm2.setPower(0);
            }

            if (gamepad1.b) {
                arm.setDirection((DcMotorSimple.Direction.FORWARD));
                arm.setPower(1);
                arm2.setDirection(DcMotorSimple.Direction.REVERSE);
                arm2.setPower(1);

                if (gamepad1.y) {
                    servo1.setPosition(1);
                    servo2.setPosition(0);
                }
                if (gamepad2.a) {
                    airbus.setPower(1);
                } else {
                    airbus.setPower(0);
                }



            }
        }

    }
}
