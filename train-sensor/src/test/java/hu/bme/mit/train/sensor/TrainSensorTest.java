package hu.bme.mit.train.sensor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;



public class TrainSensorTest {
	
	
	public TrainSensorImpl TSI;
	public TrainUser mockTU;
	public TrainController mockTC;

    @Before
    public void before() {
    	mockTU = mock(TrainUser.class);
    	mockTC = mock(TrainController.class);
    	TSI = new TrainSensorImpl(mockTC, mockTU);
    }
    
    
    
    @Test
    public void CorrectValue() {
        TSI.overrideSpeedLimit(200);
        assertEquals(false, mockTU.getAlarmState());
    }
    @Test
    public void AbsolutelySlow() {
        TSI.overrideSpeedLimit(-1);
        verify(mockTU, times(1)).setAlarmState(true);
    }
    @Test
    public void AbsolutelyFast() {
        TSI.overrideSpeedLimit(600);
        verify(mockTU, times(1)).setAlarmState(true);
    }
    @Test
    public void RelativelySlow() {
        TSI.overrideSpeedLimit(400);
        TSI.overrideSpeedLimit(50);
        verify(mockTU, times(1)).setAlarmState(true);
    }
    
}
