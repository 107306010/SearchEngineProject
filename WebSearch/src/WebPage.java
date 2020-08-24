
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	public String time;
	public int timescore;
	

		public WebPage(String url, String name, String time) {
			this.url = url;
			this.name = name;
			this.time = time;
			this.counter = new WordCounter(url);
		}

		public void timeInt() throws ParseException {
			try {
				Date today = new Date();
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");       
			    //today=s.parse(s.format(today));	
			    Date theDate=s.parse(time);
			    System.out.println(today);
			    System.out.println(theDate);
			    long dd=(today.getTime()-theDate.getTime())/(1000*3600*24);
			    System.out.println(dd);
			    if ((dd/10)<1) {
			    	timescore=timescore+200;
			    	if (dd==0) {
			    		timescore=timescore+300;
					}else if (dd==1) {
						timescore=timescore+250;
					}else if (dd==2) {
						timescore=timescore+200;
					}else if (dd==3) {
						timescore=timescore+50;
					}else {
						timescore=timescore+30;
					}
			    }else if ((dd/10)==1) {
			    	timescore=timescore+20;
			    	if (15<=dd&&dd<=10) {
			    		timescore=timescore+20;
					}else if (20>=dd&&dd>15) {
						timescore=timescore+10;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(" ");
			}

		}
	 
	 public int findLCS(String x, String y) {
		int[][] L = new int[x.length()+1][y.length()+1];
		for(int i=0; i<x.length(); i++) {
			L[i][0] = 0;
		}
		for(int j=0; j<y.length(); j++) {
			L[0][j] = 0;
		}
		for(int i=1; i<x.length(); i++) {
			for(int j=1; j<y.length(); j++) {
				if(x.charAt(i)==y.charAt(j)) {
					L[i][j] = L[i-1][j-1] + 1;
				}
				else {
					L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
				}
			}
		}
			return L[x.length()-1][y.length()-1];
		}
	 
	 public void setScore(ArrayList<Keyword> keywords) throws IOException, ParseException {
		  try {
		   timeInt();
		   score = 0;
		   for (Keyword k : keywords) {
		    
		    score += counter.countKeyword(k.name) * k.weight + timescore+200*findLCS(k.toString(),name);
		   }
		  } catch (Exception e) {
		   // TODO: handle exception
		   System.out.print(" ");
		  }
		 }
	
}

