package io.github.xesam.lang;

import org.mockito.MockedStatic;

import java.time.LocalTime;

import static org.mockito.Mockito.mockStatic;

public class TimeTest {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(12, 12, 12, 0);
        MockedStatic<LocalTime> theMock = mockStatic(LocalTime.class);
        theMock.when(LocalTime::now).thenReturn(time);
        System.out.println(LocalTime.now());
    }
}
