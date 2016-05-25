package com.smarterama.lslayer.reverse;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
  
  private List<Word> words = new ArrayList<Word>();
  
  public Sentence (String sentence) {
    for (String currentWord : sentence.split(" ")) {
      this.words.add(new Word(currentWord));
    }
  }

  public String reverseWords() {
    StringBuilder result = new StringBuilder();
    for (Word currentWord : words) {
      result.append(currentWord.reverse());
      result.append(" ");
    }
    return result.toString().trim();
  }
}
