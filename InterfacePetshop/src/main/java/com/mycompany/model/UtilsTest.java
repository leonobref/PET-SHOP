package com.mycompany.model;

import com.mycompany.model.Utils;
import java.util.ArrayList;
import java.util.List;

public class UtilsTest {
    public static void main(String[] args) {
        Utils utils = new Utils();
        //utils.verifyExistenceDate();

        System.out.println(Utils.findDataFile());
    }
}
