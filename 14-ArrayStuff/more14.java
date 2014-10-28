public boolean more14(int[] nums) {
  int numones = 0;
  int numfours = 0;
  for (int i = 0; i < nums.length; i++){
    if (nums[i] == 1) {numones++;}
    if (nums[i] == 4) {numfours++;}
  }
  return (numones > numfours);
}
