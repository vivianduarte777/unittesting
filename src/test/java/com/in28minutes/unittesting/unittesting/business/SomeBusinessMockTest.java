package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//Slide 11
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;// = new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock;// = mock(SomeDataService.class);


  /*  @BeforeEach
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }*/

    @Test
    public void calculateSumUsingdataService_basic(){
       when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
       assertEquals(6,business.calculateSumDataService());
     }

   @Test
    public void calculateSumUsingDataService_empty(){
      when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
      assertEquals(0, business.calculateSumDataService());

   }

    @Test
    public void calculateSumUsingDataService_OneElement(){
       when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
       assertEquals(5, business.calculateSumDataService());

    }

    //Parei no slide 13 - Ficar alerta ao slide 12 que explica sobre estar usando JUnit4 ou JUnit5



}
