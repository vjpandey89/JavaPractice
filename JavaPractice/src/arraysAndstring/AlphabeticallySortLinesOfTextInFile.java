package arraysAndstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabeticallySortLinesOfTextInFile {

	public static void main(String[] args) throws Exception {

		

	
		String []inputLine={"al 9 2 3 1","g1 Act car","zo4 4 7","abl off KEY dog","a8 act zoo"};
		List<String> lineList = new ArrayList<String>();
		for(int i=0;i<inputLine.length;i++)
			lineList.add(inputLine[i]);
		List<String> listResult=logProcessor(lineList);
		
		for(String str:listResult)	
			System.out.println(str+" ");
		
		
	}
	public static List<String> logProcessor (List<String> list){
        List<String> strAlp = new ArrayList<String>();
        List<String> strNum = new ArrayList<String>();
        List<String> AlpNum = new ArrayList<String>();

        for( String sl :  list){
            String[] slPart = sl.split(" ", 2);
            if(Character.isDigit(slPart[1].charAt(0))){
                strNum.add(sl);
            }
            else {
                strAlp.add(slPart[1].concat(" " + slPart[0]));
            }
        }
        Collections.sort(strAlp);
        for(String sl2 : strAlp){
            String[] part = {sl2.substring(0,sl2.lastIndexOf(" ")), sl2.substring(sl2.lastIndexOf(" ") + 1)};
            AlpNum.add(part[1].concat(" " + part[0]));
        }
        AlpNum.addAll(strNum);
        return AlpNum;
    }
}