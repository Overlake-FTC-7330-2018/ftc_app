package org.firstinspires.ftc.teamcode.teleop;

/**
 * Created by EvanCoulson on 9/26/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.config.ConfigParser;

@Disabled
@TeleOp(name = "TeleOpConfig", group = "TeleOp")

public class TeleopConfig extends OpMode
{

    private ConfigParser c;

    public void init()
    {
        c = new ConfigParser("test.omc");
        int j = c.getInt("int");
        telemetry.addData("int", c.getInt("int"));
        telemetry.update();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        c.updateKey("int", "5");
    }

    public void loop()
    {

    }
}
