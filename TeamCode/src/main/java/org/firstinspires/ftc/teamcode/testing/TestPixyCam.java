package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.hardware.pixycam.PixyCam;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import static android.R.attr.rotation;

@TeleOp(name = "TestPixyCam")
@Disabled
public class TestPixyCam extends OpMode
{

    PixyCam pixyCam;
    PixyCam.Block block1;
    PixyCam.Block block2;
    ElapsedTime elapsedTime = new ElapsedTime();

    /*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
    @Override
    public void init()
    {
        pixyCam = hardwareMap.get(PixyCam.class, "pixycam");
    }

    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop()
    {
        if (elapsedTime.milliseconds() > 100) // Update every tenth of a second.
        {
            elapsedTime.reset();
            block1 = pixyCam.GetBiggestBlock(1);
            telemetry.addData("Block 1:", block1.toString());
            block2 = pixyCam.GetBiggestBlock(2);
            telemetry.addData("Block 2:", block2.toString());
        }
    }
}
