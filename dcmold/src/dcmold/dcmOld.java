package dcmold;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.dcm4che2.net.ConfigurationException;

public class dcmOld {

	//public static final String datefrom = "20000101";

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		
		StringBuffer help = new StringBuffer();
		help.append(" \n");
		help.append("Usage:\n");
		help.append("   dcmOld <REMOTE> <MODALITY> <DATE> <0|1>\n\n");
		help.append("Options:\n");
		help.append("   <REMOTE> DCM4SCOLL1@192.168.56.101:11112\n");
		help.append("   <MODALITY> modality in study\n");
		help.append("   <DATE> search cases from a date to another date (included) format: YYYYMMDD-YYYYMMDD\n");
		help.append("   <0|1> 1 = print only StudyInstanceUID\n");
		help.append("\n");
		help.append("Example:\n");
		help.append("   dcmOld DCM4SCOLL1@192.168.56.101:11112 US 20051231-20060201 0\n");
		
		if ( args.length !=4 ){
			System.out.println(help);
			System.exit(1);
		}
		
		
		String remote = args[0]; //"DCM4SCOLL1@192.168.56.101:11112";
		String modality = args[1]; //"US";
		String date = args[2]; // "20060101";
		int suidonly = Integer.parseInt(args[3]);
		
		//System.out.println(remote + " " + date + " " + modality + " " + suidonly);
		
		query action = new query(date, remote, modality);

		ArrayList<String> risultato = null;
	
		try {
			
			    risultato = action.doit();
			    
			    Iterator<String> risultatoIterator = risultato.iterator();
			    
			    String stringa;
			    
				while ( risultatoIterator.hasNext()) {
					
					stringa = risultatoIterator.next();
									
					if ( suidonly == 0 ) {
						System.out.println(stringa);
						
					} else if ( suidonly == 1 ) {
						
						int i = stringa.lastIndexOf('|');
						String buffer = stringa.substring(i+1);
						System.out.println(buffer);
						
					} else {
						System.out.println(help);
						System.exit(1);
					}
				}
			    
				if ( suidonly == 0 ) {
					//System.out.println("\nTotal studies for " + modality + " from " + datefrom + " to " + date + ": " + risultato.size());
					System.out.println("\nTotal studies for " + modality + " between " + date + ": " + risultato.size());
				}
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
