public boolean canBalance(int[] nums) {
  for (int i = 0; i < nums.length; i++){
    int sideA = 0;
    int sideB = 0;
    int j = 0;
    for (j = 0; j < i + 1; j++){
      sideA += nums[j];
    }
    for (j = j; j < nums.length; j++){
      sideB += nums[j];
    }
    if (sideA == sideB){ return true;}
  }
  return false;
}
