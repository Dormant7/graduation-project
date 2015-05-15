package gsp;

//package gsp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeqDB {
	 private ArrayList<Sequence> seqs;  //序列对象
	  public SeqDB() { 
	 this.seqs = new ArrayList<Sequence>();

  /* Sequence s;
   //<{1 5}{2}{3}{4}>

   s = new Sequence();*/

 /*  s.addElement(new Element(new int[] {1, 5}));

   s.addElement(new Element(new int[] {2}));

   s.addElement(new Element(new int[] {3}));

   s.addElement(new Element(new int[] {4}));

   seqs.add(s);*/
   //System.out.println("neirong"+s);

   Pattern p=Pattern.compile("(\\d+)");//正则表达式，验证是否是数字	
		File fRead =new File("d:\\word.txt");//从文本中读取
		try{
			Reader in =new FileReader(fRead);
			BufferedReader bufferRead =new BufferedReader(in);
			String str =null;
			while((str=bufferRead.readLine())!=null){
				 Sequence s;
			     s = new Sequence();
				//System.out.println(str);
				Matcher m=p.matcher(str); 
				while(m.find()) {  
					int find=Integer.parseInt(m.group(1).toString()); 
					s.addElement(new Element(new int[] {find}));  
					}
				seqs.add(s);
				//System.out.println("序列有"+s);
			}
			
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
   
   
   
   
   //<{1}{3}{4}{3 5}>

//   s = new Sequence();
//
//   s.addElement(new Element(new int[] {1}));
//
//   s.addElement(new Element(new int[] {3}));
//
//   s.addElement(new Element(new int[] {4}));
//
//   s.addElement(new Element(new int[] {3, 5}));
//
//   seqs.add(s);
//
//   //<{1}{2}{3}{4}>
//
//   s = new Sequence();
//
//   s.addElement(new Element(new int[] {1}));
//
//   s.addElement(new Element(new int[] {2}));
//
//   s.addElement(new Element(new int[] {3}));
//
//   s.addElement(new Element(new int[] {4}));
//
//  seqs.add(s);
//
//   //<{1}{3}{5}>
//
//   s = new Sequence();
//
//   s.addElement(new Element(new int[] {1}));
//
//   s.addElement(new Element(new int[] {3}));
//
//   s.addElement(new Element(new int[] {5}));
//
//   seqs.add(s);
//
//   //<{4}{5}>
//
//   s = new Sequence();
//
//   s.addElement(new Element(new int[] {4}));
//
//
//
//   s.addElement(new Element(new int[] {4,5}));
//
//   seqs.add(s);

}



/**

* 获取序列集的大小

* 也就是获取有几个序列

* @return         序列集大小

*/

public int size(){

   return this.seqs.size();

}
   /**

* 获取序列集

* @return               序列集

*/

public ArrayList<Sequence> getSeqs(){

   return this.seqs;

}


}
