package com.subrata.poc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
    @Mock
    User userMock;
    @Mock
    User.UserBuilder mockBuilder;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getFirstNameNoMock() {
        User user = new User.UserBuilder("subrata","rimpa").age(12).build();
        assertEquals(user.getAge(),12);
    }
    @Test
    public void getFirstNameWithMock() {
        when(mockBuilder.build()).thenReturn(userMock);
        when(userMock.getAge()).thenReturn(12);
        assertEquals(mockBuilder.build().getAge(),12);
    }
}