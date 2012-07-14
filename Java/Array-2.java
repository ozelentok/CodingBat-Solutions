// Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
public int countEvens(int[] nums)
{
	int count = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] % 2 == 0)
			count++;
	}
	return count;
}

// Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
public int bigDiff(int[] nums)
{
	int max = nums[0];
	int min = nums[0];
	for(int i = 1; i < nums.length; i++)
	{
		if(nums[i] > max)
			max = nums[i];
		else if(nums[i] < min)
			min = nums[i];
	}
	return (max-min);
}

// Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except not counting the largest and smallest values in the array. Use int division to produce the final average. You may assume that the array is length 3 or more.
public int centeredAverage(int[] nums)
{
  int max = nums[0];
	int min = nums[0];
	int sum = nums[0];
	for(int i = 1; i < nums.length; i++)
	{
		sum  += nums[i];
		if(nums[i] > max)
			max = nums[i];
		else if(nums[i] < min)
			min = nums[i];
	}
	return (sum-max-min) / (nums.length - 2);
}

// Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.
public int sum13(int[] nums) 
{
	int sum = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] == 13)
			i++;
		else
			sum += nums[i];
	}
	return sum;
}

// Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers. 
public int sum67(int[] nums)
{
	int sum = 0;
	boolean sixMode = false;
	for(int i = 0; i < nums.length; i++)
	{
		if(sixMode)
		{
			if(nums[i] == 7)
				sixMode = false;
		}
		else if(nums[i] == 6)
			sixMode = true;
		else
			sum += nums[i];
	}
	return sum;
}

// Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
public boolean has22(int[] nums)
{
  for(int i = 0; i < nums.length-1; i++)
  {
  	if(nums[i] == 2 && nums[i+1] == 2)
  		return true;
  }
  return false;
}

// Given an array of ints, return true if the array contains no 1's and no 3's.
public boolean lucky13(int[] nums)
{
	for(int i = 0; i < nums.length; i++)
  {
  	if(nums[i] == 1 || nums[i] == 3)
  		return false;
  }
  return true;  
}

// Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
public boolean sum28(int[] nums)
{
	int sum = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] == 2)
			sum += 2;
	}
	return (sum == 8);
}

// Given an array of ints, return true if the number of 1's is greater than the number of 4's
public boolean more14(int[] nums)
{
	int balance = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] == 1)
			balance++;
		else if(nums[i] == 4)
			balance--;
	}
	return (balance > 0);
}

// Given an array of ints, return true if every element is a 1 or a 4.
public boolean only14(int[] nums)
{
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] != 1 && nums[i] != 4)
			return false;
	}
	return true;
}

// Given an array of ints, return true if it contains no 1's or it contains no 4's.
public boolean no14(int[] nums)
{
	boolean noOne = true, noFour = true;
  for(int i = 0; i < nums.length && (noOne || noFour); i++)
	{
		if(nums[i] == 1)
			noOne = false;
		else if(nums[i] == 4)
			noFour = false;
	}	
	return (noOne || noFour);
}

// We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array, at least one of the pair is that value. Return true if the given value is everywhere in the array.
public boolean isEverywhere(int[] nums, int val)
{
	for(int i = 0; i < nums.length-1; i++)
	{
		if(nums[i] != val && nums[i+1] != val)
			return false;
	}  
	return true;
}

// Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both. 
public boolean either24(int[] nums)
{
	int no2pair = 1, no4pair = 1;
  for(int i = 0; i < nums.length - 1 && (no2pair + no4pair != 0); i++)
	{
		if(nums[i] == 2 && nums[i+1] == 2)
			no2pair = 0;
		else if(nums[i] == 4 && nums[i+1] == 4)
			no4pair = 0;
	}
	return ((no2pair ^ no4pair) == 1);
}

// Given arrays nums1 and nums2 of the same length, for every element in nums1, consider the corresponding element in nums2 (at the same index). Return the count of the number of times that the two elements differ by 2 or less, but are not equal. 
public int matchUp(int[] nums1, int[] nums2)
{
	int count = 0;
	int diff;
	for(int i = 0; i < nums1.length; i++)
	{
		diff = Math.abs(nums1[i] - nums2[i]);
		if(diff <= 2 && diff != 0)
			count++;			
	}
	return count;
}

// Given an array of ints, return true if the array contains two 7's next to each other, or there are two 7's separated by one element, such as with {7, 1, 7}.
public boolean has77(int[] nums)
{
  for(int i = 0; i < nums.length - 1; i++)
  {
  	if(nums[i] == 7)
  	{
			if(nums[i+1] == 7)
				return true;
			else if(i < nums.length - 2 && nums[i+2] == 7)
				return true;
		}
	}
	return false;
}

// Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array. 
public boolean has12(int[] nums)
{
  boolean oneSpotted = false;
  for(int i = 0; i < nums.length; i++)
  {
  	if(oneSpotted)
  	{
  		if(nums[i] == 2)
  			return true;
  	}
  	else if(nums[i] == 1)
  		oneSpotted = true;
  }
  return false;
}

// Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.
public boolean modThree(int[] nums)
{
	  for(int i = 0; i < nums.length - 2; i++)
	  {
	  	if(nums[i] % 2 == nums[i+1] % 2 && nums[i] % 2 == nums[i+2] % 2)
	  		return true;
	  }
	  return false;
}

// 

// Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other. 
public boolean haveThree(int[] nums)
{
	int count = 0;
  boolean isPerv3 = false;
  for(int i = 0 ; i < nums.length && count <= 3; i++)
  {
  	if(nums[i] == 3)
  	{
  		if(isPerv3)
  			return false;
  		else
  		{
  			count++;
  			isPerv3 = true;
			}
  	}
  	else
  		isPerv3 = false;
  }
  return (count == 3);
}

// Given an array of ints, return true if every 2 that appears in the array is next to another 2.
public boolean twoTwo(int[] nums)
{
	int count = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] == 2)
			count++;
		else
		{
			if(state == 1)
				return false;
			else
				count = 0;
		}
	}
	return (count != 1);
}

// Return true if the group of N numbers at the start and end of the array are the same. For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2, and false for n=1 and n=3. You may assume that n is in the range 0..nums.length inclusive. 
public boolean sameEnds(int[] nums, int len)
{
	int start = 0;
	int end = nums.length-len;
	for(; len > 0; len--)
	{
		if(nums[start] != nums[end])
			return false;
		else
		{
			start++;
			end++;
		}
	}
	return true;
}

// Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25. 
public boolean tripleUp(int[] nums)
{
  boolean prevUp = false;
  for(int i = 0; i < nums.length - 1; i++)
  {
  	if(nums[i+1] - nums[i] == 1)
  	{
  		if(prevUp)
  			return true;
  		else
  			prevUp = true;
  	}
  	else
  		prevUp = false;
  }
  return false;
}

// Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. You may modify and return the given array, or return a new array.
public int[] shiftLeft(int[] nums)
{
	if(nums.length >= 2)
	{
		int temp = nums[0];
		for(int i = 0; i < nums.length - 1; i++)
			nums[i] = nums[i+1];
		nums[nums.length-1] = temp;
	}
	return nums;
}

// For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
public int[] tenRun(int[] nums)
{
	int tenMode = -1;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] % 10 == 0)
			tenMode = nums[i];
		else if(tenMode != -1)
			nums[i] = tenMode;
	}
	return nums;
}

// Given a non-empty array of ints, return a new array containing the elements from the original array that come before the first 4 in the original array. The original array will contain at least one 4. Note that it is valid in java to create an array of length 0.
public int[] pre4(int[] nums)
{
	int p = 0;
	int[] arr;
	while(nums[p] != 4)
		p++;
	arr = new int[p];
	for(int i = 0; i < p; i++)
		arr[i] = nums[i];
	return arr;
}

// Given a non-empty array of ints, return a new array containing the elements from the original array that come after the last 4 in the original array. The original array will contain at least one 4. Note that it is valid in java to create an array of length 0.
public int[] post4(int[] nums)
{
  int p = nums.length - 1;
	int[] arr;
	while(nums[p] != 4)
		p--;
	arr = new int[nums.length - 1 - p];
	for(int i = p + 1; i < nums.length; i++)
		arr[i - p - 1] = nums[i];
	return arr;
}

// We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it. Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger.
public int[] notAlone(int[] nums, int val)
{
  for(int i = 1; i < nums.length - 1; i++)
  {
		if(nums[i] == val)
		{
			if(nums[i-1] != val && nums[i+1] != val)
				nums[i] = (nums[i-1] > nums[i+1]) ? nums[i-1] : nums[i+1];
		}
  }
  return nums;
}

// Return an array that contains the exact same numbers as the given array, but rearranged so that all the zeros are grouped at the start of the array. The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. You may modify and return the given array or make a new array.
public int[] zeroFront(int[] nums)
{
	int zeroIndex = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] == 0)
		{
			nums[i] = nums[zeroIndex];
			nums[zeroIndex] = 0;
			zeroIndex++;
		}
	}
	return nums;
}

// Return a version of the given array where all the 10's have been removed. The remaining elements should shift left towards the start of the array as needed, and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}. You may modify and return the given array or make a new array.
public int[] withoutTen(int[] nums)
{
	int[] arr = new int[nums.length];
	int p = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] != 10)
		{
			arr[p] = nums[i];
			p++;
		}
	}
	// Java arrays are initialized to 0 so no need to set the last elements to 0
	return arr;
}

// Return a version of the given array where each zero value in the array is replaced by the largest odd value to the right of the zero in the array. If there is no odd value to the right of the zero, leave the zero as a zero.
public int[] zeroMax(int[] nums)
{
	int max;
	for(int i = 0; i < nums.length - 1; i++)
	{
		if(nums[i] == 0)
		{
			max = 0;
			for(int k = i + 1; k < nums.length; k++)
			{
				if(nums[k] > max && nums[k] % 2 == 1)
					max = nums[k];
			}
			if(max != 0)
				nums[i] = max;
		}
	}
	return nums;
}

// Return an array that contains the exact same numbers as the given array, but rearranged so that all the even numbers come before all the odd numbers. Other than that, the numbers can be in any order. You may modify and return the given array, or make a new array.
public int[] evenOdd(int[] nums)
{
	int temp;
  int evenIndex = 0;
	for(int i = 0; i < nums.length; i++)
	{
		if(nums[i] % 2 == 0)
		{
			temp = nums[i];
			nums[i] = nums[evenIndex];
			nums[evenIndex] = temp;
			evenIndex++;
		}
	}
	return nums;
}
