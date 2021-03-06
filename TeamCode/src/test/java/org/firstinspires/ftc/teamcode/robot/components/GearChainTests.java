package org.firstinspires.ftc.teamcode.robot.components;

import org.firstinspires.ftc.teamcode.hardware.dcmotors.MotorType;
import org.junit.Test;

import static org.junit.Assert.*;

public class GearChainTests
{
    private static final double[] GearChainTeeth = new double[] { 25, 50 };
    private static final int ExpectedGearChainRatioWithOtherGears = 2;
    private static final int ExpectedGearChainRatioWithOutAnyOtherGears = 1;
    private static final int ExpectedOutputTicks = 200;
    private static final int ExpectedOutputRevolutionTicks = 50;
    private static final int ExpectedInputRevolutionTicks = 50;

    @Test
    public void GearChain_CalculateGearChainRatioWithOtherGears_Return2()
    {
        GearChain chain = new GearChain(MotorType.TEST, GearChainTeeth);
        double ratio = chain.getChainRatio();
        assertTrue(ratio == ExpectedGearChainRatioWithOtherGears);
    }

    @Test
    public void GearChain_CalculateGearChainRatioWithOutAnyOtherGears_Return1()
    {
        GearChain chain = new GearChain(MotorType.TEST);
        double ratio = chain.getChainRatio();
        assertTrue(ratio == ExpectedGearChainRatioWithOutAnyOtherGears);
    }

    @Test
    public void GearChain_CalculateOutputTicks_Return200() {
        GearChain chain = new GearChain(MotorType.TEST, GearChainTeeth);
        int ticks = chain.calculateOuputTicks(100);
        assertTrue(ticks == ExpectedOutputTicks);
    }

    @Test
    public void GearChain_CalculateOutputRevolutionTicks_Return50()
    {
        GearChain chain = new GearChain(MotorType.TEST, GearChainTeeth);
        int outputRevolutionTicks = chain.calculateOutputRevolutionTicks(25);
        assertTrue(outputRevolutionTicks == ExpectedOutputRevolutionTicks);
    }

    @Test
    public void GearChain_CalculateInputRevolutionTicks_Return50()
    {
        GearChain chain = new GearChain(MotorType.TEST, GearChainTeeth);
        int inputRevolutionTicks = chain.calculateInputRevolutionTicks(50);
        assertTrue(inputRevolutionTicks == ExpectedInputRevolutionTicks);
    }
}