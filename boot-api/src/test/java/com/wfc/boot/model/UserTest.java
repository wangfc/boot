package com.wfc.boot.model;

import org.junit.Test;

public class UserTest {

    @Test
    public void test(){
        User user = new User();
        user.setId(   2 );
        System.out.println(user);
    }
}