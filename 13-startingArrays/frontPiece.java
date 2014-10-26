public int[] frontPiece(int[] nums) {
  if (nums.length <= 2) {return nums;}
  else {
    int[] ans;
    ans = new int[2];
    ans[0] = nums[0];
    ans[1] = nums[1];
    return ans;
  }
}

