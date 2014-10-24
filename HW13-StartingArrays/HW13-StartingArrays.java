public int[] frontPiece(int[] nums) {
   int x = 0;
   if (nums.length > 2) x = 2;
   else x = nums.length;
   int[] array = new int[x];
   
   int i = 0;
   
   while (i < 2 && i < nums.length){
       array[i] = nums[i];
       i += 1;
       }
  
   return array;
}

public int sum13(int[] nums) {
  int x = nums.length;
  int i = 0;
  int sum = 0;
  while (i < x){
      if (nums[i] != 13) sum += nums[i]; i += 1;
      
      }
  return sum;
}
