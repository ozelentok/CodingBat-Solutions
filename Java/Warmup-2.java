// Given a string and a non-negative int n, return a larger string that is n copies of the original string.
public String stringTimes(String str, int n)
{
	StringBuilder stbuild = new StringBuilder(str.length()*n);
	for(int i = 1; i <= n; i++)
		stbuild.append(str);
	return stbuild.toString();
}


// Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars,
// or whatever is there if the string is less than length 3.
// Return n copies of the front
public String frontTimes(String str, int n)
{
	int len = str.length();
	StringBuilder stbuilder;
	String front;
	if(len >= 3)
		front = str.substring(0, 3);
	else
		front = str;
	stbuilder = new StringBuilder(len*n);
	for(int i = 1; i <= n; i++)
		stbuilder.append(front);
	return stbuilder.toString();
}


// Given a string, return a new string made of every other char starting with the first,
// so "Hello" yields "Hlo". 
public String stringBits(String str)
{
	int len = str.length();
	StringBuilder stbuild = new StringBuilder(len+1);
	for(int i = 0; i < len; i += 2)
		stbuild.append(str.charAt(i));
	return stbuild.toString();
}


// Given a non-empty string like "Code" return a string like "CCoCodCode".
public String stringSplosion(String str)
{
	StringBuilder stbuild;
	int len = str.length();
	int bufferSize = 1;
	for(int i = 2; i <= len; i++)
		bufferSize *= i;
	stbuild = new StringBuilder(bufferSize);
	for(int i = 1; i <= len; i++)
	{
		for(int j = 0; j < i; j++)
			stbuild.append(str.charAt(j));	
	}
	return stbuild.toString();
}


// Given a string, return the count of the number of times that a substring length 2 appears in the string
// and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring). 
public int last2(String str)
{
	int len = str.length() - 2;
	int count = 0;
	if(len >= 0)
	{
		String end = str.substring(len);
		for(int i = 0; i < len; i++)
		{
			if(str.substring(i, i+2).equals(end))
				count++;
		}
	}
	return count;
}


// Given an array of ints, return the number of 9's in the array. 
public int arrayCount9(int[] nums)
{
	int count = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] == 9)
			count++;
	}
	return count;
}


// Given an array of ints, return true if one of the first 4 elements in the array is a 9.
// The array length may be less than 4.
public boolean arrayFront9(int[] nums)
{
	int len = nums.length;
	int count = 0;
	if(len > 4)
		len = 4;
	for(int i = 0; i < len; i++)
	{
		if(nums[i] == 9)
			return true;
	}
	return false;
}


// Given an array of ints, return true if .. 1, 2, 3, .. appears in the array somewhere. 
public boolean array123(int[] nums)
{
	int current = 1;
	for(int i = 0; i < nums.length-2; i++)
	{
		if(nums[i] == 1 && nums[i+1] == 2 && nums[i+2])
			return true;
	}
	return false;
}


// Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring.
// So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings. 
public int stringMatch(String a, String b)
{
	int len = a.length() <= b.length() ? a.length() : b.length();
	len--;
	int count = 0;
	for(int i = 0; i < len; i++)
	{
		if(a.substring(i, i+2).equals(b.substring(i, i+2)))
			count++;
	}
	return count;
}


// Given a string, return a version where all the "x" have been removed.
// Except an "x" at the very start or end should not be removed. 
public String stringX(String str)
{
	int len = str.length();
	if(len >= 2)
	{
		len--;
		StringBuilder stbuild = new StringBuilder(len-1);
		stbuild.append(str.charAt(0));
		for(int i = 1; i < len; i++)
		{
			if(str.charAt(i) != 'x')
				stbuild.append(str.charAt(i);
		}
		stbuild.append(str.charAt(len));
		return stbuild.toString()
	}
	else
		return str;
}


// Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9
// so "kittens" yields "kien".
public String altPairs(String str)
{
	int len = str.length();
	if(len >= 3)
	{
		StringBuilder stbuild = new StringBuilder();
		for(int i = 0; i < len; i += 4)
		{
			stbuild.append(str.charAt(i));
			if(i+1 < len)
				stbuild.append(str.charAt(i+1));
		}
		return stbuild.toString();
	}
	else
		return str;
}


// Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed,
// but the "a" can be any char. The "yak" strings will not overlap.
public String stringYak(String str)
{
	int len = str.length();
	int i = 0;
	char ch;
	StringBuilder stbuild = new StringBuilder(len);
	while(i < len)
	{
		ch = str.charAt(i);
		if(i+2 < len && ch == 'y' && str.charAt(i+2) == 'k')
			i += 3;
		else
		{
			stbuild.append(ch);
			i++;
		}
	}
	return stbuild.toString();
}


// Given an array of ints, return the number of times that two 6's are next to each other in the array.
// Also count instances where the second "6" is actually a 7. 
public int array667(int[] nums)
{
	int counter = 0;
	for(int i = 1; i < nums.length; i++)
	{
		if((nums[i] == 7 || nums[i] == 6) && nums[i-1] == 6)
			counter++;
	}
	return counter;
}


// Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
// Return true if the array does not contain any triples.
public boolean noTriples(int[] nums)
{
	for(int i = 0; i < nums.length - 2; i++)
	{
		if(nums[i] == nums[i+1] && nums[i] == nums[i+2])
			return false;
	}
	return true;
}


// Given an array of ints, return true if it contains a "2, 7, 1" pattern:
// a value, followed by the value plus 5, followed by the value minus 1. Additionally the 271 counts
// even if the "1" differs by 2 or less from the correct value. 
public boolean has271(int[] nums)
{
	int temp;
  for(int i = 0; i < nums.length - 2; i++)
	{
		if(nums[i]+5 == nums[i+1])
		{
			temp = nums[i] - nums[i+2];
			if(temp <= 3 && temp >= -1)
				return true;
		}
	}
	return false;
}
