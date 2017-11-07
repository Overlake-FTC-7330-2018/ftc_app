package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.pixycam.PixyCam;

/**
 * Created by lexis on 23-Oct-17.
 */

@Autonomous(name="CompetitionOpMode", group="Bot")
public class CompetitionOpMode extends AutonomousOpMode {
    private final int zone = 0;


    //////////// PIXY DECLARATIONS/////////
    /*private PixyCam pixyCam;
    private PixyCam pixyCam2;

    private double rightHorizServoCenter;
    private double rightVertServoTop;
    private double rightVertServoBottom;
    private double leftHorizServoCenter;
    private double leftVertServoTop;
    private double leftVertServoBottom;

    private PixyCam.Block leftRedBlock;
    private PixyCam.Block leftBlueBlock;
    private PixyCam.Block rightRedBlock;
    private PixyCam.Block rightBlueBlock;

    //Servo rightVertServo;
    Servo leftVertServo;
    //Servo rightHorizServo;
    Servo leftHorizServo;*/
    boolean teamColorIsBlue;
    //////////////////////////////////////////////////////

    @Override
    public void runOpMode() {
        initializeAllDevices();

        claw.setReleasePosition();
        elevator.goToZero(telemetry);
        waitForStart();
        //initPixy();
        cryptoBox(0);
        //driveToPositionRevs(3,0.5);
        //initPixy();
        //driveToPositionInches(-40, 1);



        //cryptoBox(0);
        stop();
    }

    public void cryptoBox(int zone) {
        claw.setLoadPosition();
        sleep(2000);
        elevator.goToUnloadPos1();
        // pic 0 is left     pic 1 is right      pic 2 is center
        // zone 0 is blue non-audience     zone 1 is blue audience    zone 2 is red non-audience    zone 3 is red audience
        if (zone == 0) {
            driveToPositionInches(-40, 1);
            turn(-90, 1);
            driveToPositionInches(-18, 1);
            turn(90, 1);
            elevator.goToZero(telemetry);
            claw.setReleasePosition();
            sleep(1000);
            driveToPositionInches(-20, 1);


        } else if (zone == 1) {
            driveToPositionInches(-50, 1);
            turn(90, 1);
            elevator.goToZero(telemetry);
            claw.setReleasePosition();
            sleep(2000);
            driveToPositionInches(-13, 1);
        } else if (zone == 2) {
            driveToPositionInches(40, 1);
            turn(-90, 1);
            driveToPositionInches(-18, 1);
            turn(-90, 1);
            elevator.goToZero(telemetry);
            claw.setReleasePosition();
            sleep(1000);
            driveToPositionInches(-18, 1);
        } else {
            driveToPositionInches(-50, 1);
            turn(-90, 1);
            elevator.goToZero(telemetry);
            claw.setReleasePosition();
            sleep(2000);
            driveToPositionInches(-18, 1);
        }
        claw.setReleasePosition();
    }

    /*public void initPixy() {
        pixyCam = hardwareMap.get(PixyCam.class, "pixycam");
        //pixyCam2 = hardwareMap.get(PixyCam.class, "pixycam2");

        //this.rightVertServo = hardwareMap.servo.get("rightvertservo");
        this.leftVertServo = hardwareMap.servo.get("leftvertservo");
        //this.rightHorizServo = hardwareMap.servo.get("righthorizservo");
        this.leftHorizServo = hardwareMap.servo.get("lefthorizservo");
        //this.rightHorizServoCenter = 0.4;
        //this.rightVertServoTop = 1.0;
        //this.rightVertServoBottom = 0.0;
        this.leftRedBlock = pixyCam.GetBiggestBlock(1);
        this.leftBlueBlock = pixyCam.GetBiggestBlock(2);
        telemetry.addData("Red: ", leftRedBlock.toString());
        telemetry.addData("Blue: ", leftBlueBlock.toString());
        telemetry.update();
        sleep(1000);
        leftVertServo.setPosition(1);
        sleep(1000);
        waitForStart();

        if (teamColorIsBlue == true) {
            if (this.leftRedBlock.x < this.leftBlueBlock.x) {  // if red is further left than blue
                leftHorizServo.setPosition(0.8); // then move the servo left
                sleep(1000);
                leftHorizServo.setPosition(0.5);
            } else {
                leftHorizServo.setPosition(0.2);
                sleep(1000);
                leftHorizServo.setPosition(0.5); // move the servo right -- also, if no values are found for x, it will go right
            }
            sleep(1000);
            leftVertServo.setPosition(0);
            sleep(1000);
        } else {
            if (leftRedBlock.x < leftBlueBlock.x) {  // if red is further left than blue
                leftHorizServo.setPosition(0.2); // then move the servo left
                sleep(1000);
                leftHorizServo.setPosition(0.5);
            } else {
                leftHorizServo.setPosition(0.8);
                sleep(1000);
                leftHorizServo.setPosition(0.5); // move the servo right -- also, if no values are found for x, it will go right
            }
            sleep(1000);
            leftVertServo.setPosition(0);
            sleep(1000);









            /*
            this.rightRedBlock = pixyCam2.GetBiggestBlock(1);
            this.rightBlueBlock = pixyCam2.GetBiggestBlock(2);
            telemetry.addData("Red :", rightRedBlock.toString());
            telemetry.addData("Blue :", rightBlueBlock.toString());
            telemetry.update();
            sleep(1000);
            rightVertServo.setPosition(rightVertServoBottom);
            sleep(1000);
            if (rightRedBlock.x < rightBlueBlock.x) {
                rightHorizServo.setPosition(rightHorizServoCenter + 0.2);
                sleep(1000);
                rightHorizServo.setPosition(rightHorizServoCenter);
            } else {
                rightHorizServo.setPosition(rightHorizServoCenter - 0.2);
                sleep(1000);
                rightHorizServo.setPosition(rightHorizServoCenter);
            }
            sleep(1000);
            rightVertServo.setPosition(rightVertServoTop);
            sleep(1000);
        }
    }*/

}