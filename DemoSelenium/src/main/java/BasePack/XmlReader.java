package BasePack;




import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {
	
	
	DocumentBuilderFactory dfact;
	DocumentBuilder builder;
	Document doc;
	NodeList nodeL;
	Node node;
	Element eList;
	
	
	public String getCurrentMethodName()
	{
		
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
	public Object getStackStrashInfo()
	{
		return Thread.currentThread().getStackTrace()[2].getClassName();
	}
	public XmlReader getReader(final Class<?> classz)
	{
		return this.getReader(classz.getClass());
	}
	private Throwable currentThread() {
		// TODO Auto-generated method stub
		return null;
	}

	public void readMe(String fieName,String tagName,int tagIndex,String attribute) throws Exception
	{
		String nodes[];
		File f=new File(fieName+".xml");
		dfact=DocumentBuilderFactory.newInstance();
		builder=dfact.newDocumentBuilder();
		doc=builder.parse(f);
		
		String rootElement=doc.getDocumentElement().getNodeName();
		System.out.println("Root Node is :"+rootElement);
		
		NodeList nList=doc.getElementsByTagName(tagName);		
		Node nNode=nList.item(tagIndex);
		System.out.println("Node name is "+nNode.getNodeName());
		
		
		if(nNode.getNodeType()==Node.ELEMENT_NODE)
		{
			Element ele=(Element)nNode;
			System.out.println("Element with id value="+ele.getAttribute(attribute));
		}
			
		
	}
	
	
	public static void main(String args[])
	{
		
		
		XmlReader r=new XmlReader();
		
		try {
			r.readMe("MyXml", "mv:MemberId",1, "id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	System.out.println("Method Name is:"+r.getCurrentMethodName());
	System.out.println("Stack trash info is :"+r.getStackStrashInfo());
	System.out.println("Current Time in Miliseccond: "+System.currentTimeMillis());
		
	}

}
