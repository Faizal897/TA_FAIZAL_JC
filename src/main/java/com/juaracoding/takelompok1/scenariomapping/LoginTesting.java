package com.juaracoding.takelompok1.scenariomapping;


public enum LoginTesting {

    T1("PTA001 Valid Login Username"),
    T2("Pta002 Empty Login"),
    T3("Pta003 Password Salah"),
    T4("Pta004 Username Salah");
//    T3("Pta003 Password Salah"),
//    T4("Pta004 Username Salah"),
//    T5("Pta005 Username Dan Password Salah");

    private String testName;

    private LoginTesting(String value) {
        testName = value;
    }

    public String getTestName() {
        return testName;
    }
}