package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 27;
        double height = 174.5;
        float weight = 65.2f;
        byte size = 48;
        short mortgage = -31000;
        long salary = 140000L;
        char gender = 'M';
        boolean married = true;
        LOG.debug("User info: age {}, height {}, weight {}, "
                + "size {}, mortgage {}, salary {}, gender {}, married {}",
                 age, height, weight, size, mortgage, salary, gender, married);
    }
}