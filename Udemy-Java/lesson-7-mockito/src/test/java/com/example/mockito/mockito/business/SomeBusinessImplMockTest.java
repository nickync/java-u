package com.example.mockito.mockito.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataService;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findTheGreatestFromAllDataTest1() {
//        DataService dataService = mock(DataService.class);
//        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataService);
        when(dataService.retrieveAllData()).thenReturn(new int[]{25,15,5});
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(25, result);
    }
}

