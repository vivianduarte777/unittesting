package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}
class SomeDataServiceEmptyStub implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneElementStub implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}
public class SomeBusinessStubTest {
    @Test
    public void calculateSumUsingdataService_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumDataService();
        int expectedResult = 6;

        assertEquals(expectedResult,actualResult);

    }

   @Test
    public void calculateSumUsingDataService_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());

        int actualResult = business.calculateSumDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateSumUsingDataService_OneElement(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneElementStub());

        int actualResult = business.calculateSumDataService();
        int expectedResult = 5;
        assertEquals(expectedResult,actualResult);
    }
}
