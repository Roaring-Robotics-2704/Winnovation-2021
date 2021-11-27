package frc.robot.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test; 

public class testInput {
    
    final double deadzone_size = 0.05;
    final double scaling = 2;

    final double table_length = 20000; //at 20,000 , should only take a few hundred k of ram
    final double test_precision = 1/1000;
    
    processInput input_processor = processInput(deadzone_size,scaling);

    @Test
    public void test1(){
        double[][] values = new double[table_length][2];
        
        int iteration = 0;
        for(double i = -1; i <= 1; i = i + 2/table_length){ //create i/o table for use in assertions
            values[iteration]={i,input_processor.processInput(i)};
            iteration++;
        }
        
        double smallest_positive = 1;
        double smallest_negative = -1;

        for(int i = 0; i<table_length; i++){ //iterate through outputs and run a series of tests
            input = values[i][0];
            output = values[i][1];

            if(0<output<smallest_positive){
                smallest_positive = output;
            }
            else if(0>output>smallest_negative){
                smallest_negative = output;
            }

            if (input - deadzone_size > test_precision){ //if input outside of deadzone, check that sign is still correct
                assertTrue(output>0);
            }
            else if (input + deadzone_size < -test_precision){
                assertTrue(output<0)
            }
            else if(abs(input)+test_precision < deadzone_size){//if within deadzone, output should be 0
                assertTrue(abs(output) < test_precision);
            }

            if(abs(input > 1-test_precision){//max input should equal max output
                assertTrue(abs(output) > 1-test_precision);
            }
        }

        //check that output goes all the way down to zero
        assertTrue(smallest_positive < test_precision);
        assertTrue(smallest_negative > -test_precision);
    }

    @Test
    public void test2(){//makes sure scaling is different close to 
        double closeDifference = abs(input_processor.processInput(deadzone_size+0.1) - input_processor.processInput(deadzone_size+0.2));
        double farDifference = abs(input_processor.processInput(input_processor.processInput(1) - input_processor.processInput(0.9); 
        assertTrue(closeDifference < farDifference;

        closeDifference = abs(input_processor.processInput(-deadzone_size-0.1) - input_processor.processInput(-deadzone_size-0.2));
        farDifference = abs(input_processor.processInput(input_processor.processInput(-1) - input_processor.processInput(-0.9); 
        assertTrue(closeDifference < farDifference;
        )
    }
}
