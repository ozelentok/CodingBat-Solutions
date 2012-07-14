// Given a string, return a string where for every char in the original, there are two chars.
public String doubleChar(String str)
{
	int len = str.length();
	char ch;
	StringBuilder stbuild = new StringBuilder(len*2);
	for(int i = 0; i < len; i++)
	{
		ch = str.charAt(i);
		stbuild.append(ch);
		stbuild.append(ch);
	}
	return stbuild.toString();
}

// Return the number of times that the string "hi" appears anywhere in the given string.
public int countHi(String str)
{
	int len = str.length()-1;
	int times = 0;
	for(int i = 0; i < len; i++)
	{
		if(str.charAt(i) == 'h' && str.charAt(i+1) == 'i')
			times++;
	}
	return times;
}

// Return true if the string "cat" and "dog" appear the same number of times in the given string.
public boolean catDog(String str)
{

	int len = str.length()-2;
	int diff = 0;
	for(int i = 0; i < len; i++)
	{
		if(str.charAt(i) == 'c')
		{
			if(str.charAt(i+1) == 'a' && str.charAt(i+2) == 't')
				diff++;
		}
		else if(str.charAt(i) == 'd')
		{
			if(str.charAt(i+1) == 'o' && str.charAt(i+2) == 'g')
				diff--;
		}
	}
	return (diff == 0);
}

// Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
public int countCode(String str)
{
	int times = 0;
	int i = 0;
	int len = str.length()-3;
	while(i <  len)
	{
		if(str.charAt(i) == 'c' && str.charAt(i+1) == 'o' && str.charAt(i+3) == 'e')
		{
			times++;
			i += 4;
		}
		else
			i++;
	}
	return times;
}

// Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string. 
public boolean endOther(String a, String b)
{
	int aLen = a.length();
	int bLen = b.length();
	String end;
	String temp;
	a = a.toLowerCase();
	b = b.toLowerCase();
	if(aLen >= bLen)
	{
		end = a.substring(aLen - bLen);
		temp = b;
	}
	else
	{
		end = b.substring(bLen - aLen);
		temp = a;
	}
	return (end.equals(temp));
}

// Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
public boolean xyzThere(String str)
{
	int len = str.length() - 2;
	for(int i = 0; i < len; i++)
	{
		if(str.charAt(i) == 'x' && str.charAt(i+1) == 'y' && str.charAt(i+2) == 'z')
		{
			if(i == 0 || str.charAt(i-1) != '.')
				return true;
		}
	}
	return false;
}

// Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char. 
public boolean bobThere(String str)
{
	int len = str.length() - 2;
	for(int i = 0; i < len; i++)
	{
		if(str.charAt(i) == 'b' && str.charAt(i+2) == 'b')
			return true;
	}
	return false;
}

// We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
public boolean xyBalance(String str)
{
	int len = str.length() - 1;
	char ch;
	for(int i = len; i >= 0; i--)
	{
		ch = str.charAt(i);
		if(ch == 'x')
			return false;
		else if(ch == 'y')
			return true;
	}
	return true;  
}

// Given two strings, A and B, create a bigger string made of the first char of A, the first char of B, the second char of A, the second char of B, and so on. Any leftover chars go at the end of the result. 
public String mixString(String a, String b)
{
	int aLen = a.length();
	int bLen = b.length();
	int i = 0;
	StringBuilder stbuild = new StringBuilder(aLen+bLen);
	for(; i < aLen && i < bLen; i++)
	{
		stbuild.append(a.charAt(i));
		stbuild.append(b.charAt(i));
	}
	// only 1 for loop will actually run
	for(; i < aLen; i++)
		stbuild.append(a.charAt(i));
	for(; i < bLen; i++)
		stbuild.append(b.charAt(i));
	return stbuild.toString();
}

// Given a string and an int N, return a string made of N repetitions of the last N characters of the string. You may assume that N is between 0 and the length of the string, inclusive.
public String repeatEnd(String str, int n)
{
	StringBuilder stbuild = new StringBuilder(n*n);
	String last = str.substring(str.length()-n);
	for(int i = 0; i < n; i++)
		stbuild.append(last);
	return stbuild.toString();
}

// Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
public String repeatFront(String str, int n)
{
	StringBuilder stbuild = new StringBuilder((n*n + n)/2);
	for(int i = n; i >= 1; i--)
	{
		for(int k = 0; k < i; k++)
			stbuild.append(str.charAt(k));
	}
	return stbuild.toString();
}

//Given two strings, word and a separator, return a big string made of count occurences of the word, separated by the separator string. 
public String repeatSeparator(String word, String sep, int count)
{
	if(count == 0)
		return "";
	StringBuilder stbuild = new StringBuilder(count*word.length()+sep.length()*(count-1));
	for(int i = 1; i < count; i++)
	{
		stbuild.append(word);
		stbuild.append(sep);	
	}
	stbuild.append(word);
	return stbuild.toString();
}

// Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().
public boolean prefixAgain(String str, int n)
{
	String prfx = str.substring(0, n);
	return (str.indexOf(prfx, 1) != -1);
}

// Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
public boolean xyzMiddle(String str)
{
	int len = str.length();
	int mid;
	if(len < 3)
		return false;
	mid = len/2;
	if(len%2 == 0)
	{
		if(str.charAt(mid) == 'y')
			return(str.charAt(mid-1) == 'x' && str.charAt(mid+1) == 'z');
		if(str.charAt(mid-1) == 'y')
			return(str.charAt(mid-2) == 'x' && str.charAt(mid) == 'z');
		return false;
	}
	// len%2 != 0
	else if(str.charAt(mid) == 'y')
			return(str.charAt(mid-1) == 'x' && str.charAt(mid+1) == 'z');
	return false;
}

//A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
public String getSandwich(String str)
{
	int iFirst = str.indexOf("bread");
	int iLast = str.lastIndexOf("bread");
	if(iFirst != -1 && iLast != -1 && iFirst != iLast)
		return str.substring(iFirst+5, iLast);
	return "";
}

// Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same. 
public boolean sameStarChar(String str)
{
	int len = str.length() - 1;
	for(int i = 1; i < len; i++)
	{
		if(str.charAt(i) == '*')
		{
			if(str.charAt(i-1) != str.charAt(i+1))
				return false;
		}	
	}
	return true;
}

// Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp". 
public String zipZap(String str)
{
	int len = str.length();
	int lim = len - 2;
	int i = 0;
	char ch;
	StringBuilder stbuild = new StringBuilder(len);
	while(i < len)
	{
		ch = str.charAt(i);
		if(ch == 'z' && i < lim && str.charAt(i+2) == 'p')
		{
			stbuild.append("zp");
			i += 3;
		}
		else
		{
			stbuild.append(ch);
			i++;
		}
	}
	return stbuild.toString();
}

// Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
public String starOut(String str)
{
	int len = str.length();
	int[] indexes = new int[len];
	char ch;
	StringBuilder stbuild = new StringBuilder(len);
	for(int i = 0; i < len; i++)
	{
		if(str.charAt(i) == '*')
		{
			indexes[i] = 1;
			if(i >= 1)
				indexes[i-1] = 1;
			if(i < (len-1))
				indexes[i+1] = 1;
		}
	}
	for(int i = 0; i < len; i++)
	{
		if(indexes[i] == 0)
			stbuild.append(str.charAt(i));
	}
	return stbuild.toString();
}

// Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
public String plusOut(String str, String word)
{
	int len = str.length();
	int wLen = word.length();
	int pos = str.indexOf(word);
	int i = 0;
	StringBuilder stbuild = new StringBuilder(len);
	while(pos != -1)
	{
		while(i < pos)
		{
			stbuild.append('+');
			i++;
		}
		stbuild.append(word);
		i = pos + wLen;
		pos = str.indexOf(word, i);
	}
	for(; i < len; i++)
		stbuild.append('+');
	return stbuild.toString();
}

// Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words. 
public String wordEnds(String str, String word)
{
	int len = str.length();
	int wLen = word.length();
	int pos = str.indexOf(word);
	int i = 0;
	StringBuilder stbuild = new StringBuilder(len);
	while(pos != -1)
	{
		i = pos + wLen;
		if(pos >= 1)
			stbuild.append(str.charAt(pos-1));
		if(i < len)
			stbuild.append(str.charAt(pos+wLen));
		pos = str.indexOf(word, i);	
	}
	return stbuild.toString();
}
