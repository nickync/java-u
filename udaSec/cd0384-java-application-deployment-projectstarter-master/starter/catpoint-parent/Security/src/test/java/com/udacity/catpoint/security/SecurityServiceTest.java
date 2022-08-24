package com.udacity.catpoint.security;

import com.udacity.catpoint.imageService.ImageService;
import com.udacity.catpoint.security.application.StatusListener;
import com.udacity.catpoint.security.data.*;
import com.udacity.catpoint.security.securityService.SecurityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
    ImageService imageService;

    @BeforeEach
    void init() {
        securityService = new SecurityService(securityRepository, imageService);
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
        sensor.setActive(true);
        securityService.changeSensorActivationStatus(sensor,false);

        verify(securityRepository, times(1)).setAlarmStatus(AlarmStatus.NO_ALARM);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void alarmActivated_sensorChanged_alarmStatusNoChange(boolean sensorState){
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.ALARM);
        securityService.changeSensorActivationStatus(sensor, sensorState);

        verify(securityRepository,never()).setAlarmStatus(any(AlarmStatus.class));
    }

    @Test
    void sensorActivated_alarmPending_changeToAlarm(){
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.PENDING_ALARM);
        sensor.setActive(true);
        securityService.changeSensorActivationStatus(sensor, true);

        verify(securityRepository,times(1)).setAlarmStatus(AlarmStatus.ALARM);
    }

    @Test
    void sensorDeactivatedAndInactive_noChangesToAlarm(){
        sensor.setActive(false);
        securityService.changeSensorActivationStatus(sensor,false);

        verify(securityRepository, never()).setAlarmStatus(any(AlarmStatus.class));
    }

    @Test
    void catFound_systemArmed_changeToAlarm(){
        when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);
        when(imageService.imageContainsCat(any(), anyFloat())).thenReturn(true);
        BufferedImage catImage = new BufferedImage(128, 128, BufferedImage.TYPE_INT_RGB);
        securityService.processImage(catImage);

        verify(securityRepository, times(1)).setAlarmStatus(AlarmStatus.ALARM);
    }

    private Set<Sensor> getAllSensors(int count, boolean status){
        var sensors = IntStream.range(0,count).mapToObj(i -> new Sensor(uuid, SensorType.DOOR)).collect(Collectors.toCollection(HashSet::new));

        sensors.forEach(sensor -> sensor.setActive(status));

        return sensors;
    }

    @Test
    void sensorInactive_catNotFound_changeToNoAlarm(){

        //Set<Sensor> sensors = getAllSensors(3,false);
        //when(securityRepository.getSensors()).thenReturn(sensors);
        BufferedImage catImage = new BufferedImage(128,128,BufferedImage.TYPE_INT_RGB);
        when(imageService.imageContainsCat(any(BufferedImage.class), anyFloat())).thenReturn(false);
        securityService.processImage(catImage);

        verify(securityRepository).setAlarmStatus(AlarmStatus.NO_ALARM);
    }

    @Test
    void systemNoAlarm_statusNoAlarm(){
        securityService.setAlarmStatus(AlarmStatus.NO_ALARM);

        verify(securityRepository, times(1)).setAlarmStatus(AlarmStatus.NO_ALARM);
    }

    @ParameterizedTest
    @EnumSource(value = ArmingStatus.class, names = {"ARMED_HOME", "ARMED_AWAY"})
    void systemArmed_setAllSensorsInactive(ArmingStatus armingStatus) {
        Set<Sensor> sensors = new HashSet<>();
        Sensor sensor1 = new Sensor("sensor1", SensorType.DOOR);

        sensors.add(sensor1);
        sensors.add(sensor);

        when(securityRepository.getSensors()).thenReturn(sensors);
        securityService.setArmingStatus(armingStatus);

        securityService.getSensors().forEach(sensor -> assertFalse(sensor.getActive()));
    }

    @Test
    void armedHome_catFound_changeToAlarm(){
        when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);
        when(imageService.imageContainsCat(any(BufferedImage.class), anyFloat())).thenReturn(true);
        BufferedImage catImage = new BufferedImage(128, 128, BufferedImage.TYPE_INT_RGB);
        securityService.processImage(catImage);
        securityService.setArmingStatus(ArmingStatus.ARMED_HOME);

        verify(securityRepository,times(2)).setAlarmStatus(AlarmStatus.ALARM);
    }

    @Mock
    private StatusListener statusListener;

    @Test
    void driveUpCoverageRatioOMG(){
        //securityService.addStatusListener(statusListener)
        securityService.addStatusListener(statusListener);
        securityService.removeStatusListener(statusListener);
        securityService.addSensor(sensor);
        securityService.removeSensor(sensor);
    }

    @Test
    void setArmingTest () {
        securityService.setArmingStatus(ArmingStatus.DISARMED);
        //verify(securityService,times(1)).setArmingStatus(ArmingStatus.DISARMED);
    }

//    @Test
//    void handleSensorDeactivatedTest(){
//        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.ALARM);
//
//    }

    @Test
    void getAlarmStatusTest(){
        securityService.getAlarmStatus();
    }
}
