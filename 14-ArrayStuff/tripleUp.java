public boolean tripleUp(int[] nums) {
  int counter = 1;
  for (int i = 0; i < nums.length; i++) {
    if (counter >= 3){ return true;}
    else {
      if (i != 0) {
        if (nums[i] - nums[i - 1] == 1) {
          counter++;
          if (counter >= 3) {return true;}
        }
        else { counter = 1;}
      }
    }
  }
  return (counter >= 3);
}

