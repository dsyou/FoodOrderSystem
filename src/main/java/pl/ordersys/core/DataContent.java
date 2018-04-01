package pl.ordersys.core;


import lombok.NoArgsConstructor;
import pl.ordersys.content.Cuisines;
import pl.ordersys.content.Drinks;
import pl.ordersys.content.OrderMenu;
import pl.ordersys.exception.AppExp;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class consists methods that operate on Excel file
 * and returns list of Cuisines and Drinks.
 *
 * <p> The methods of this class can throw <tt>AppExp<tt/>
 *
 * @author Dawid Janik
 */
@NoArgsConstructor
public class DataContent {

    // XML SpreadSheet Format
    private static XSSFRow row;
    private static OrderMenu menu = OrderMenu.getInstace();

    private static LinkedList<Cuisines> cuisines = new LinkedList<>();
    private static LinkedList<Drinks> drinks = new LinkedList<>();

    /**
     * IMPORTANT XSSFWorkbook support .xlsx Excel file (2007 and newest)
     *
     * @param path physical address of Excel file
     * @throws AppExp if file not exist or is damaged
     */
    public static void getContent(String path) throws AppExp {

        FileInputStream excelData; //data.xlsx
        XSSFWorkbook workbook;

        try {
            excelData = new FileInputStream(new File(path)); //Place for address
            workbook = new XSSFWorkbook(excelData); //DataContent
            setLunchData(workbook);
            setDrinksData(workbook);
            System.out.println("***Application Start Succefully***");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AppExp("File Not Found");
        } // WriteSheet.xlsx
        catch (IOException e) {
            e.printStackTrace();
            throw new AppExp("I/O Check file structure");
        }
    }

    /**
     * This method is used to update Lunch menu content List with Sheet(0)-Launch
     *
     * @param workbook High level representation of a SpreadsheetML workbook.
     * @throws IllegalStateException if data in Sheet(0) is invalid
     *                               e.g specific cell contains String value instead of numeric value.
     */
    private static void setLunchData(XSSFWorkbook workbook) { //setLunchData
        try {
            XSSFSheet spreadsheet = workbook.getSheetAt(0);            //Sheet(0)-Launch
            Iterator<Row> rowIterator = spreadsheet.iterator();

            while (rowIterator.hasNext()) {

                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Cuisines cs = new Cuisines();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next(); // Cell from Excel

                    if (cell.getColumnIndex() == 0) {
                        cs.setNameCuisines(cell.getStringCellValue()); // Name e.g. Polish
                    } else if (cell.getColumnIndex() == 1) {
                        cs.setNameMainCourse(cell.getStringCellValue()); // Main course e.g. Schabowy
                    } else if (cell.getColumnIndex() == 2) {
                        cs.setNameDessert(cell.getStringCellValue()); // Dessert e.g. Makowiec
                    } else if (cell.getColumnIndex() == 3) {
                        cs.setPrice(cell.getNumericCellValue()); // Price e.g. 24.99$
                    }
                }
                cuisines.add(cs); // Add all parameters into list
            }
            menu.setArrayOfCuisine(cuisines);
            showDataCuisines(cuisines);

        } catch (java.lang.IllegalStateException e) { //Invalid Format
            System.err.println("Invalid Data in Excel Launch Cell");
        }
    }

    /**
     * This method is used to update Drink menu content List with Sheet(1)-Drinks
     *
     * @param workbook High level representation of a SpreadsheetML workbook.
     * @throws IllegalStateException if data in Sheet(1) is invalid
     *                               e.g specific cell contains String value instead of numeric value
     */
    private static void setDrinksData(XSSFWorkbook workbook) {
        try {

            XSSFSheet spreadsheet = workbook.getSheetAt(1);             //Sheet(1)-Drinks
            Iterator<Row> rowIterator = spreadsheet.iterator();

            while (rowIterator.hasNext()) {

                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Drinks drink = new Drinks();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next(); // each Cell from Excel

                    if (cell.getColumnIndex() == 0) {
                        drink.setName(cell.getStringCellValue()); // Name e.g. Vodka
                    } else if (cell.getColumnIndex() == 1) {
                        drink.setPrice(cell.getNumericCellValue()); // Price e.g. 4.99$
                    }
                }
                drinks.add(drink); // Add all parameters into list
            }
            menu.setArrayOfDrinks(drinks);
            showDataDrinks(drinks);

        } catch (java.lang.IllegalStateException e) { //Invalid Format
            System.err.println("Invalid Data in Excel Drinks Cell");
        }
    }

    private static void showDataCuisines(LinkedList<Cuisines> list) {
        System.out.println("list.size() = " + list.size());
        list.forEach(System.out::println);
    }

    private static void showDataDrinks(LinkedList<Drinks> list) {
        System.out.println("list.size() = " + list.size());
        list.forEach(System.out::println);
    }

}
