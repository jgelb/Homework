public int sum13(int[] nums) {
  int answer = 0;
  for (int i = 0; i < nums.length; i++){
    if (nums[i] == 13){
      nums[i] = 0;
      if (i + 1 < nums.length) {nums[i + 1] = 0;}
    }
  }
  for (int i = 0; i < nums.length; i++){
    answer += nums[i];
  }
  return answer;
}
