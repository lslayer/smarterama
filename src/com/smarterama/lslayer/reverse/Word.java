package com.smarterama.lslayer.reverse;

import java.util.HashMap;
import java.util.Map;

public class Word {
  
  private String wordWithLettersOnly;
  private Map<Integer,Character> nonLetters = new HashMap<Integer, Character>();

  public Word(String word) {
    removeNonLettersFromSentence(word);
  }
  
  public String reverse() {
    return mergeLettersWithSymbols(reverseWord(), nonLetters);
  }
  
  public String getOriginalWord() {
    return mergeLettersWithSymbols(wordWithLettersOnly, nonLetters);
  }
  
  private void removeNonLettersFromSentence(String sentence) {
    StringBuilder wordWithLettersOnly = new StringBuilder();
    int currentPosition = 0;
    for (char currentChar : sentence.toCharArray()) {
      if (Character.isLetter(currentChar)) {
        wordWithLettersOnly.append(currentChar);
      } else {
        this.nonLetters.put(currentPosition, currentChar);
      }
      currentPosition++;  
    }
    this.wordWithLettersOnly = wordWithLettersOnly.toString(); 
  }
  
  private String reverseWord() {
    return new StringBuilder(wordWithLettersOnly).reverse().toString();
  }
  
  private String mergeLettersWithSymbols(String letters, Map<Integer, Character> symbols) {
    StringBuilder result = new StringBuilder(letters);
    for (Map.Entry<Integer, Character> entry : nonLetters.entrySet()) {
      int position = entry.getKey();
      Character symbol = entry.getValue();
      result.insert(position,symbol);
    }
    return result.toString();
  }

}
