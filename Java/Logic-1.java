// When squirrels get together for a party, they like to have cigars. A squirrel party is successful when
// the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case there is
// no upper bound on the number of cigars. Return true if the party with the given values is successful, or false otherwise.
public boolean cigarParty(int cigars, boolean isWeekend)
{
	if(isWeekend)
		return (cigars >= 40);
	return (cigars >= 40 && cigars <= 60);
}


// You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness of
// your clothes, in the range 0..10, and "date" is the stylishness of your date's clothes.
// The result getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you
// is very stylish, 8 or more, then the result is 2 (yes). With the exception that if either of you has
// style of 2 or less, then the result is 0 (no). Otherwise the result is 1 (maybe).
public int dateFashion(int you, int date)
{
	if(you <= 2 || date <= 2)
		return 0;
	if(you >= 8 || date >= 8)
		return 2;
	return 1;
}


// The squirrels in Palo Alto spend most of the day playing. In particular, they play if the temperature
// is between 60 and 90 (inclusive). Unless it is summer, then the upper limit is 100 instead of 90.
// Given an int temperature and a boolean isSummer, return true if the squirrels play and false otherwise.
public boolean squirrelPlay(int temp, boolean isSummer)
{
  if(isSummer)
		return (temp >= 60 && temp <= 100);
	return (temp >= 60 && temp <= 90);
}


// You are driving a little too fast, and a police officer stops you. Write code to compute the result,
// encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket.
// If speed is 60 or less, the result is 0.
// If speed is between 61 and 80 inclusive, the result is 1. If speed is 81 or more, the result is 2.
// Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
public int caughtSpeeding(int speed, boolean isBirthday)
{
	if(isBirthday)
		speed -= 5; //  diff limit is higher now
	if(speed <= 60)
		return 0;
	else if(speed <= 80)
		return 1;
	else
		return 2;
}


// Given 2 ints, a and b, return their sum. However, sums in the range 10..19 inclusive,
// are forbidden, so in that case just return 20.
public int sortaSum(int a, int b)
{
	int sum = a + b;
	if(sum >= 10 && sum <= 19)
		return 20;
	return sum;
}


// Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating
// if we are on vacation, return a string of the form "7:00" indicating when the alarm clock should ring. 
// Weekdays, the alarm should be "7:00" and on the weekend it should be "10:00". Unless we are on vacation
// -- then on weekdays it should be "10:00" and weekends it should be "off".
public String alarmClock(int day, boolean vacation)
{
	if(vacation)
	{
		if(day == 0 || day == 6)
			return "off";
		return "10:00";
	}
	else
	{
		if(day == 0 || day == 6)
			return "10:00";
		return "7:00";
	}
}


// The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6.
// Or if their sum or difference is 6. Note: the function Math.abs(num) computes the absolute value of a number. 
public boolean love6(int a, int b)
{
	if(a == 6 || b == 6)
		return true;
	return ((a + b) == 6|| Math.abs(a - b) == 6);
}


// Given a number n, return true if n is in the range 1..10, inclusive. Unless "outsideMode" is true,
// in which case return true if the number is less or equal to 1, or greater or equal to 10.
public boolean in1To10(int n, boolean outsideMode)
{
	if(outsideMode)
		return (n <= 1 || n >= 10);
	return (n >= 1 && n <= 10);
}


// Given a non-negative number "num", return true if num is within 2 of a multiple of 10.
// Note: (a % b) is the remainder of dividing a by b, so (7 % 5) is 2.
public boolean nearTen(int num)
{	return (num % 10 <= 2 || num % 10 >= 8);	}


// Given 2 ints, a and b, return their sum. However, "teen" values in the range 13..19 inclusive,
// are extra lucky. So if either value is a teen, just return 19.
public int teenSum(int a, int b)
{
	if(a >= 13 && a <= 19 || b >= 13 && b <= 19)
		return 19;
	return (a + b);
}


// Your cell phone rings. Return true if you should answer it.
// Normally you answer, except in the morning you only answer if it is your mom calling.
// In all cases, if you are asleep, you do not answer. 
public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep)
{
	if(isAsleep)
		return false;
	if(isMom)
		return true;
	return (!isMorning);
}


// We are having a party with amounts of tea and candy. Return the int outcome of the party encoded
// as 0=bad, 1=good, or 2=great. A party is good (1) if both tea and candy are at least 5.
// However, if either tea or candy is at least double the amount of the other one, the party is great (2).
// However, in all cases, if either tea or candy is less than 5, the party is always bad (0). 
public int teaParty(int tea, int candy)
{
	if(tea < 5 || candy < 5)
		return 0;
	if(candy >= tea*2 || tea >= candy*2)
		return 2;
	return 1;
}


// Given three ints, a b c, return true if it is possible to add two of the ints to get the third. 
public boolean twoAsOne(int a, int b, int c)
{	return ((a + b) == c || (b + c) == a || (c + a) == b);	}


// Given three ints, a b c, return true if b is greater than a, and c is greater than b.
// However, with the exception that if "bOk" is true, b does not need to be greater than a. 
public boolean inOrder(int a, int b, int c, boolean bOk)
{
	if(bOk)
		return (c > b);
	return (b > a && c > b);
}


// Given three ints, a b c, return true if they are in strict increasing order,
// such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7.
// However, with the exception that if "equalOk" is true, equality is allowed, such as 5 5 7 or 5 5 5. 
public boolean inOrderEqual(int a, int b, int c, boolean equalOk)
{
	if(equalOk)
		return (a <= b && b <= c);
	return (a < b && b < c);
}


// Given three ints, a b c, return true if two or more of them have the same rightmost digit.
// The ints are non-negative. Note: the % "mod" operator computes the remainder, e.g. 17 % 10 is 7. 
public boolean lastDigit(int a, int b, int c)
{	int aD = a % 10;
	int bD = b % 10;
	int cD = c % 10;
	if(aD == bD)
		return true;
	if(aD == cD)
		return true;
	return (bD == cD);
}


// Given three ints, a b c, return true if one of them is 10 or more less than one of the others.
public boolean lessBy10(int a, int b, int c)
{	return(Math.abs(a - b) >= 10 || Math.abs(b - c) >= 10 || Math.abs(c - a) >= 10);	}


// Return the sum of two 6-sided dice rolls, each in the range 1..6.
// However, if noDoubles is true, if the two dice show the same value,
// increment one die to the next value, wrapping around to 1 if its value was 6. 
public int withoutDoubles(int die1, int die2, boolean noDoubles)
{
	if(noDoubles && die1 == die2)
	{
		if(die1 == 6)
			die1 = 1;
		else
			die1++;
	}
	return die1+die2;
}


// Given two int values, return whichever value is larger. However if the two values have the same remainder when divided by 5
// then the return the smaller value. However, in all cases, if the two values are the same, return 0.
// Note: the % "mod" operator computes the remainder, e.g. 7 % 5 is 2. 
public int maxMod5(int a, int b)
{
	if(a == b)
		return 0;
	if(a % 5 == b % 5)
		return (a < b) ? a : b;
	return (a > b) ? a : b;
}



// You have a red lottery ticket showing ints a, b, and c, each of which is 0, 1, or 2.
// If they are all the value 2, the result is 10. Otherwise if they are all the same, the result is 5.
// Otherwise so long as both b and c are different from a, the result is 1. Otherwise the result is 0.
public int redTicket(int a, int b, int c)
{
	if(a == b && b == c)
	{
		if(a == 2)
			return 10;
		return 5;
	}
	if(a != b && a !=c)
		return 1;
	return 0;
}


// You have a green lottery ticket, with ints a, b, and c on it.
// If the numbers are all different from each other, the result is 0. If all of the numbers are the same,
// the result is 20. If two of the numbers are the same, the result is 10. 
public int greenTicket(int a, int b, int c)
{
	if(a == b)
	{
		if(b == c)
			return 20;
		return 10;
	}
	if(a == c || b == c)
		return 10;
	return 0;
}


// You have a blue lottery ticket, with ints a, b, and c on it.
// This makes three pairs, which we'll call ab, bc, and ac.
// Consider the sum of the numbers in each pair. If any pair sums to exactly 10, the result is 10.
// Otherwise if the ab sum is exactly 10 more than either bc or ac sums, the result is 5. Otherwise the result is 0. 
public int blueTicket(int a, int b, int c)
{
	int ab = a + b;
	int bc = b + c;
	int ca = c + a;
	if(ab == 10 || bc == 10 || ca == 10)
		return 10;
	if(ab == bc + 10 || ab == ca + 10)
		return 5;
	return 0;
}


// Given two ints, each in the range 10..99, return true if there is a digit that appears in both numbers,
// such as the 2 in 12 and 23. (Note: division, e.g. n/10, gives the left digit while the % "mod" n%10
// gives the right digit.)
public boolean shareDigit(int a, int b)
{
	int aDigit = a%10;
	int bDigit = b%10;
	a /= 10;
	b /= 10;
	return (a == b || a == bDigit || aDigit == b || aDigit == bDigit);
}


// Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits as a.
// If the sum has more digits than a, just return a without b.
//Note: one way to compute the number of digits of a non-negative int n is to convert it to a
// string with String.valueOf(n) and then check the length of the string.)

public int sumLimit(int a, int b)
{
	int aLength = numOfDigits(a);
	int sum = a + b;
	if(aLength == numOfDigits(sum))
		return sum;
	return a;
}


// helper function
public int numOfDigits(int num)
{
	int count = 0;
	while(num != 0)
	{
		num /= 10;
		count++;
	}	
	return count;
}





