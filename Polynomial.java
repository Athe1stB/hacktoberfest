//Program to find roots of polynomials upto 4 degrees

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Polynomial
{
	static double p,q,r,s,y;
	static String x;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Polynomial() {
		p=0;q=0;r=0;s=0;y=0;x="";
	}
	public static void main(String args[]) throws IOException
	{
		while(true) {
			if(x==" ") System.out.println("\nInvalid Input");
			if(x==" "||x=="  ") {
				System.out.println("\nAgain ? [Y/n]");
				x = br.readLine();
				if(x=="" || (x.charAt(0)!='y' && x.charAt(0)!='Y')) System.exit(1);
				System.out.println();
			}
			double a,b,c,d,e=0;
			System.out.println("Enter coefficient of term with power 4");
			in(); if(x==" ") continue; else a = y;
			System.out.println("Enter coefficient of term with power 3");
			in(); if(x==" ") continue; else b = y;
			System.out.println("Enter coefficient of term with power 2");
			in(); if(x==" ") continue; else c = y;
			System.out.println("Enter coefficient of term with power 1");
			in(); if(x==" ") continue; else d = y;
			if(a==0&&b==0&&c==0&&d==0) System.out.println("\nNothing to calculate :/");
			else {
				System.out.println("Enter the constant term");
				in(); if(x==" ") continue; else e = y;
				if(a==0&&b==0&&c==0) System.out.print("\nRoot of  ");
				else System.out.print("\nRoots of  ");
				if(a!=0) System.out.print(a>0?(a+"x^4 "):("- "+(-a)+"x^4 "));
				if(b!=0) System.out.print(b>0?((a!=0?"+ ":"")+b+"x^3 "):("- "+(-b)+"x^3 "));
				if(c!=0) System.out.print(c>0?((b!=0||a!=0?"+ ":"")+c+"x^2 "):("- "+(-c)+"x^2 "));
				if(d!=0) System.out.print(d>0?((c!=0||b!=0||a!=0?"+ ":"")+d+"x "):("- "+(-d)+"x "));
				if(e!=0) System.out.print(e>0?((d!=0||c!=0||b!=0||a!=0?"+ ":"")+e+" "):("- "+(-e)+" "));
				System.out.print("= 0   :\n ");
			}
			if(a!=0) quartic(a,b,c,d,e);
			else if(b!=0) cubic(b,c,d,e,a);
			else if(c!=0) quadratic(c,d,e);
			else if(d!=0) linear(d,e);
			x = "  ";
		}
	}
	static void in () throws IOException {
		x = br.readLine().trim();
		if(x.equals("")) x = "0";
		if(x.charAt(0)=='-') x = "-" + x.substring(1).trim();
		try {y = Double.parseDouble(x);}
		catch (Exception e) {x = " ";}
	}
	static void linear (double a,double b) {
		System.out.println("\n "+(-b/a));
	}
	static void quadratic (double a,double b,double c) {
		double d = b*b-4*a*c;
		if(d>0) System.out.println("\n "+((-b+Math.sqrt(d))/2/a)+"\n "+((-b-Math.sqrt(d))/2/a));
		else if(d<0) System.out.println("\n "+(-b/2/a)+" + i*"+(Math.sqrt(-d)/2/a)+"\n "+(-b/2/a)+" - i*"+(Math.sqrt(-d)/2/a));
		else System.out.println("\n both equal to "+(-b/2/a));
	}
	static void cubic (double a,double b,double c,double d,double e) {
		double f,g,l=0,m=0,n=0;
		f = (3*c/a-b*b/a/a)/3;
		g = (2*b*b*b/a/a/a-9*b*c/a/a+27*d/a)/27;
		s = g*g/4+f*f*f/27;
		if (s>0) {
			l = g/2-Math.sqrt(s);
			m = l>0 ? -Math.pow(l,1.0/3) : Math.pow(-l,1.0/3);
			l = l-g;
			n = l>0 ? Math.pow(l,1.0/3) : -Math.pow(-l,1.0/3);
			p = m+n-b/3/a;
			q = -(m+n)/2-b/3/a;
			r = Math.abs((m-n)*Math.sqrt(3)/2);
			if(e==0) System.out.println("\n "+p+"\n "+q+" + i*"+r+"\n "+q+" - i*"+r);
		}
		else if(f==0 && g==0) {
			p=-b/3/a;q=p;r=q;
			if(e==0) System.out.println(p);
		}
		else {
			l = -Math.pow(Math.sqrt(g*g/4-s),1.0/3);
			m = Math.cos((Math.acos(-g/2/Math.sqrt(g*g/4-s)))/3);
			n = Math.sqrt(3)*Math.sin((Math.acos(-g/2/Math.sqrt(g*g/4-s)))/3);
			p = -2*l*m-b/3/a;
			q = l*(m+n)-b/3/a;
			r = l*(m-n)-b/3/a;
			if(e==0) System.out.println("\n "+p+"\n "+q+"\n "+r);
		}
	}
	static void quartic (double a,double b,double c,double d,double e) {
		double f,g,h;
		b/=a;c/=a;d/=a;e/=a;a=1;
		f = c-3*b*b/8;
		g = d+b*b*b/8-b*c/2;
		h = e-3*b*b*b*b/256+c*b*b/16-b*d/4;
		cubic(1,f/2,(f*f-4*h)/16,-g*g/64,1);
		f=p;h=r;
		p = Math.max(p,Math.max(q,r));
		r = Math.min(f,Math.min(q,r));
		q = f+h+q-p-r;
		if(p==0&&q==0&&r==0) {
			System.out.println("\n all equal to "+(-b/4));
		}
		else if(s>0) {
			q = Math.sqrt((q+Math.sqrt(q*q+r*r))/2);
			r = Math.abs(r/2/q);
			p = -g/8/(q*q+r*r);
			System.out.println("\n "+(2*q+p-b/4)+"\n "+(-2*q+p-b/4)+"\n "+(-p-b/4)+" + i*"+(2*r)+"\n "+(-p-b/4)+" - i*"+(2*r));
		}
		else if(q>0) {
			p = Math.sqrt(p);
			q = Math.sqrt(q);
			r = -g/8/p/q;
			System.out.println("\n "+(p+q+r-b/4)+"\n "+(p-q-r-b/4)+"\n "+(-p-q+r-b/4)+"\n "+(-p+q-r-b/4));
		}
		else {
			r = Math.sqrt(-r);
			if(p>0) {
				p = Math.sqrt(p);
				q = -g/8/p/r;
			}
			else {
				q = Math.sqrt(-q);
				p = -g/8/r/q;
			}
			p = p-b/4;
			s = -b/2-p;
			q = Math.abs(q+r);
			r = Math.abs(q-2*r);
			System.out.println("\n "+p+" + i*"+r+"\n "+p+" - i*"+r+"\n "+s+" + i*"+q+"\n "+s+" - i*"+q);
		}
	}
}