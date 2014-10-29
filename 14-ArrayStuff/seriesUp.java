public int[] seriesUp(int n) {
  int[] teamsolomid = new int[n * (n + 1) / 2];
  int tsmbjergsen = 0;
  for (int i = 0; i < n + 1; i++){
    for (int k = i; k > 0; k--) {
      teamsolomid[tsmbjergsen] = i - k + 1;
      tsmbjergsen++;
    }
  }
  return teamsolomid;
}
