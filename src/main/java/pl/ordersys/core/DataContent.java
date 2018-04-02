package pl.ordersys.core;


import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.ordersys.apprun.exception.AppExp;
import pl.ordersys.content.Cuisines;
import pl.ordersys.content.Drinks;
import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.exception.ExcelFileNotFoundException;
import pl.ordersys.core.exception.ExcelIoException;
import pl.ordersys.core.exception.ExcelSheetOutOfRangeException;

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
@Slf4j
@UtilityClass
public class DataContent {

    // XML SpreadSheet Format
    private static XSSFRow row;
    private static OrderMenu menu = OrderMenu.getInstance();

    private static LinkedList<Cuisines> cuisines = new LinkedList<>();
    private static LinkedList<Drinks> drinks = new LinkedList<>();

    /**
     * IMPORTANT XSSFWorkbook support .xlsx Excel file (2007 and newest)
     *
     * @param path physical address of Excel file
     * @throws AppExp if file not exist or is damaged
     */
    public static void getContent(String path) {

        final XSSFWorkbook workbook;

        try (final FileInputStream excelData = new FileInputStream(new File(path))) {
            workbook = new XSSFWorkbook(excelData); //DataContent
            setLunchData(workbook);
            setDrinksData(workbook);
            log.info("***Application Start Successfully***");
        } catch (FileNotFoundException ex) {
            log.debug("Excel file was not found");
            throw new ExcelFileNotFoundException("File Not Found");
        } catch (IOException ex) {
            log.debug("I/O exception when processing the file");
            throw new ExcelIoException("I/O error when accessing the file");
        }
    }

    /**
     * This method is used to update Lunch menu content List with Sheet(0)-Launch
     *
     * @param workbook High level representation of a SpreadsheetML workbook.
     * @throws IllegalStateException if data in Sheet(0) is invalid
     *                               e.g specific cell contains String value instead of numeric value.
     */
    private static void setLunchData(XSSFWorkbook workbook) {
        try {
            //Sheet(0)-Launch
            XSSFSheet spreadsheet = workbook.getSheetAt(0);

            for (Row aSpreadsheet : spreadsheet) {
                row = (XSSFRow) aSpreadsheet;
                Iterator<Cell> cellIterator = row.cellIterator();

                Cuisines cs = new Cuisines();
                while (cellIterator.hasNext()) {
                    // Cell from Excel
                    Cell cell = cellIterator.next();

                    if (cell.getColumnIndex() == 0) {
                        cs.setNameCuisines(getStringCellValue(cell)); // Name e.g. Polish
                    } else if (cell.getColumnIndex() == 1) {
                        cs.setNameMainCourse(getStringCellValue(cell)); // Main course e.g. Schabowy
                    } else if (cell.getColumnIndex() == 2) {
                        cs.setNameDessert(getStringCellValue(cell)); // Dessert e.g. Makowiec
                    } else if (cell.getColumnIndex() == 3) {
                        cs.setPrice(cell.getNumericCellValue()); // Price e.g. 24.99$
                    }
                }
                cuisines.add(cs); // Add all parameters into list
            }
            menu.setCuisines(cuisines);
            showDataCuisines(cuisines);

        } catch (IllegalStateException ex) { //Invalid Format
            log.debug("Out of range when accessing Excel sheet");
            throw new ExcelSheetOutOfRangeException();
        }
    }

    private static String getStringCellValue(Cell cell) {
        return cell.getStringCellValue();
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
            //Sheet(1)-Drinks
            XSSFSheet spreadsheet = workbook.getSheetAt(1);

            for (Row aSpreadsheet : spreadsheet) {
                row = (XSSFRow) aSpreadsheet;
                Iterator<Cell> cellIterator = row.cellIterator();

                Drinks drink = new Drinks();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        drink.setName(getStringCellValue(cell)); // Name e.g. Vodka
                    } else if (cell.getColumnIndex() == 1) {
                        drink.setPrice(cell.getNumericCellValue()); // Price e.g. 4.99$
                    }
                }
                drinks.add(drink); // Add all parameters into list
            }
            menu.setDrinks(drinks);
            showDataDrinks(drinks);

        } catch (IllegalStateException ex) {
            log.debug("Out of range when accessing Excel sheet");
            throw new ExcelSheetOutOfRangeException();
        }
    }

    private static void showDataCuisines(LinkedList<Cuisines> cuisines) {
        cuisines.forEach(System.out::println);
    }

    private static void showDataDrinks(LinkedList<Drinks> drinks) {
        drinks.forEach(System.out::println);
    }

}
