package projet1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class EssaiCompare {

	public static void main(String[] args) throws IOException {
		
		String pathFileResult = null;
		Path pathFichier = null;
		List<String> lignes = null;
		String resFinalAssert = "";
		String resFinalLogs="</br>";
		String titreAbsenceFile = "<fieldset><legend><h3>Controler la pr�sence des fichiers</h3></br><ul>";
		String titreAbsenceSentence = "<fieldset><legend><h3>Contr�ler la toto pr�sence des phrases</h3></br><ul>";
		String titreNormeXml = "<fieldset><legend><h3>Controler la norme du fichier XML</h3></legend></br><ul>";
		

		//Le chemin du fichier
		//pathFileResult = "C:\\Users\\melbannani\\Desktop\\AUTOMATISATION\\BRIQUEDSN\\fileResult.txt";
		pathFileResult = "C:\\Users\\mcassin\\Desktop\\BRIQUEDSN\\fileResult.txt";
				
		lignes = readFileResultForLogs(pathFileResult);
		        
		// afficher les lignes de mon fichier
		
	
		 resFinalAssert = readFileResulForAssert(lignes);
	

		if(resFinalAssert.contains("fichierAbsentKO")){resFinalLogs=titreAbsenceFile+generateLogsAbsenceFile(lignes)+"</fieldset></br>";}
		if(resFinalAssert.contains("phraseAbsenteKO")) {resFinalLogs=resFinalLogs+titreAbsenceSentence+generateLogsAbsenceSentences(lignes)+"</fieldset></br>";}
		if(resFinalAssert.contains("fichierNorme_KO")) {resFinalLogs=resFinalLogs+titreNormeXml+generateLogsXmlNorme(lignes)+"</fieldset></br>";}
		
		
		
		Assert.assertFalse(resFinalLogs,mettreAjourSquash(resFinalAssert,resFinalLogs));
		//System.out.println(resFinalLogs);
		//System.out.println(generateLogsAbsenceFile(lignes));
		//System.out.println(generateLogsAbsenceSentences(lignes));
		//System.out.println(generateLogsXmlNorme(lignes));
		
		
		

	}
	
	public static String generateLogsAbsenceFile(List<String> mLignes){
		String resAbsenceFile ="";
		for (String string : mLignes) {
		  if(string.contains("fichierAbsentKO")){
			  resAbsenceFile =resAbsenceFile+ string.substring(18)+"</br>";
		  } 
		}
		return resAbsenceFile;
	}
	
	public static String generateLogsAbsenceSentences(List<String> mLignes){
		String resAbsenceSentences ="";
		for (String string : mLignes) {
		  if(string.contains("phraseAbsenteKO")){
			  resAbsenceSentences = resAbsenceSentences+string.substring(18)+"</br>";
		  } 
		}
	
		return resAbsenceSentences;
	}
	
	public static String generateLogsXmlNorme(List<String> mLignes){
		String resXmlNorme ="";
		for (String string : mLignes) {
		  if(string.contains("fichierNorme_KO")){
			  resXmlNorme = resXmlNorme+string.substring(18)+"</br>";
		  } 
		}
		return resXmlNorme;
	}
	

	public static boolean mettreAjourSquash(String mTexteVerif,String mMessageSquash){
		boolean trouve = false;
		
		if(mTexteVerif.contains("fichierAbsentKO") || mTexteVerif.contains("phraseAbsenteKO") ||  mTexteVerif.contains("fichierNorme_KO")){
			trouve = true;
		} 
		return trouve;
	}

	public static List<String> readFileResultForLogs(String mPathFileResult) throws IOException{
		List<String> lignes = new ArrayList<String>();
		// R�cup�rer le chemin de mon fichier
		Path pathFichier = Paths.get(mPathFileResult);
				
		// lire et stocker les lignes de mon fichier
		lignes.addAll(Files.readAllLines(pathFichier , Charset.forName("ISO-8859-1")));
		
		return lignes;
	}
	
	public static String readFileResulForAssert(List <String> listeLogs){
		String resFinalAssert = "";
		for (String string : listeLogs) {
			 resFinalAssert = resFinalAssert + string+" ";
			}

	return resFinalAssert;
	}
}
