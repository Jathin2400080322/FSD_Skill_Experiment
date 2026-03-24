package com.klu.beans;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 301;
    private String course = "Spring Core";
    private String dateOfCompletion = "25-Jan-2026";

    @Override
    public String toString() {
        return "Course [id=" + id +
               ", course=" + course +
               ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}
