// Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
public int countYZ(String str)
{
	int count = 0;
	int limit = str.length() - 1;
	char ch;
	str = str.toLowerCase();
	ch = str.charAt(0);
	for(int i = 1; i <= limit; i++)
	{
		if(ch == 'y' || ch == 'z')
		{
			ch = str.charAt(i);
			if(!Character.isLetter(ch))
				count++;
		}
		else
			ch = str.charAt(i);
	}
	if(ch == 'y' || ch == 'z')
		count++;
	return count;
}

// Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
public String withoutString(String base, String remove)
{
	int blen = base.length();
	int rlen = remove.length();
	int current = 0;
	int place;
	StringBuilder stbuild = new StringBuilder(blen);
	String blow = base.toLowerCase();
	String rlow = remove.toLowerCase();
	place = blow.indexOf(rlow);
	while(place != -1)
	{
		for(; current < place; current++)
		{
			stbuild.append(base.charAt(current));
		}
		current = place+rlen;
		place = blow.indexOf(rlow, current);
	}
	for(; current < blen; current++)
	{
			stbuild.append(base.charAt(current));
	}
	return stbuild.toString();
}

// Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive). 
public boolean equalIsNot(String str)
{
	  int balance = 0;
	  int p;
	  p = str.indexOf("is");
	  while(p != -1)
	  {
			balance++;
		  p = str.indexOf("is", p+2);
		}
		p = str.indexOf("not");
	  while(p != -1)
	  {
			balance--;
		  p = str.indexOf("not", p+3);
		}
		return (balance == 0);
}
// We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy. 
public boolean gHappy(String str)
{
	int check = 0;
	int limit = str.length();
  for(int i = 0; i < limit; i++)
  {
  	if(str.charAt(i) == 'g')
  	{
  		check = 0;
  		if(i > 0)
  		{
				if(str.charAt(i-1) != 'g')
					check++;
			}
			else
				check++;
			if(i < limit-1)
  		{
				if(str.charAt(i+1) != 'g')
					check++;
			}
			else
				check++;	
			if(check == 2)
				return false;
		}
  }
  return true;
}

// We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap.
public int countTriple(String str)
{
	int count = 0;
	int lim = str.length() - 2;
  for(int i = 0; i < lim; i++)
  {
  	if(str.charAt(i) == str.charAt(i+1) && str.charAt(i) == str.charAt(i+2))
  		count++;
  }
  return count;
}

// Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
public int sumDigits(String str)
{
  int sum = 0;
 	int lim = str.length();
  char ch;
  for(int i = 0; i < lim; i++)
  {
  	ch = str.charAt(i);
		if(Character.isDigit(ch)) // or simply (ch >= '0' && ch <= '9')
			sum += (ch - '0');
	}
	return sum;
}

// Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. For example, sameEnds("abXab") is "ab".
public String sameEnds(String string)
{
	String temp;
	int p = string.length();
	int i;
	if(p%2 == 1)
	{
		i = p/2;
		p = i + 1;
	}
	else
	{
		i = p/2;
		p = i;
	}
	for(; i >= 1; i--, p++)
	{
		temp = string.substring(0, i);
		if(temp.equals(string.substring(p)))
			return temp; 
	}
	return "";
}

// Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab". 
public String mirrorEnds(String string)
{
	int len = string.length();
	int p = len - 1;
	for(int i = 0; i < len; i++, p--)
	{
		if(string.charAt(i) != string.charAt(p))
			return string.substring(0, i);
	}
	return string;
}


// Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.

public int maxBlock(String str)
{
	int stLen = str.length();
	int maxBlock = 0;
	int block = 1;
	char ch;
	char current;
	if(stLen == 0)
		return 0;
	ch = str.charAt(0);
	for(int i = 1; i < stLen; i++)
	{
		current = str.charAt(i);
		if(current == ch)
			block++;
		else
		{
			if(block > maxBlock)
				maxBlock = block;
			block = 1;
			ch = current;
		}
	}
	if(block > maxBlock)
			maxBlock = block;
	return maxBlock;
}

// Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
public int sumNumbers(String str)
{
	int len = str.length();
	int start = - 1;
	int end = 0;
	int sum = 0;
	for(int i = 0; i < len; i++)
	{
		if(start == -1)
		{
			if(Character.isDigit(str.charAt(i)))
			{
				start = i;
				end = i+1;
			}
		}
		else
		{
			if(Character.isDigit(str.charAt(i)))
				end++;
			else
			{
				sum += Integer.parseInt(str.substring(start,end));
				start = -1;
			}
		}
	}
	if(start != -1)
		sum += Integer.parseInt(str.substring(start,end));
	return sum;
}
// Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char) tests if a char is a letter.) 
public String notReplace(String str)
{
	int p = str.indexOf("is");
	int check;
	while(p != -1)
	{
  	check = 0;
  	if(p > 0)
  	{
			if(!Character.isLetter(str.charAt(p-1)))
				check++;
		}
		else
			check++;
		if(p < str.length()-2)
  	{
			if(!Character.isLetter(str.charAt(p+2)))
				check++;
		}
		else
			check++;	
		if(check == 2)
			str = str.substring(0, p) + "is not" + str.substring(p+2);
		p = str.indexOf("is", p+2);
	}	
	return str;
}


