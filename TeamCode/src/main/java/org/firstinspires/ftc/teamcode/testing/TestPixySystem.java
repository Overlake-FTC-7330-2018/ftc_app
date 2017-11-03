package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.pixycam.PixyCam;

/**
 * Created by lexis on 23-Oct-17.
 */

@Autonomous(name="TextPixySystem", group="Bot")
public class TestPixySystem extends LinearOpMode {

    private PixyCam pixyCam;
    //private PixyCam pixyCam2;

    private double rightServoCenter;
    private PixyCam.Block leftRedBlock;
    private PixyCam.Block leftBlueBlock;
    //private PixyCam.Block rightRedBlock;
    //private PixyCam.Block rightBlueBlock;

    //Servo rightVertServo;
    Servo leftVertServo;
    //Servo rightHorizServo;
    Servo leftHorizServo;
    boolean teamColorIsBlue;

    @Override
    public void runOpMode() {
        pixyCam = hardwareMap.get(PixyCam.class, "pixycam");
        //pixyCam2 = hardwareMap.get(PixyCam.class, "pixycam2");

        this.teamColorIsBlue = true;

        //this.rightVertServo = hardwareMap.servo.get("rightvertservo");
        this.leftVertServo = hardwareMap.servo.get("leftvertservo");
        //this.rightHorizServo = hardwareMap.servo.get("righthorizservo");
        this.leftHorizServo = hardwareMap.servo.get("lefthorizservo");
        this.rightServoCenter = 0.4;
        waitForStart();

        if (teamColorIsBlue == true) {
            this.leftRedBlock = pixyCam.GetBiggestBlock(1);
            this.leftBlueBlock = pixyCam.GetBiggestBlock(2);
            telemetry.addData("Red:", leftRedBlock.toString());
            telemetry.addData("Blue:", leftBlueBlock.toString());
            telemetry.update();
            sleep(1000);
            leftVertServo.setPosition(0.8);
            sleep(1000);
            if (leftRedBlock.x < leftBlueBlock.x) {  // if red is further left than blue
                leftHorizServo.setPosition(0.7); // then move the servo left
                sleep(1000);
                leftHorizServo.setPosition(0.5);
            } else {
                leftHorizServo.setPosition(0.3);
                sleep(1000);
                leftHorizServo.setPosition(0.5); // move the servo right -- also, if no values are found for x, it will go right
            }
            sleep(1000);
            leftVertServo.setPosition(0);
            sleep(1000);
        } else { /*
            //this.rightRedBlock = pixyCam2.GetBiggestBlock(1);
            //this.rightBlueBlock = pixyCam2.GetBiggestBlock(2);
            //telemetry.addData("Red:", rightRedBlock.toString());
            //telemetry.addData("Blue:", rightBlueBlock.toString());
            //telemetry.update();
            sleep(1000);
            rightVertServo.setPosition(0);
            sleep(1000);
            if (leftRedBlock.x < leftBlueBlock.x 1 < 2) {  // if red is further left than blue
                rightHorizServo.setPosition(0.7); // then move the servo left
                sleep(1000);
                rightHorizServo.setPosition(rightServoCenter);
            } else {
                rightHorizServo.setPosition(0.3);
                sleep(1000);
                rightHorizServo.setPosition(rightServoCenter); // move the servo right -- also, if no values are found for x, it will go right
            }
            sleep(1000);
            rightVertServo.setPosition(0.8);
            sleep(1000); */
        }
        while (!isStopRequested())
        {

        }
    }

}
