package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;
import org.firstinspires.ftc.teamcode.launch;

@TeleOp(name = "mecanum", group = "examples")

    public class MecanumTeleOp extends LinearOpMode {
launch launch = new launch();
@Override
    public void runOpMode () throws InterruptedException {


        DcMotor leftFrontDrive = hardwareMap.dcMotor.get("leftFrontDrive");
        DcMotor rightFrontDrive = hardwareMap.dcMotor.get("rightFrontDrive");
        DcMotor rightBackDrive = hardwareMap.dcMotor.get("rightBackDrive");
        DcMotor leftBackDrive = hardwareMap.dcMotor.get("leftBackDrive");
        DcMotor airbus = hardwareMap.dcMotor.get("airbus");
        DcMotor arm = hardwareMap.dcMotor.get("arm");
        DcMotor arm2 = hardwareMap.dcMotor.get("arm2");







        leftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx),1);
            double leftFrontPower = (y + x + rx) / denominator;
            double leftBackPower = (y - x + rx) / denominator;
            double rightFrontPower = (y - x - rx) / denominator;
            double rightBackPower = (y + x - rx) / denominator;

            leftFrontDrive.setPower(leftFrontPower);
            leftBackDrive.setPower(leftBackPower);
            rightBackDrive.setPower(rightBackPower);
            rightFrontDrive.setPower(rightFrontPower);
            arm.setPower(0);
            arm2.setPower(0);
            airbus.setPower(0);

            telemetry.addData("BackLeftEncoder", );
            telemetry.addData("BackRightEncoder", );
            telemetry.addData("FrontLeftEncoder", );
            telemetry.addData("FrontRightEncoder", );

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
                    launch.servo1.setPosition(1);
                    launch.servo2.setPosition(0);
                    }

                /*else {
                        airbus.setPower(0);
                    } */

                }




            }
        }
    }










