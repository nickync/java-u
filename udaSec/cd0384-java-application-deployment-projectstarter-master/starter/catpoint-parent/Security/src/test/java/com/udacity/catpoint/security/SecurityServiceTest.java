package com.udacity.catpoint.security;

import com.udacity.catpoint.imageService.FakeImageService;
import com.udacity.catpoint.security.data.ArmingStatus;
import com.udacity.catpoint.security.data.SecurityRepository;
import com.udacity.catpoint.security.securityService.SecurityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {

    private SecurityService securityService;

    @Mock
    SecurityRepository securityRepository;

    @Mock
    FakeImageService fakeImageService;

    @BeforeEach
    void init() {
        securityService = new SecurityService(securityRepository, fakeImageService);
    }

    @Test
    void sensorActivated_alarmArmedAndStatusPending_alarmStatusAlarm(){
        when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);
    }


}
