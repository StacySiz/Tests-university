package com.stacysiz.testCases;

import static org.junit.Assert.assertEquals;

import com.stacysiz.helpers.TestBase;
import org.junit.Test;


public class MainCalculusTests extends TestBase {

	@Test
	public void SumTest() throws InterruptedException {
	    int a = 8;
	    int b = 5;
        int actualResult = applicationManager.getCalculusHelper().makeSum(a,b);
        int expectedResult = a + b;
        assert actualResult == expectedResult;
	}

    @Test
    public void SubTest() throws InterruptedException {
        int a = 5;
        int b = 1;
        int actualResult = applicationManager.getCalculusHelper().makeSubtraction( a,b);
        int expectedResult = a - b;
        assert actualResult == expectedResult;
    }

    @Test
    public void deleteSingleValueTest() throws InterruptedException {
        int a = 1;
        int b = 2;
        int c = 3;
        int actualResult = applicationManager.getCalculusHelper().makeDeleteValueCheck(a,b,c);
        String expecteedResult = String.valueOf(a) + String.valueOf(b);
        assert String.valueOf(actualResult).equals(expecteedResult);
    }
}
