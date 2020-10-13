public class Encrypter {
	
	public static String encrypt(String n) 
	{
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
			temp = array[i];
			temp += 7;
			temp = temp%10;
			array[i] = temp;
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