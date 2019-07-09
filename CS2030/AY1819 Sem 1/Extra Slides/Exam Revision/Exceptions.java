import java.io.*;
import javax.print.*;

class Exceptions {
	public static void main(String[] args) {
		// No Catch between Try and Finally
		// Finally before Catch
		try {
			try {
				throw new RuntimeException();
			} finally {
				System.err.println("Finally 1");
			}
		} catch (Exception e) {
			System.err.println("Catch 1");
		}

		// What is the output?
		try {
			System.out.println("Try main");
			f();
		} catch (Exception e) {
			System.err.println("Catch main");
		}
		System.out.println("After main");
	}

	static void f() throws Exception {
		try {
			System.out.println("Try f");
			g();
		} catch (IOException e) {
			System.err.println("Catch f");
		}
		System.out.println("After f");
	}

	static void g() throws Exception {
		try {
			System.out.println("Try g");
			if (true) 
				throw new IOException();
			else
				throw new PrintException();
		} catch (PrintException e) {
			System.err.println("Catch g");
		} finally {
			System.err.println("Finally g");
		}
		System.out.println("After g");
	}
}