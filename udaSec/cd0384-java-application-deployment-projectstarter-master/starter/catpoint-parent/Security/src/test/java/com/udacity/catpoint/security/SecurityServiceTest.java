package com.udacity.catpoint.security;

import com.udacity.catpoint.imageService.FakeImageService;
import com.udacity.catpoint.security.data.*;
import com.udacity.catpoint.security.securityService.SecurityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {

    private SecurityService securityService;

    private Sensor sensor;

    private final String uuid = UUID.randomUUID().toString();

    private Sensor getSensor(){
        return new Sensor(uuid, SensorType.DOOR);
    }

    @Mock
    SecurityRepository securityRepository;

    @Mock
    FakeImageService fakeImageService;

    @BeforeEach
    void init() {
        securityService = new SecurityService(securityRepository, fakeImageService);
        sensor = getSensor();
    }

    @Test
    void sensorActivated_alarmArmed_alarmStatusPending(){
        when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.NO_ALARM);
        securityService.changeSensorActivationStatus(sensor, true);

        verify(securityRepository,times(1)).setAlarmStatus(AlarmStatus.PENDING_ALARM);
    }

    @Test
    void sensorActivated_alarmArmedAndStatusPending_alarmStatusAlarm(){
        when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.PENDING_ALARM);
        securityService.changeSensorActivationStatus(sensor, true);

        verify(securityRepository, times(1)).setAlarmStatus(AlarmStatus.ALARM);
    }

    @Test
    void sensorInactivated_alarmPending_alarmStatusNone(){
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.PENDING_ALARM);
        sensor.setActive(false);
        securityService.changeSensorActivationStatus(sensor);

        verify(securityRepository, times(1)).setAlarmStatus(AlarmStatus.NO_ALARM);
    }
}
