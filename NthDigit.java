/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).
*/

class Solution {
    public int findNthDigit(int n) {
	int countOfDigits=0,prevCountOfDigits=-1;
	int numberOfDigits=1;
	int totalNumberOfNumbersInTheRange=9;


	while (countOfDigits<n){
		prevCountOfDigits=countOfDigits;
		countOfDigits=countOfDigits+numberOfDigits*totalNumberOfNumbersInTheRange;

        totalNumberOfNumbersInTheRange=totalNumberOfNumbersInTheRange*10;
        
      
        
        numberOfDigits=numberOfDigits+1;
  
          if ((long)totalNumberOfNumbersInTheRange*10>=Integer.MAX_VALUE){
              
           if (countOfDigits<n){numberOfDigits=numberOfDigits+1;
              		prevCountOfDigits=countOfDigits;}

            break;
        }

	}
        
    --numberOfDigits;

	int possibleNumber=getNumberFromDigits(numberOfDigits-1)+(n-prevCountOfDigits)/(numberOfDigits);
            
	if ((n-prevCountOfDigits)%numberOfDigits==0)
		return Character.getNumericValue(String.valueOf(possibleNumber).charAt(String.valueOf(possibleNumber).length()-1));
	else{    
       

		return Character.getNumericValue(String.valueOf(possibleNumber+1).charAt((n-prevCountOfDigits)%(numberOfDigits)-1));
    }

	
  }

 public int getNumberFromDigits(int numberOfDigits){
     if (numberOfDigits==0){
         return numberOfDigits;
     }
     
      
	int num=9;
     int base=9;
	for (int i=1;i<numberOfDigits;i++){
		num=num*10;
        base=base+num;
	}
	return base;
}

} 

