package com.student.management.constants;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Application constants.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApplicationConstants {

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_TEST = "test";

}