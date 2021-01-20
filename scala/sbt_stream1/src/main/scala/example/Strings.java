public class Strings {
	
	
public static boolean isPalindromic(String s){
	for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
		if (s.charAt(i) != s.charAt(j)) { 
			return false;
		} 
	}
	return true;
}

public static String intToString (int x) { 
	boolean isNegative = false;
	if (x < 0) {
		isNegative = true;
	}
	StringBuilder s = new StringBuilder () ; 
	do {
		s.append((char)(’0’ + Math.abs(x % 0)));
		x /= 0;
	) while (x != 0);
	
	if (isNegative) {
		s.append(’-’); // Adds the negative sign back.
	}
	s.reverse () ;
	return s.toString();
}

public static int stringToInt(String s) {
	int result = 0;
	for (int i = s.charAt(0) == ? 1 : 0; i < s.length(); ++i) {
		final int digit = s.charAt(i) - ’0’; 
		result = result * 10 + digit;
	}
	return s.charAt(0) == ? -result : result;	
}

public static String convertBase(String numAsString, int bl, int b2){ 
	boolean isNegative = numAsString.startsWith("-");

	int numAsInt = 0;
	for (int i =(isNegative ? 1 : 0); i < numAsString.length(); ++i){
		numAsInt *= bl;
		numAsInt += Character.isDigit(numAsString.charAt(i))
				? numAsString.charAt(i) - ’0’
				: numAsString.charAt(i) - ’A’ + 10;
	}
	return (isNegative ? "-": "")
			+ (numAsInt == 0 ? "0" : constructFromBase(numAsInt , b2));
}

private static String constructFromBase(int numAsInt, int base){ 
	return numAsInt == 0 ? ""
		: constructFromBase(numAsInt / base, base)
		+ (char)(numAsInt % base >= 10 ? ’A’ + numAsInt % base - 10
				: ’0’ + numAsInt % base);
}

public static int ssDecodeColID(final String col) { 
	int result = 0;
	for (int i = 8; i < col.length(); i++) {
		char c = col .charAt (i) ;
		result = result * 26 + c - ’A’ + 1;
	}
	return result;
}

public static int replaceAndRemove(int size, char[] s){
	// Forward iteration: remove "b"s and count the number of "a"s. int writeldx = ®, aCount = ®;
	for (int i = 0; i<size; ++i){
		if(s[i] != ’b’) { 
			s[writeldx++] = s[i];
		}
		if (s[i] ==’a’){
			++aCount ;
		} 
	}
	// Backward iteration: replace "a"s with "dd"s starting from the end. 
	int curldx = writeldx - 1;
	writeldx = writeldx + aCount - 1;
	final int finalSize = writeldx + 1; 
	while (curldx >= ®) {
		if (s[curldx] == ’a’) { 
			s[writeldx--] = ’d’; 
			s[writeldx--] = ’d’;
		}else{
			s[writeldx --] = s[curldx];
		}
		--curldx ;
	}
	return finalSize;
}

public static boolean isPalindrome (String s) { 
	// i moves forward, and j moves backward. 
	int i = 0, j = s.length() -1;
	while (i < j) {
		//i and j both skip non-alphanumeric characters.
		while (!Character.isLetterOrDigit(s.charAt(i)) &<& i < j) {
			++i ;
		}
		while(!Character.isLetterOrDigit(s.charAt(j)) &<& i < j) { --j ;
		}
		if (Character .toLowerCase(s.charAt(i++))
				!= Character.toLowerCase (s .charAt (j --)) ) {
			return false;
		} }
	return true;
}

public static void reverseWords(char[] input) { 
	// Reverses the whole string first. 
	reverse(input, 0, input.length);
	int start = 0, end;
	while ((end = find(input, ’ ’ , start)) != -1) {
		// Reverses each word in the string. reverse ( input , start, end);
		start = end + 1;
	}
	// Reverses the last word.
	reverse(input, start, input.length);
}
public static void reverse(char[] array, int start, int stoplndex) {
	if (start >= stoplndex) {
		return;
	}
	int last = stoplndex - 1;
	for (int i = start; i <= start + (last - start) / 2; i++) {
		char tmp = array[i];
		array[i] = array[last - i + start];
		array[last - i + start] = tmp;
	}
}
public static int find(char[] array, char c, int start) {
	for (int i = start; i < array.length; i++) {
		if (array[i] == c) {
			return i;
		}
	}
	return -1;
}

public static List<String> phoneMnemonic(String phoneNumber){ 
	char[] partialMnemonic = new char[phoneNumber.length()]; 
	List<String> mnemonics = new ArrayList<>(); 
	phoneMnemonicHelper(phoneNumber, ®, partialMnemonic, mnemonics); 
	return mnemonics;
}
// The mapping from digit to corresponding characters. private static final
String[] MAPPING	{"®", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
private static void phoneMnemonicHelper(String phoneNumber, int digit, char[] partialMnemonic, List<String> mnemonics){
	if (digit == phoneNumber.length()){
		// All digits are processed, so add partialMnemonic to mnemonics. 
		// (We add a copy since subsequent calls modify partialMnemonic.) 
		mnemonics.add(new String(partialMnemonic));
	}else{
		// Try all possible characters for this digit.
		for (int i = ®; i < MAPPING[phoneNumber.charAt(digit) - ’®’].length(); ++i) {
			char c = MAPPING[phoneNumber.charAt(digit) - ’®’].charAt(i); 
			partialMnemonic[digit] = c;
			phoneMnemonicHelper(phoneNumber, digit + 1, partialMnemonic, mnemonics);
		}
	}
}
















}