package com.healthec.generic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.interactions.SourceType;

public class ExcelData {
	public Workbook wb;
	public Sheet sh;
	public File src ;
	public Logger log = Logger.getLogger("devpinoyLogger");
	
	public ExcelData(String fileName)
	{
		try{
		src = new File("./dataArchive/"+fileName);
		FileInputStream fis = new FileInputStream(src);
		String extnsn = fileName.substring(fileName.indexOf("."));
		if(extnsn.equals(".xlsx")||extnsn.equals(".xls")){
			wb = WorkbookFactory.create(fis);
		}
		sh = wb.getSheetAt(0);
		}
		catch(Exception e)
		{
			log.info("Exception in getting file path: "+e.getMessage());
		}
	}
	public int retrievenoOfRows(String sheetName)
	{
		int sheetIndex = wb.getSheetIndex(sheetName);
		if(sheetIndex==-1){
			log.info("invalid sheet index");
			return 0;}

		else{
			sh = wb.getSheetAt(sheetIndex);
			int noOfRows = sh.getLastRowNum()+1;
			//log.info("Total no of rows: "+noOfRows);
			return noOfRows;
		}
	}
	public int retrievenoOfolumns(String sheetName)
	{
		int sheetIndex = wb.getSheetIndex(sheetName);
		if(sheetIndex==-1){
			log.info("invalid sheet index");
			return 0;}
		
		else{
			sh = wb.getSheetAt(sheetIndex);
			int noOfColumn = sh.getRow(0).getLastCellNum();
			//log.info("Total no of columns: "+noOfColumn);
			return noOfColumn;
		}
	}
	public String retrieveTestData(String sheetName,int rowNum,int colNum)
	{
		String data = null;
		try {
			sh = wb.getSheet(sheetName);
			Row r = sh.getRow(rowNum);
			Cell c = r.getCell(colNum);
			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(c);
			log.info("retrieved test data: " + data);
		}catch (Throwable e){
			log.info("Exception in retrieving test data: "+e.getStackTrace());

		}
		return data;
	}
	
	public String retrieveFlag(String sheetName,String rName,String cName)
	{
		String data=null;
		try{
			int sheetIndex = wb.getSheetIndex(sheetName);
			if(sheetIndex==-1){
					log.info("invalid sheet Index");
					return null;
			}
			
			int noOfRows = retrievenoOfRows(sheetName);
			int noOfCols = retrievenoOfolumns(sheetName);
			int rowNum = -1;
			int colNum = -1;
			
			Row cData = sh.getRow(0);
			for(int i =0;i<noOfCols;i++){
				if(cData.getCell(i).getStringCellValue().equalsIgnoreCase(cName.trim())){
					colNum = i;
					//log.info("Col Number is: "+colNum);
					break;
				}
			}
			if(colNum==-1){
				log.info("invalid column number");
				return null;}
			
			for(int j =0;j<noOfRows;j++){
				Row rData = sh.getRow(j);
				if(rData.getCell(0).getStringCellValue().equalsIgnoreCase(rName.trim())){
					rowNum = j;
					//log.info("Row Number is: "+rowNum);
					break;
				}
			}
			if(rowNum ==-1){
				log.info("invalid row number");
				return null;
			}
			Row r = sh.getRow(rowNum);
			Cell c = r.getCell(colNum);
			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(c);
			log.info("retrieved data: "+data);
		}
		catch(Exception e){
			log.info("Exception in retrieving flag: "+e.getMessage());
			
		}
		
		return data;
		
	}
	
	public boolean writeResult(String sheetName,String rName,String cName,String result)
	{
		String data=null;
		try{
			int sheetIndex = wb.getSheetIndex(sheetName);
			if(sheetIndex==-1){
				log.info("invalid sheet Index");
				return false;
			}
			
			int noOfRows = retrievenoOfRows(sheetName);
			int noOfCols = retrievenoOfolumns(sheetName);
			int rowNum = -1;
			int colNum = -1;
			
			Row cData = sh.getRow(0);
			for(int i =0;i<noOfCols;i++){
				if(cData.getCell(i).getStringCellValue().equalsIgnoreCase(cName.trim())){
					colNum = i;
					//log.info("Col Number is: "+colNum);
					break;
				}
			}
			if(colNum==-1){
				log.info("invalid column number");
				return false;}
			
			for(int j =0;j<noOfRows;j++){
				Row rData = sh.getRow(j);
				if(rData.getCell(0).getStringCellValue().equalsIgnoreCase(rName.trim())){
					rowNum = j;
					//log.info("Row Number is: "+rowNum);
					break;
				}
			}
			if(rowNum ==-1){
				log.info("invalid row number");
				return false;
			}
			Row r = sh.getRow(rowNum);
			Cell c = r.getCell(colNum);
			c.setCellValue(result);
			log.info("entered data: "+result);
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
			fout.close();
		}
		catch(Exception e){
			log.info("Exception inretrieving flag: "+e.getMessage());
			
		}
		return true;
		
	}
	
    public static void main(String[] args) throws ParseException {
		ExcelData ed = new ExcelData("testData.xlsx");
		//ed.retrievenoOfRows("credentials");
		//ed.retrievenoOfolumns("credentials");
		String date1 = ed.retrieveTestData("LoginPageUC", 1, 3);
		//ed.retrieveFlag("LoginPageUC", "loginpage_TC_002", "Execution");
		//ed.writeResult("DatePickerUC", "TC_004", "status","TESTINGJIO");
		
	
		
		
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yy")
		            .withLocale(Locale.US);
		System.out.println("date++ "+date1);
		LocalDate date = formatter.parseLocalDate(date1);
		System.out.println("date>> "+date);

        /*log.info(date.getYear());  
        log.info(date.getMonthOfYear()); 
        log.info(date.getDayOfMonth()); */
		System.out.println(Month.of(date.getMonthOfYear()).name().substring(0, 3));
        String mon = Month.of(date.getMonthOfYear()).name().substring(0, 3);
	    String month =mon.substring(0, 1).toUpperCase()+mon.substring(1,mon.length()).toLowerCase();
		System.out.println("changed month name is: "+month);
        
        	
		
		/*String str[] = "18/08/2012".split("/");
		int day = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int year = Integer.parseInt(str[2]);
		log.info("day: "+day+" month: "+month+" year: "+year);
    */
    }
}
