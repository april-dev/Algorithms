public int numSubmat(int[][] mat) {
        
	int M = mat.length, N = mat[0].length;

	int res = 0;
	for (int up = 0; up < M; ++up) {
		int[] h = new int[N];
		Arrays.fill(h, 1);
		for (int down = up; down < M; ++down) {
			for (int k = 0; k < N; ++k) h[k] &= mat[down][k];
			res += countOneRow(h);
		}
	}

	return res;
}

private int countOneRow(int[] A) {

	int res = 0, length = 0;
	for (int i = 0; i < A.length; ++i) {
		length = (A[i] == 0 ? 0 : length + 1);
		res += length;
	}
	return res;
}
