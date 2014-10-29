public boolean tripleUp(int[] nums) {
  boolean val = false;
  int i = 0;
  while (i < nums.length - 2){
      if (nums[i] + 1 ==  nums[i + 1] && nums[i + 1] + 1 == nums[ i + 2]){
          val = true;}
      i += 1;
  }
  return val;
}


public int[] tenRun(int[] nums) {
  int i = 0;
  int in = 0;
  int[] array  = new int[nums.length];
  while (i < nums.length){
      if (i == nums.length - 2 && nums[i] % 10 == 0) array[i + 1] = nums[i];
      if (nums[i] % 10 == 0 && i != nums.length - 1){
          array[i] = nums[i];
          in = i + 1;
          
          while (nums[in] % 10 != 0 && in < nums.length - 1){
              array[in] = nums[i];
              in += 1;
          }
          i = in;
      }
      else {
          array[i] = nums[i];
          i += 1;
      }
  }
  return array;
        
}

public boolean more14(int[] nums) {
  int one = 0;
  int four =0;
  int i = 0;
  while (i < nums.length){
      if (nums[i] == 1) one += 1;
      else if (nums[i]== 4) four += 1;
      else;
      i += 1;
  }
  if (one > four) return true;
  else return false;
   
}

 boolean split = false;
  int i = 0;
  int suml = 0;
  int sumr = 0;
  int xl = 0;
  int xr = 0;
 
  while (i < nums.length){
     while (xl < i){
        suml += nums[xl];
        xl += 1;
     }
     xl = 0;
     xr = i;
     while (xr < nums.length){
         sumr += nums[xr];
         xr += 1;
     }
     i += 1;
     if (suml == sumr) split = true;
     
     
     suml = 0;
     sumr = 0;
     
  }
  return split;     
}

public int[] seriesUp(int n) {
  int[] array = new int[n*(n +1)/2];
  int i = 1;
  int k = 0;
  while (i < n + 1){
     while (k < i){
        array[k] = k + 1;
        k += 1;
     }
     k = 0;
     i += 1;
  }
  return array;
}

public int sum67(int[] nums) {
  boolean six = false;
  int i = 0;
  int sum = 0;
  while (i < nums.length){
     if (nums[i] == 6) six = true;
     while (six == true){
        
        if (nums[i] == 7) six = false;
        i += 1;
     }
     if (i < nums.length){
     sum += nums[i];}
     
     i += 1;}
  return sum;
     
}
