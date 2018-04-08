package pl.ordersys.core;


import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.ordersys.apprun.exception.AppExp;
import pl.ordersys.core.content.Cuisine;
import pl.ordersys.core.content.Drink;
import pl.ordersys.core.content.OrderMenu;
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
 * and returns list of Cuisine and Drink.
 *
 * <p> The methods of this class can throw <tt>AppExp<tt/>
 *
 * @author Dawid Janik
 */
@Slf4j
@UtilityClass
public class RedData {

    // XML SpreadSheet Format
    private static XSSFRow row;
    private static OrderMenu orderMenu = OrderMenu.getInstance();

    private static LinkedList<Cuisine> cuisines = new LinkedList<>();
    private static LinkedList<Drink> drinks = new LinkedList<>();

    /**
     * IMPORTANT XSSFWorkbook support .xlsx Excel file (2007 and newest)
     *
     * @param path physical address of Excel file
     * @throws AppExp if file not exist or is damaged
     */
    public static void getContent(String path) {

        final XSSFWorkbook workbook;

        try (final FileInputStream excelData = new FileInputStream(new File(path))) {
            workbook = new XSSFWorkbook(excelData); //RedData
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
     * This method is used to update Lunch orderMenu content List with Sheet(0)-Launch
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

                Cuisine cs = new Cuisine();
                while (cellIterator.hasNext()) {
                    // Cell from Excel
                    Cell cell = cellIterator.next();

                    if (cell.getColumnIndex() == 0) {
//                        cs.setName(getStringCellValue(cell)); // Name e.g. Polish
                    } else if (cell.getColumnIndex() == 1) {
//                        cs.setCourse(new Course(getStringCellValue(cell)); // Main course e.g. Schabowy
                    } else if (cell.getColumnIndex() == 2) {
//                        cs.setDessert(getStringCellValue(cell)); // Dessert e.g. Makowiec
                    } else if (cell.getColumnIndex() == 3) {
//                        cs.setPrice(cell.getNumericCellValue()); // Price e.g. 24.99$
                    }
                }
                cuisines.add(cs); // Add all parameters into list
            }
            orderMenu.setCuisines(cuisines);
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
     * This method is used to update Drink orderMenu content List with Sheet(1)-Drink
     *
     * @param workbook High level representation of a SpreadsheetML workbook.
     * @throws IllegalStateException if data in Sheet(1) is invalid
     *                               e.g specific cell contains String value instead of numeric value
     */
    private static void setDrinksData(XSSFWorkbook workbook) {
        try {
            //Sheet(1)-Drink
            XSSFSheet spreadsheet = workbook.getSheetAt(1);

            for (Row aSpreadsheet : spreadsheet) {
                row = (XSSFRow) aSpreadsheet;
                Iterator<Cell> cellIterator = row.cellIterator();

                Drink drink = new Drink();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
//                    if (cell.getColumnIndex() == 0) {
//                        drink.setName(getStringCellValue(cell)); // Name e.g. Vodka
//                    } else if (cell.getColumnIndex() == 1) {
//                        drink.setPrice(cell.getNumericCellValue()); // Price e.g. 4.99$
//                    }
                }
                drinks.add(drink); // Add all parameters into list
            }
            orderMenu.setDrinks(drinks);
            showDataDrinks(drinks);

        } catch (IllegalStateException ex) {
            log.debug("Out of range when accessing Excel sheet");
            throw new ExcelSheetOutOfRangeException();
        }
    }

    private static void showDataCuisines(LinkedList<Cuisine> cuisines) {
        cuisines.forEach(System.out::println);
    }

    private static void showDataDrinks(LinkedList<Drink> drinks) {
        drinks.forEach(System.out::println);
    }

}
