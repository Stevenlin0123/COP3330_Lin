import java.util.Scanner;


public class Lin_p1 {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 4 digit number: ");
		String n = s.nextLine();
		
		if(n.length() == 4)
		{
		String encryptnum = Encrypter.encrypt(n);
		
		System.out.println("Encrypted number is " + encryptnum);
		
		String decryptnum = Decrypter.decrypt(encryptnum);
		
		System.out.println("Decrypted number of " + encryptnum + " is " + decryptnum);
		}
	}
}