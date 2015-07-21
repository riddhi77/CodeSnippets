import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class SocialGraph {

	/**
	 * @param args
	 */
	final static String startNode="B";
	static HashMap<String,ArrayList> FriendMap= new HashMap<String, ArrayList>();
	static HashSet<String> FriendSet=new HashSet<String>();
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String friends[]={"A:B,C,D",
				          "B:A,D,E",
				          "C:E,B,F",
				          "F:G,H",
				          "H:I,A,B,C"
				         };
		
		FriendMap=generateSocialgraph(friends);
		System.out.println("hash map"+FriendMap);
		traversegraph(startNode);
		
		
		
	}

	private static HashMap generateSocialgraph(String[] friends) {
		// TODO Auto-generated method stub
		for(String f:friends)
			{
		       String keyvalue[]=f.split(":");
		       String values[]=keyvalue[1].split(",");
		       ArrayList<String> fof=new ArrayList<String>();
		       for(String v:values)
		    	   fof.add(v);
		       FriendMap.put(keyvalue[0],fof);
			}
		return FriendMap;	
	}
	@SuppressWarnings("null")
	private static void traversegraph(String start)
	{	
		Queue<String> q=new LinkedList();
		q.add(start);
		
				while(!q.isEmpty())
				{
				
				start=(String) q.remove();	
				//System.out.println(FriendMap.get(start));
				if(!FriendMap.containsKey(start))
				{
					//q.remove();
					continue;
				}
				Iterator it1=FriendMap.get(start).iterator();
				
				while(it1.hasNext())
				{
					String ff=it1.next().toString();
					if(!ff.matches(startNode) && !FriendSet.contains(ff))
					{   
						FriendSet.add(ff);
						q.add(ff);
					}
					
				}	
				System.out.println("Queue" + q);
				}
	
				
	
	System.out.println("FriendSet" +FriendSet);
			
				
}			
			
}
