package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.hardware.controller.Controller;
import org.firstinspires.ftc.teamcode.robot.systems.physical.ClawSystemNoMergeConflictPlease;
import org.firstinspires.ftc.teamcode.robot.systems.physical.ElevatorSystem;
import org.firstinspires.ftc.teamcode.robot.systems.physical.MecanumDriveSystem;
import org.firstinspires.ftc.teamcode.robot.systems.physical.ParallelLiftSystem;
import org.firstinspires.ftc.teamcode.config.ConfigParser;
import org.firstinspires.ftc.teamcode.logger.Logger;
import org.firstinspires.ftc.teamcode.logger.LoggingService;

/**
 * Created by EvanCoulson on 10/11/17.
 */

public abstract class BaseOpMode extends OpMode
{
    protected final ConfigParser config;
    protected Controller controller1;
    protected Controller controller2;
    protected MecanumDriveSystem driveSystem;
    protected ParallelLiftSystem liftSystem;
    protected ClawSystemNoMergeConflictPlease claw;
    protected ElevatorSystem elevator;
    protected Logger logger;


    public BaseOpMode(String opModeName)
    {
        this.logger = new Logger(this, opModeName);
        logger.setLoggingServices(LoggingService.FILE);
        this.config = new ConfigParser(opModeName + ".omc");
    }

    public void initBaseSystems()
    {
        this.controller1 = new Controller(gamepad1);
        this.controller2 = new Controller(gamepad2);
        this.driveSystem = new MecanumDriveSystem(this);

        this.liftSystem = new ParallelLiftSystem(this);
        this.claw = new ClawSystemNoMergeConflictPlease(this);
        this.elevator = new ElevatorSystem(this);
        initButtons();
    }

    public abstract void initButtons();
}
