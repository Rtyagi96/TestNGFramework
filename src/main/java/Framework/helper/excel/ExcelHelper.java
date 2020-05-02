package Framework.helper.excel;

import Framework.helper.logger.LoggerHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.logging.Logger;

public class ExcelHelper {
    private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

    public Object[][] getExcelData(String excelLocation, String sheetName){
        try{
            Object[][] dataSets = null;
            FileInputStream file = new FileInputStream(new File(excelLocation));

            //create workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //get sheet name from workbook
            XSSFSheet sheet = workbook.getSheet(sheetName);

            //get total rows with data in the active sheet
            int totalRows = sheet.getLastRowNum();

            //count total columns with data in the active sheet
            int totalColumn = sheet.getRow(0).getLastCellNum();

            dataSets = new String[totalRows+1][totalColumn];

            //Iterate through the sheet data using the Iterator
            Iterator<Row> rowIterator = sheet.iterator();
            int i=0;
            while (rowIterator.hasNext()){
                i++;
                //for each row iterate over the columns
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int j=0;
                while (cellIterator.hasNext()){
                    j++;
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()){
                        case STRING: dataSets[i-1][j-1] = cell.getStringCellValue();
                            break;
                        case NUMERIC: dataSets[i-1][j-1] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN: dataSets[i-1][j-1] = cell.getBooleanCellValue();
                            break;
                        case FORMULA: dataSets[i-1][j-1] = cell.getCellFormula();
                            break;
                        default:
                            System.out.println("No match found");
                            break;
                    }
                }
            }
            return dataSets;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void updateExcel(String excelLocation, String sheetName, String testCaseName, String testCaseStatus){
        try{
            FileInputStream file = new FileInputStream(new File(excelLocation));

            //create workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //get sheet name from workbook
            XSSFSheet sheet = workbook.getSheet(sheetName);

            //get total rows with data in the active sheet
            int totalRows = sheet.getLastRowNum()+1;

            //count total columns with data in the active sheet
            int totalColumn = sheet.getRow(0).getLastCellNum();
            for(int i = 1; i<totalRows; i++){
                XSSFRow row = sheet.getRow(i);
                String s = row.getCell(0).getStringCellValue();
                if(s.contains(testCaseName)){
                    row.createCell(1).setCellValue(testCaseStatus);
                    file.close();
                    log.info("Result updated...");
                    FileOutputStream out = new FileOutputStream(new File(excelLocation));
                    workbook.write(out);
                    out.close();
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
//    public static void main(String[] args){
//        ExcelHelper excelHelper = new ExcelHelper();
//        String excelLocation = ResourceHelper.getResourcePath("//src//main//resources//configFile//testdata.xlsx");
//        Object[][] data = excelHelper.getExcelData(excelLocation, "Sheet1");
//        System.out.println(Arrays.deepToString(data));
//        excelHelper.updateExcel(excelLocation, "Sheet2", "Login", "PASS");
}
