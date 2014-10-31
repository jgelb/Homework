public int maxMirror(int[] nums) {
  int s = 0;
  int i = 0;
  
  while (i < nums.length){
      int[] temp = new int[i];
      while (s < i){
           temp[s] = nums[s];
           s += 1;
      }
      s = 0;
      int[] rev = new int[i];
      rev = temp.reverse();
      if (nums.contains(rev)) return rev.length; break;
  }
  return 0;
      
      
      
}

public int[] reverse(int[] x){
    int[] done = new int[x.length];
    int i = x.length - 1;
    int z = 0;
    while (i >= 0){
        done[z] = x[i];
        i -= 1;
        z += 1;
    }
    return done;
}