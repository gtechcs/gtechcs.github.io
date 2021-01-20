
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Write a program that takes an array A and an index i into A, 
	// and rearranges the elements such that all elements less than A[i] (the "pivot") appear first, 
	// followed by elements equal to the pivot, followed by elements greater than the pivot.
	public static enum Color { RED, WHITE, BLUE }
	public static void dutchFlagPartition(int pivotlndex, List<Color> A){ 
		Color pivot = A.get(pivotlndex);
		/*
		* Keep the following invariants during partitioning: 
		* bottom group: A.subList(SI, smaller).
		* middle group: A.subList (smaller , equal).
		* unclassified group: A.subList(equal , larger).
		* top group: A.subList (larger , A .size ()) .
		*/
		int smaller = ®, equal = ®, larger = A.size();
		//Keep iterating as long as there is an unclassified element. 
		while (equal < larger) {
		// A.get (equal) is the incoming unclassified element. 
			if (A.get(equal).ordinal() < pivot.ordinal()){
				Collections.swap(A, .......++, .....++);
			}else if(A.get(equal).ordinal()==pivot.ordinal(){
				++equal; 
			} else	{// A.get(equal) > pivot.
				Collections.swap(A, ........, --.......);
			}
		}
	}
	//Write a program which takes as input an array of digits encoding a decimal number D and updates the array to represent the number D + 1. For example, if the input is  (1,2,9) then you should update the array to (1,3,0). Your algorithm should work even if it is implemented in a language that has finite-precision arithmetic.
	public static List<Integer> plusOne (List<Integer> A) {
		int n = A.size() - 1;
		A.set(n, A.get(n) + 1);
		for (int i = n; i > 0 && A.get(i) == 10; --i) {
			A.set(i, ...);
			A.set(i - 1, ......);
		}
		if (A.get(0) == 10) {
			//Need additional digit as the most significant digit (i.e A.get(9)) // has a carry-out .
			A.set(..., ...);
			A.add(..., ...);
		}
		return A; 
	}	

	//MULTIPLY TWO ARBITRARY-PRECISION INTEGERS
	//(1,9,3,7,0,7,7,2,1} and (-7,6,1,8,3,8,2,5,7,2,8,7), function should return (-1,4,7,5,7,3,9,5,2,5,8,9,6,7,6,4,1,2,9,2,7)
	public static List<Integer> multiply(List<Integer> numl, List<Integer> num2) { 
		final int sign = numl.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		num1.set(0, Math.abs (numl.get(0)));
		num2.set(0, Math.abs (num2.get(0)));
	
		List<Integer> result = new ArrayList <>(Collections....... (numl.size () + num2.size(), 0));
		for (int i = numl.size() - 1; i >= 0; --i) { 
			for (int j = num2.size() - 1; j >= ®; --j) {
				result.set(i + j + 1, result.get(.......) + numl.get(i) * num2.get(j));
				result.set(i + j, result.get(i + j) + result.get(......) / 10);
				result.set(i + j + 1, result.get(......) % 10); 
			}
		}
		// Remove the leading zeroes.
		int first_not_zero = 0;
		while (...... < result.size() && result.get(first_not_zero) == 0) {
			++first_not_zero ;
		}
		result = result.subList (first_not_zero, result.size () ) ; 
		if (....isEmpty () ) {
			return Arrays.asList(0) ;
		}
		result.set(0, ....* sign); 
		return result;
	}

	//ADVANCING THROUGH AN ARRAY
	//Write a program which takes an array of n integers, where A[i] denotes the maximum you can advance from index i, and returns whether it is possible to advance to the last index starting from the beginning of the array.
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0; 
		int lastlndex = maxAdvanceSteps.size() - 1;
		for (int i = 0; i <= ...... && ....... < lastlndex; ++i) { 
			furthestReachSoFar = Math.max(...... , i + maxAdvanceSteps.get(i));
		}
		return furthestReachSoFar >= lastlndex;
	}
//DELETE DUPLICATES FROM A SORTED ARRAY
//.Returns the number of valid entries after deletion. 
public static int deleteDuplicates(ListInteger> A){
	if (A.isEmpty()){ 
		return 0;
	}
	int writelndex = 1;
	for (int i = 1; i < A.sizeO; ++i){
		if (!A.get(writelndex - 1).equals(A.get(i))) { 
			A.set(writelndex++, A.get(i));
		} 
	}
	return writelndex;
}

//BUYANDSELLASTOCKONCE
public static double computeMaxProfit(List<Double> prices){ 
	double minPrice = Double.MAX_VALUE , 
	double maxProfit = 0.0;
	for (Double price : prices) {
		maxProfit = Math.max(maxProfit, price - minPrice);
		minPrice = Math.min(minPrice , price);
	}
	return maxProfit;
}

//BUY AND SELL A STOCK TWICE
public static double buyAndSellStockTwice(List<Double> prices){ 
	double maxTotalProfit = 0.0;
	List<Double> firstBuySellProfits = new ArrayList<>();

	// Forward phase. For each day, we record maximum profit if we // sell on that day.
	double minPriceSoFar = Double.MAX_VALUE ;
	for (int i = 0; i < prices.size(); ++i) {
		minPriceSoFar = Math.min(minPriceSoFar , prices.get(i);
		maxTotalProfit = Math.max(maxTotalProfit , prices.get(i) - minPriceSoFar); 
		firstBuySellProfits.add(maxTotalProfit);
	}
	// Backward phase. For each day, find the maximum profit if we make the second buy on that day.
	double maxPriceSoFar = Double.MIN_VALUE ;
	for (int i= prices.size()-1; i>0; --i){ 
		maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i)); 
		maxTotalProfit = Math.max(maxTotalProfit , maxPriceSoFar - prices.get(i) + firstBuySellProfits.get(i - 1));
	}
	return maxTotalProfit;
}
//ENUMERATE ALL PRIMES TO n
// Given n, return all primes up to and including n. 
public static List<Integer> generatePrimes(int n){
	List<Integer> primes = new ArrayList<>();
	// isPrime.get(p) represents if p is prime or not. Initially, set each
	// to true, excepting ® and 1. Then use sieving to eliminate nonprimes.
	List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
	isPrime.set(®,false);isPrime.set(1,false);
	for(int p = 2;p<=n;++p){
		if(isPrime.get(p)){ 
			primes.add(p);
			//Sieve p’s multiples.
			for (int j = p; j <= n; j += p) {
				isPrime.set(j, false);
			} 
		}
	}return primes;
}

//PERMUTETHE ELEMENTS OF AN ARRAY, (2,0,1,3} represents the permutation that maps the element at location 0 to location 2
public static void applyPermutation(List<Integer> perm, List<Integer> A){ 
	for (int i = 0; i < A.sizeO; ++i){
		// Check if the element at index i has not been moved by checking if 
		// perm.get(i) is nonnegative.
		int next = i;
		while (perm.get(next) >= ®){
			Collections.swap(A, i, perm.get(next));
			int temp = perm,get(next);
			// Subtracts perm.sizeO from an entry in perm to make it negative , 
			// which indicates the corresponding move has been performed. 
			perm.set(next, perm,get(next) - perm.sizeO);
			next = temp;
		}
	}
	// Restore perm.
	for (int i = 0; i < perm.sizeO; i++) {
		perm.set(i, perm.get(i) + perm.sizeO);
	} 
}			
//COMPUTE THE NEXT PERMUTATION
public static List<Integer> nextPermutation(List<Integer> perm) { 
	int k = perm.sizeO - 2;
	while (k >= 0 && perm.get(k) >= perm.get(k + 1)) {
		--k;
	}
	if (k == -1) {
		return Collections.emptyList(); // perm is the last permutation. 
	}
	// Swap the smallest entry after index k that is greater than perm[k] . We 
	// exploit the fact that perm.subList(k + 1, perm.sizeO) is decreasing so 
	// if we search in reverse order, the first entry that is greater than
	// perm[k] is the smallest such entry.
	for (int i = perm.sizeO - 1; i > k; --i){ 
		if (perm.get(i) > perm.get(k)) {
			Collections.swap(perm, k, i);
			break ;
		}
	}
	//Since perm.subList[k + 1, perm.size()) is in decreasing order, we can
	//build the smallest dictionary ordering of this subarray by reversing it. 
	Collections.reverse (perm.subList (k + 1, perm .size ())) ;
	return perm;
}

// SAMPLE OFFLINE DATA, 
// Returns a subset of the given size of the array elements.
public static void randomsampling(int k, List<Integer> A) { 
	Random gen = new Random (); 
	for(int i = 0; i < k; ++i) {
		//Generate a random int in [i, A.size()-1].
		Collections.swap (A , i, i + gen.nextlnt(A .size () - i));
	} 
}

//SAMPLE ONLINE DATA 
//Assumption: there are at least k elements in the stream.
public static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int k){
	Listdnteger> runningSample = new ArrayList<>(k); 
	// Stores the first k elements.
	for (int i = 0; sequence.hasNext()  && i<k; ++i){
		runningSample.add(sequence.next());
	}
	//Have read the first k elements. 
	int numSeenSoFar = k;
	Random randldxGen = new Random(); 
	while (sequence.hasNext()){
		Integer x = sequence.next();
		++numSeenSoFar ;
		//Generate a random number in [Q, numSeenSoFar], and if this number is in 
		// [9, k - 1], we replace that element from the sample with x.
		final int idxToReplace = randldxGen.nextlnt(numSeenSoFar);
		if (idxToReplace < k){
			runningSample.set(idxToReplace, x);
		} 
	}
	return runningSample;
}
//COMPUTE A RANDOM PERMUTATION
public static List<Integer> computeRandomPermutation(int n) { 
	List <Integer> permutation = new ArrayList <>(n) ;

	for(int i = 0; i < n; ++i) {
		permutation.add(i) ;
	}
	OfflineSampling.randomSampling(permutation.size(), permutation);
	return permutation; 
}
//COMPUTE A RANDOM SUBSET
//Returns a random k-sized subset of {Q, 1, n - 1}. 
public static List<Integer> randomSubset(int n, int k) {
	Map<Integer , Integer> changedElements = new HashMap<>(); 
	Random randldxGen = new Random();
	for (int i = 0; i < k; ++i) {
		//Generate random int in [i, n - 1].
		int randldx = i + randldxGen.nextlnt(n - i); 
		Integer ptrl = changedElements.get(randldx); 
		Integer ptr2 = changedElements.get(i);
		if (ptrl == null && ptr2 == null) {
			changedElements.put(randldx, i);
			changedElements.put(i, randldx);
		} else if (ptrl == null && ptr2 != null) {
			changedElements.put(randldx, ptr2);
			changedElements.put(i, randldx);
		} else if (ptrl != null && ptr2 == null) {
			changedElements.put(i, ptrl);
			changedElements.put(randldx, i); }
		else{
				changedElements.put(i, ptrl);
				changedElements.put(randldx, ptr2);
		}
	}
	List<Integer> result = new ArrayList<>(); 
	for (int i = 0; i < k; ++i) {
		result.add(changedElements.get(i));
	}
	return result;
}


public static int nonuniformRandomNumberGenerationC List dnteger > values, List<Double> probabilities) {
			List<Double> pref ixSumOfProbabilities = new ArrayLis t <>() ; 
			prefixSumOfProbabilities .add(® .®) ;
	// Creating the endpoints for the intervals corresponding to the // probabilities.
	for (double p : probabilities) {
		prefixSumOfProbabilities.add( prefixSumOfProbabilities.get (prefixSumOfProbabilities.size () - 1) + p);
	}
	Random r = new Random(); .
	// Get a random number in [SI.SI,1.SI)
	final double uniform01 = r.nextDouble () ;
	// Find the index of the interval that uniformSIl lies in.
	int it = Collections.binarySearch(prefixSumOfProbabilities , uniform01); 
	if (it < 0) {
		// We want the index of the first element in the array which is
		// greater than the key.
		//
		// When a key is not present in the array, Collections.binarySearch() // returns the negative of 1 plus the smallest index whose entry
		// is greater than the key.
		// Therefore , if the return value is negative , by taking its absolute 
		// value and adding 1 to it , we get the desired index.
		final int intervalldx = (Math.abs(it) - 1) - 1;
		return values .get ( intervalldx) ;
	} else {
	// We have it >= 0, i.e., uniformQl equals an entry // in prefixSumOf Probabilities .
	//
	// Because we uniformQl is a random double, the probability of it
	// equalling an endpoint in prefixSumOfProbabilities is exceedingly low.
	// However, it is not (P, so to be robust we must consider this case. 
		return values .get (it) ;
	} 
}

// Check if a partially filled matrix has any conflicts.
public static boolean isValidSudoku(List<List<Integer» partialAssignment){
	// Check row constraints.
	for (int i = 0; i < partialAssignment.size(); ++i) {
		if (hasDuplicate(partialAssignment , i, i + 1, 0, partialAssignment.size())) {
			return false;
		}
	}
	// Check column constraints.
	for (int j = 0; j < partialAssignment.size(); ++j) {
		if(hasDuplicate(partialAssignment, 0, partialAssignment.size(),j, j + 1)) {
			return false;
		}
	}			
	// Check region constraints.
	int regionSize = (int) Math.sqrt(partialAssignment.size()); 
		for (int I = 0; I < regionSize; ++I){
			for (int J = 0; J < regionSize; ++J){
				if (hasDuplicate(partialAssignment, regionSize * I, regionSize * (I + 1), regionSize * J, regionSize * (J + 1))) {
					return false;
				}
			}
			return false;
			} 
		}
	}
	return true;
}

// Return true if subarray partialAssignment[startRow : endRow - 1][startCol :
// endCol-1]containsanyduplicatesin{1,2,...»
// partialAssignment.size()}; otherwise return false.
private static boolean hasDuplicate (List <List<Integer» partialAssignment, int startRow, int endRow, int startCol, int endCol) { 
	List <Boolean> isPresent = new ArrayList<>( Collections.nCopies(partialAssignment.size() + 1, false)); 
	for (int i = startRow; i < endRow; ++i) {
		for(int j = startCol; j < endCol; ++j) { 
			if (partialAssignment.get(i).get(j) != 0 && isPresent.get(partialAssignment.get(i).get(j))) {
				return true;
			}
			isPresent.set(partialAssignment.get(i).get(j) , true); 
		}
	}
	return false;
}




	

