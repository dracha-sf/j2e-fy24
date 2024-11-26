package graphsassignmentquestions;
import java.util.*;
public class Problem9 
{
    static long dp[] = new long[10006];
	static long mod = (long)1e9 + 7;

	/* function which returns the number
	of ways to reach from source to destination */
	public static long countPaths(List<List<Long>> arr, long s, long d) 
        {
		/*
				if we are already at the
				destination we have found 1 valid
				path
		*/
		if (s == d)
			return 1;
		/*
				if we have already computed the
				number of ways to reach the destination
				via this vertex return the answer
		*/
		if (dp[(int)s] != -1)
			return dp[(int)s];

		long c = 0;
		for (long neigh : arr.get((int)s)) 
                {
			/*
					since the number of ways to reach the
			destination from the current vertex depends on
			the number of ways the neighbours can reach the
			destination so get all the possible ways that the
			neighbours can reach the destination
			*/
			long x = countPaths(arr, neigh, d);

			// if we reached the destination than add it to the
			// result
			if (x != -1) {
				c = (c % mod + x % mod) % mod;
			}
		}
		/*
				if c is equal to zero that means there are no
		paths from the current vertex to the destination so
		return -1 to indicate there is no path or else store
		the c and return it
		*/
		return (dp[(int)s] = (c == 0) ? -1 : c);
	}
	public static long Possible_Paths(List<List<Long>> arr, long n,long s, long d) {
		// initialise the dp array with -1
		// to indicate we haven't computed
		// the answer for any vertex
		Arrays.fill(dp, -1);

		long c = countPaths(arr, s, d);

		// if there are no paths return 0
		if (c == -1)
			return 0;

		// else return c
		return c;
	}
	public static void main(String[] args) 
        {
		long n, m, s, d;
		n = 4;
		m = 5;
		s = 0;
		d = 3;
		List<List<Long>> arr = new ArrayList<>();
		for (int i = 0; i <= n; i++) 
                {
			arr.add(new ArrayList<>());
		}
		arr.get(0).add(1l);
		arr.get(0).add(2l);
		arr.get(1).add(2l);
		arr.get(1).add(3l);
		arr.get(2).add(3l);

		System.out.println(Possible_Paths(arr, n, s, d));
	}
}
