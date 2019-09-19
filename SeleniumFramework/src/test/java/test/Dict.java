package test;

public class Dict {

	public String word;
	public String meaning1;
	public String meaning2;

	public Dict(String wrd, String mean1, String mean2) {
		word = wrd;
		meaning1 = mean1;
		meaning2 = mean2;
	}

	public void Print()
	{
		System.out.println(word);
		System.out.println(meaning1);
		System.out.println(meaning2);
	}

}
