// Program to print the Gregorian Calendar of any month

import java.util.Scanner;
class Mahina
{
	Mahina() {}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Everything according to Gregorian Calendar");
		String padding = "\n   ", yy = new String(), mm = new String(), monthDay[][] = {{"January","February","March","April","May","June","July","August","September","October","November","December"},/*
	
	
		CHANGE THE NAMES AND ORDER OF DAYS AS YOU WISH
		*/{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"}};
	
	
		int flag = -2, sum, odd, month, year, i, days[] = {31,0,31,30,31,30,31,31,30,31,30,31};
		char repeat = 'y';
		while(repeat == 'y' || repeat == 'Y')
		{
			if(flag > -2)
				sc.nextLine();
			if(flag == -1)
				repeat = 'n';
			sum = 0;
			odd = 1;
			year = 0;
			flag = 1;
			month = 0;
			System.out.println("\nWhich year ?");
			yy = sc.nextLine().trim();
			for(i=0;i<yy.length();i++)
				if(yy.charAt(i)>47 && yy.charAt(i)<58)
					year = year*10 + yy.charAt(i) - 48;
				else {
					flag = 0;
					break;
				}
			if(flag==1 && year>1581 && year<4000) {
				for(i=year,yy="";i>0;i/=10)
					yy = (char)(i%10 + 48) + yy;
				if(repeat == 'y' || repeat == 'Y') {
					System.out.println();
					repeat = 'n';
					for(i=0;i<12;i++)
						System.out.println("   "+(i+1)+". "+(i<9 ? " " : "")+monthDay[0][i]);
				}
				System.out.println("\nWhich month ?");
				mm = sc.nextLine().trim();
				for(i=0;i<mm.length();i++)
					if(mm.charAt(i)>47 && mm.charAt(i)<58)
						month = month*10 + mm.charAt(i) - 48;
					else {
						flag = 0;
						break;
					}
				if(flag==0 && mm.length()>2 && month==0)
					for(i=0;i<12;i++)
						if(monthDay[0][i].toLowerCase().startsWith(mm.toLowerCase())) {
							month = i + 1;
							flag = 1;
							break;
						}
				if((month>9 || (year!=1582 && month>0)) && month<13 && flag==1) {
					days[1] = (year%400==0 || (year%4==0 && year%100!=0)) ? 29 : 28;
					odd = (int)(((--year)%400)/4 + year%400 - (year%400)/100);
					for(i=0;i<month-1;i++)
						odd += days[i];
					for(i=0;i<7;i++) {
						monthDay[1][i] = monthDay[1][i].trim();
						if(monthDay[1][i].length() < 2)
							monthDay[1][i] = " " + monthDay[1][i];
						sum += monthDay[1][i].length();
					}
					for(i=0;i<7;i++)
						if(monthDay[1][i].charAt(0)==77 || monthDay[1][i].charAt(0)==109 || monthDay[1][i].charAt(1)==77 || monthDay[1][i].charAt(1)==109)
							break;
					odd = (odd + i) % 7;
					sum = (sum - monthDay[0][month-1].length() - yy.length() + 5)/2;
					System.out.print(padding);
					while(sum-- > 0)
						System.out.print(" ");
					System.out.print(monthDay[0][month-1]+" "+yy);
					System.out.print(padding);
					for(i=0;i<7;i++)
						System.out.print(monthDay[1][i]+" ");
					System.out.print(padding);
					for(i=0;i<odd;i++) {
						sum = monthDay[1][i].length()/2;
						sum += i>0 ? (monthDay[1][i-1].length() + 1)/2 : 0;
						while(sum-- > 1)
							System.out.print(" ");
						System.out.print("  ");
					}
					for(i=1;i<=days[month-1];i++) {
						sum = monthDay[1][odd].length()/2;
						sum += odd>0 ? (monthDay[1][odd-1].length() + 1)/2 : 0;
						while(sum-- > 1)
							System.out.print(" ");
						System.out.print(i<10 ? " "+i : i);
						odd = ++odd % 7;
						if(odd==0)
							System.out.print(padding);
					}
				}
				else {
					if(mm.length()==0)
						System.out.print("No input !");
					else {
						System.out.print("\nInvalid month : " + mm);
						if(flag==1) {
							if(month>12)
								System.out.print("\n(must be smaller than 13)");
							if(month==0)
								System.out.print("\n(must be greater than 0)");
							else if(month<10 && year==1582)
								System.out.print("\nGregorian Calendar was introduced in October");
						}
					}
				}
			}
			else {
				if(yy.length()==0)
					System.out.print("No input !");
				else {
					System.out.print("\nInvalid year : "+yy);
					if(flag==1 && year>0) {
						if(year<1582)
							System.out.print("\nGregorian Calendar was introduced in year 1582");
						if(year>3999)
							System.out.print("\nGregorian Calendar would have changed by this time");
					}
				}
			}
			if(repeat == 'n')
				flag = -1;
			System.out.println((odd%7!=0 ? "\n" : "") + "\nAgain ? [Y/n]");
			repeat = sc.next().charAt(0);
		}
		sc.nextLine();
		System.out.println("\nPress ENTER to EXIT");
		yy = sc.nextLine();
		System.exit(0);
	}
}
