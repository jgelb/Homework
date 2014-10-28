public int sum67(int[] nums) {
  boolean hitSix = false;
  int answer = 0;
  for (int i = 0; i < nums.length; i++) {
    if (nums[i] == 7 && hitSix) {hitSix = false; answer -= 7;}
    if (nums[i] == 6 && !hitSix) {hitSix = true;}
    if (!hitSix){answer += nums[i];}
  }
  return answer;
}

