public int[] tenRun(int[] nums) {
  int currTen = -1;
  for (int i = 0; i < nums.length; i++){
    if (currTen == -1) {
      if (nums[i] % 10 == 0) {
        currTen = nums[i];
      }
    }
    else {
      if (nums[i] % 10 == 0) {
        currTen = nums[i];
      }
      else {
        nums[i] = currTen;
      }
    }
  }
  return nums;
}
