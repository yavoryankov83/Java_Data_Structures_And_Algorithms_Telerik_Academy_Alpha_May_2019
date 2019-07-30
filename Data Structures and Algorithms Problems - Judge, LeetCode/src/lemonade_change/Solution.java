package lemonade_change;

import java.util.List;

class Solution {
  private static final int FIVE_DOLLAR = 5;
  private static final int TEN_DOLLAR = 10;

  boolean lemonadeChange(List<Integer> bills) {
    int countOfFiveDollars = 0;
    int countOfTenDollars = 0;

    for (int bill : bills) {
      if (bill == FIVE_DOLLAR)
        countOfFiveDollars++;
      else if (bill == TEN_DOLLAR) {
        if (countOfFiveDollars == 0) {
          return false;
        }
        countOfFiveDollars--;
        countOfTenDollars++;
      } else {
        if (countOfFiveDollars > 0 && countOfTenDollars > 0) {
          countOfFiveDollars--;
          countOfTenDollars--;
        } else if (countOfFiveDollars >= 3) {
          countOfFiveDollars -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
