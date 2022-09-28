package com.restapi.restapi1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Restapi1ApplicationTests {

    Calculator c= new Calculator();
    @Test
    void testSum(){
        //expected result
        int expectedResult=20;
        // actual
        int actualResult= c.doSum(12,5,3);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    void testProduct(){
        //expected
        int expectedResult=12;
        //actual
        int actualResult=c.doProduct(4,3);
        assertThat(actualResult).isEqualTo(expectedResult);

    }



}
