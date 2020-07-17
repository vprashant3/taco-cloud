package com.AlogrithmsAndDataStructures.Datastructures;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = DynamicArray.class)
public class DynamicArrayTest {


    @Test
    void createDynamicArray() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);
        dynamicArray.add(2);
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.get(0));
        System.out.println(dynamicArray.toString());

    }


}
