package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Parser {
	
	public static void main(String[] args) {
		
//		String value = "RESP:0:SUBSCRIPTIONRESPONSE,\"HLRSN,1:IMSI,612051450128621:ISDN,22576375305:CardType,USIM:NAM,BOTH:CATEGORY,COMMON:SABLOCK:BasicService:Telephony(TS11):EmergencyCall(TS12):ShortMessageMT_PP(TS21):ShortMessageMO_PP(TS22):General-DataCDS:(BS30):DefaultCall,Telephony(TS11):ODBData:ODBPB1,TRUE:ODBROAM,BROHPLMN:ODBPOS,BHPLMNAPROAM:SSData:CFU,PROV:CFNRC,PROV:BAOC,PROV:BOIC,PROV:BOICEXHC,PROV:BAIC,PROV:BICROAM,PROV:CLIP,PROV:CLIR,PROV:CW,PROV:HOLD,PROV:plmn-specificSS-A,PROV:CCBSTARGET,PROV:O-CSI:TPLID,29:STATE,TRUE:T-CSI:TPLID,29:STATE,TRUE:MO-SMS-CSI:TPLID,31:STATE,TRUE:GPRS-CSI:TPLID,29:STATE,TRUE:U-CSI:TPLID,29:VLR/SGSNRoamingRestrict:VLRLIST,10:SGSNLIST,20:GPRSData:CNTXID,1:APN,WEB.MTN.CI:CNTXID,2:APN,WAP.MTN.CI:CNTXID,3:APN,MMS.MTN.CI:EPSData:CNTXID,1:APNTPLID,2:SMDP,MSC:ARD,PROV:RROption,ONE_NPLMN_ALL_FPLMNS:SMSINAPService:SKEY,0\";";
//		
//		
//		int index = value.indexOf("ODBROAM")+8;
//		
//		String finals="";
//		while(value.charAt(index) != ':') {
//			finals = finals + value.charAt(index);
//			index++;
//		}
//		System.out.println(finals);

		 Scanner s = new Scanner(System.in);
	        int N = s.nextInt();

	        for (int i = 0; i < N; i++) {
	            String st = s.next();
	            int count = 0;
	            HashSet<String> al = new HashSet<String>();
	            for(int j =0 ;j<st.length()/2;j++){
	            	
	               String con = st.charAt(st.length()-1)+st.substring(0,st.length()-1);
	               if(!al.contains(con)) {
	            	   count++;
	            	   al.add(con);
	               }
	               else
	            	   break;
	            st = con;  
	            }
	            if(count == st.length()/2)
	            	count = count *2 ;
	            System.out.println(count);
	            al =new HashSet<String>();
	        }
	        
	
	}

}
