
/*
 * Name: Rahul Rajaram
 * Project 02: Roommate Compatibility Program 
 * CSE-021-01, Spr 2019
*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Match
{
	private static Student[] allStudents = new Student[100];

	public static void main(String[] args)
	{
		String n = " ";
		String g = " ";
		char gen = ' ';
		String d;
		int pQT;
		int pM;
		int pR;
		int pC;

		int numOfStudents = 0;

		String filename = "./Students.txt";
		//String filename = "./FullRoster.txt";

		try
		{ // TRY it out
			Scanner input = new Scanner(new FileReader(filename));

			input.useDelimiter("[\t\r]"); // Tab (\t) and/or carriage return (\r) delimited file

			while (input.hasNext())
			{
				// System.out.println(input.next()); // Print each word in file

				n = input.next().trim();
				g = input.next().trim();
				gen = g.charAt(0);
				d = input.next().trim();
				pQT = Integer.parseInt(input.next());
				pM = Integer.parseInt(input.next());
				pR = Integer.parseInt(input.next());
				pC = Integer.parseInt(input.next());

				// Splitting date string by -
				String[] dat = d.split("-");

				// typecasting month, day and year from string to int
				int m = Integer.parseInt(dat[0]);
				int day = Integer.parseInt(dat[1]);
				int yr = Integer.parseInt(dat[2]);

				// created Date object and calling constructor
				Date date = new Date(m, day, yr);

				// created Preference object and calling constructor
				Preference pref = new Preference(pQT, pM, pR, pC);

				// Create Student object and increment count
				// String n, char g, boolean m, Preference p, Date bd
				Student student = new Student(n, gen, false, pref, date);
				allStudents[numOfStudents] = student;
				numOfStudents++;
			}
			input.close();
		} catch (FileNotFoundException e)
		{ // Catch Error
			System.out.println(e);
		} catch (NoSuchElementException e)
		{ // Catch Error
			System.out.println(e);
		}

		// System.out.println("Total number of students: "+numOfStudents);

		for (int i = 0; i < numOfStudents; i++)
		{
			Student studentA = allStudents[i];
			if (studentA == null || studentA.isMatched())
				continue;

			int maxScore = 0;
			int currentScore = 0;
			Student bestMatchStudent = null;

			for (int j = 0; j < numOfStudents; j++)
			{
				Student studentB = allStudents[j];

				if (studentB == null || studentB.equals(studentA) || studentB.isMatched())
					continue;

				currentScore = studentA.compare(studentB);

				if (currentScore > maxScore)
				{
					bestMatchStudent = studentB;
					maxScore = currentScore;
				}
			}
			if (bestMatchStudent == null)
			{
				System.out.println(studentA.getName() + " has no matches.");
			} else
			{
				bestMatchStudent.setMatched(true);
				studentA.setMatched(true);
				System.out.println(studentA.getName() + " matches with " + bestMatchStudent.getName() + " the score " + maxScore);
			}
		}

	}

}
