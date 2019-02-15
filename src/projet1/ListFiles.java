package projet1;

import java.io.File;

public class ListFiles {

	public static void main(String[] args) {
		File folder = new File("C:\\Users\\mcassin\\Desktop\\BRIQUEDSN\\Bilans\\DSNBT");
		File DSNVL32 = new File("C:\\Users\\mcassin\\Desktop\\BRIQUEDSN\\Bilans\\DSNVL32");
		File DSNVL64 = new File("C:\\Users\\mcassin\\Desktop\\BRIQUEDSN\\Bilans\\DSNVL64");
		File DSNVW32 = new File("C:\\Users\\mcassin\\Desktop\\BRIQUEDSN\\Bilans\\DSNVW32");
		File DSNVW64 = new File("C:\\Users\\mcassin\\Desktop\\BRIQUEDSN\\Bilans\\DSNVW64");
		File[] listOfFilesBT = folder.listFiles();
		File[] listOfFilesDSNVL32 = DSNVL32.listFiles();
		File[] listOfFilesDSNVL64 = DSNVL64.listFiles();
		File[] listOfFilesDSNVW32 = DSNVW32.listFiles();
		File[] listOfFilesDSNVW64 = DSNVW64.listFiles();

		for (int i = 0; i < listOfFilesBT.length; i++) {
		  if (listOfFilesBT[i].isFile()) {
		    System.out.println("File " + listOfFilesBT[i].getName());
		  } else if (listOfFilesBT[i].isDirectory()) {
		    System.out.println("Directory " + listOfFilesBT[i].getName());
		  }
		}
		
		System.out.println("----------------------------------------------------------------");
		
		for (int i = 0; i < listOfFilesDSNVL32.length; i++) {
			  if (listOfFilesDSNVL32[i].isFile()) {
			    System.out.println("File " + listOfFilesDSNVL32[i].getName());
			  } else if (listOfFilesDSNVL32[i].isDirectory()) {
			    System.out.println("Directory " + listOfFilesDSNVL32[i].getName());
			  }
			}
		
		System.out.println(listOfFilesBT.equals(listOfFilesDSNVL32));
		System.out.println(listOfFilesBT);

	}

}
