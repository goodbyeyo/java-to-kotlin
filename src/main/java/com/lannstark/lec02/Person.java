package com.lannstark.lec02;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@RequiredArgsConstructor
public class Person {

  @Nullable
  private String name;

  @Nullable
  private String email;

//  public Person(String name) {
//    this.name = name;
//  }
//  @NotNull
//  public String getName() {
//    return name;
//  }



}


