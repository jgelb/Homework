public int maxMirror(int[] nums) {
  //Build array backwards
  int[] back = new int[nums.length];
  int counter = 0;
  for (int i = 0; i < nums.length; i++){
    back[i] = nums[nums.length - 1 - i];
  }

  //Slide and match
  for (int i = 0; i < nums.length; i++){
    int tick = 0;
    for (int k = 0; k < i + 1; k++){
      if (nums[k] == back[back.length - i + k - 1]){
        tick++;
        if (tick > counter) {counter = tick;}
      }
      else{
        tick = 0;
      }
    }
  }
  for (int i = 0; i < back.length; i++){
    int tick = 0;
    for (int k = 0; k < i + 1; k++){
      if (back[k] == nums[nums.length - i + k - 1]){
        tick++;
        if (tick > counter) {counter = tick;}
      }
      else{
        tick = 0;
      }
    }
  }
  return counter;
}
