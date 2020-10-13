public class Decrypter {

	public static String decrypt(String n) {
		int array[] = new int[4];
		int temp, num2=0;
		String outcome;
		
		for(int i=0; i<4; i++)
		{
			char ch = n.charAt(i);
			array[i] = Character.getNumericValue(ch);
		}
		
		
		
		
		for(int i=0; i<4; i++)
		{
			if(array[i] <= 6 && array[i]>=0)
			{
				array[i] += 10;
			}
			array[i]-=7;
			
		}
		temp = array[0];
		array[0] = array[2];
		array[2] = temp;
		temp = array[1];
		array[1] = array[3];
		array[3] = temp;
		for(int i=0; i<4; i++)
		{
			num2 = (num2 * 10)+ array[i];
		}
		
		outcome = Integer.toString(num2);
		
		if(array[0] == 0)
		{
			outcome = '0'+outcome;
		}
		
		return outcome;
	}
	
}