package forDongusu;

public class forDongusu {

	public static void main(String[] args) {
		
			star();
	}
	
	public static void star()
	{	final int constant=2;
		String star="*";
		String model="*";
		int starCount;
		
		for(int i=1;i<=5;i++)
		{
			starCount=constant*i;
			model=model.concat("\n"+star.repeat(starCount));
		}
			System.out.println(model);
		
	}

}
