package com.example.demo.Models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Degree {

    @NotNull
    private String title;

    @NotNull
    private String field;

    @Size(min = 4, max = 4)
    private String graduationYear;
}
