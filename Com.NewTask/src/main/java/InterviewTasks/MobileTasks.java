package InterviewTasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MobileTasks {
	
	static List<String> containsDuplicate(List<String> li)
	{
		
	
		List<String>list=li.stream()
	    .filter(e -> Collections.frequency(li, e) > 1)
	    .distinct()
	    .collect(Collectors.toList());
		return list;
		
	}

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\Task2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("GameList");
		 
		XSSFSheet answerSheet = wb.getSheet("Answers");
		 int rowcount = sheet.getLastRowNum();
		 
		 System.out.println(" Total number of rows present in the sheet : "+rowcount);
		 
		 
		 int colcount = sheet.getRow(1).getLastCellNum();
		 System.out.println(" Total number of columns present in the sheet : "+colcount);
		 
		 XSSFCell cell1;
		 XSSFCell cell2;
		 String celltext1="";
		 String cellText2="";
		 List<String>  companyList=new ArrayList<String>();
		 List<String>  devList=new ArrayList<String>();
		 
		 for(int i = 1; i<=rowcount; i++)
		  {
			 cell1 = sheet.getRow(i).getCell(1);
			 cell2 = sheet.getRow(i).getCell(2);
			 
			 if(cell1.getCellType()==CellType.STRING)
			 {
				 celltext1=cell1.getStringCellValue();
				 if(celltext1.contains(","))
				 {
					 String a[]=celltext1.split(",");
					 companyList.addAll(Arrays.asList(a));
				 }
				 else {
				 companyList.add(celltext1);
				 }
			 }
			 else if(cell1.getCellType()==CellType.BLANK)
			 {
				 celltext1="NoCompany";
				 companyList.add(celltext1);
			 }
			 
			 if(cell2.getCellType()==CellType.STRING)
			 {
				 cellText2=cell2.getStringCellValue();
				 if(cellText2.contains(","))
				 {
					 String b[]=cellText2.split(",");
					 devList.addAll(Arrays.asList(b));
				 }
				 else {
				 devList.add(cellText2);
				 }
			 }
			 else if(cell2.getCellType()==CellType.BLANK)
			 {
				 cellText2="NoDev";
				 devList.add(cellText2);
			 }
		  }
		 List<String> duplicateCompany=containsDuplicate(companyList);
		 List<String> duplicateDevIds=containsDuplicate(devList);
		 for(int i = 1; i<=rowcount; i++)
		  {
		  
			 cell1 = sheet.getRow(i).getCell(1);
			 cell2 = sheet.getRow(i).getCell(2);
			 if(companyList.get(i).contains("NoCompany") && devList.get(i).contains("NoDev"))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue("No Company Name");
				 answerSheet.getRow(i).getCell(2).setCellValue("No Dev ID");
				 answerSheet.getRow(i).getCell(3).setCellValue("100%");
			 }
			 else if(duplicateCompany.contains(companyList.get(i)) && duplicateDevIds.contains(devList.get(i)))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue(companyList.get(i));
				 answerSheet.getRow(i).getCell(2).setCellValue(devList.get(i));
				 answerSheet.getRow(i).getCell(3).setCellValue("100%");
			 }
			 else if(duplicateCompany.contains(companyList.get(i)) && !duplicateDevIds.contains(devList.get(i)))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue(companyList.get(i));
				 answerSheet.getRow(i).getCell(2).setCellValue("No Dev Matches");
				 answerSheet.getRow(i).getCell(3).setCellValue("50%");
			 }
			 else if(!duplicateCompany.contains(companyList.get(i)) && duplicateDevIds.contains(devList.get(i)))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue("No Company Matches");
				 answerSheet.getRow(i).getCell(2).setCellValue(devList.get(i));
				 answerSheet.getRow(i).getCell(3).setCellValue("100%");
			 }
			 else if(companyList.get(i).contains("NoCompany") && duplicateDevIds.contains(devList.get(i)))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue("No Company Name");
				 answerSheet.getRow(i).getCell(2).setCellValue(devList.get(i));
				 answerSheet.getRow(i).getCell(3).setCellValue("100%");
			 }
			 else if(companyList.get(i).contains("NoCompany") && !duplicateDevIds.contains(devList.get(i)))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue("No Company Name");
				 answerSheet.getRow(i).getCell(2).setCellValue(devList.get(i));
				 answerSheet.getRow(i).getCell(3).setCellValue("Not Found");
			 }
			 
			 else if(devList.get(i).contains("NoDev") && duplicateCompany.contains(companyList.get(i)))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue("No DevID");
				 answerSheet.getRow(i).getCell(2).setCellValue(companyList.get(i));
				 answerSheet.getRow(i).getCell(3).setCellValue("100%");
			 }
			 else if(devList.get(i).contains("NoDev") && !duplicateCompany.contains(companyList.get(i)))
			 {
				 answerSheet.getRow(i).getCell(1).setCellValue("No DevID");
				 answerSheet.getRow(i).getCell(2).setCellValue(companyList.get(i));
				 answerSheet.getRow(i).getCell(3).setCellValue("Not Found");
			 }
			
			 
			 
		  }//End of for loop
		 
		 //close the file input stream
		 fis.close();
		 

	//Open an excel to write the data into workbook
	FileOutputStream fos = new FileOutputStream(".\\Task2.xlsx");
	
	wb.write(fos);
	
	fos.close();

	}
	}


