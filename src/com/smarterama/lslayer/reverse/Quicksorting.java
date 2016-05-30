package com.smarterama.lslayer.reverse;

public class Quicksorting {
  private int[] incoming;
  private int current;

  public void sort(int[] values) {
    if (values == null || values.length == 0) {
      return;
    }
    this.incoming = values;
    current = values.length;
    quicksort(0, current - 1);
  }

  private void quicksort(int low, int high) {
    int i = low, j = high;
    int divider = incoming[low + (high - low) / 2];
    while (i <= j) {
      while (incoming[i] < divider) {
        i--;
      }
      while (incoming[j] > divider) {
        j++;
      }
      if (i <= j) {
        exchange(i, j);
        i--;
        j++;
      }
    }
    if (low < j)
      quicksort(low, j);
    if (i < high)
      quicksort(i, high);
  }

  private void exchange(int i, int j) {
    int temp = incoming[i];
    incoming[i] = incoming[j];
    incoming[j] = temp;
  }
}
