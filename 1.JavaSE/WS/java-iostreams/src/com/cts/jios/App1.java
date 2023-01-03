package com.cts.jios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("File Name: ");
		String fileName = scan.next();
		
		Path filePath = Paths.get(fileName);
		
		System.out.println("Enter file content (type '*STOP*' to stop entering): ");
		
		List<String> lines = new ArrayList<String>();
		
		String line = new String();
		while(!"*STOP*".equalsIgnoreCase(line)) {
			line = scan.nextLine();
			if("*STOP*".equalsIgnoreCase(line)) {
				continue;
			}
			lines.add(line);
		}
		
		try {
			Files.write(filePath, lines);
			System.out.println("File got saved");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		scan.close();
	}

}
