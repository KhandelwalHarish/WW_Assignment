package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;



public class ReadTheFileContentsTest {


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		// Getting the Project path
		String projectPath = System.getProperty("user.dir");

		// Getting the path of the text file relative to the project
		String path =projectPath+"/src/test/resources/readContents.txt";

		//Calling the method and validating if the text file exists
		try {
			doesFileExist(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Dict> allWordMeanings = new LinkedList<Dict>();


		BufferedReader br =null;
		String line;
		try {

			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {

			while ((line = br.readLine()) != null) {
				Dict wordMeaning;
				//Splitting the line based on "-"
				String[] values = line.split("-");
				//Again splitting the line based on ","
				String[] meanings = values[1].split(",");

				if(meanings.length == 2) {
					wordMeaning = new Dict(values[0].trim(), meanings[0].trim(), meanings[1].trim());
				}
				else {
					wordMeaning = new Dict(values[0].trim(), meanings[0].trim(), "");
				}

				allWordMeanings.add(wordMeaning);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();
		//Printing the result
		for (Dict d : allWordMeanings) {
			d.Print();
			System.out.println("********************");
		}
	}
	//Method to validate if the file exist at the project location
	public static void doesFileExist(String path) throws IOException {

		File tempFile = new File(path);
		boolean exists = tempFile.exists();
		System.out.println("File exists : " + exists);
	}
}
