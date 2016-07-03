package com.xf.ordersys.core;


import com.xf.ordersys.content.Cuisines;
import com.xf.ordersys.content.Drinks;
import com.xf.ordersys.content.OrderMenu;
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
 * Created by Dawid Janik on 2016-06-29.
 *
 *
 *
 */
public class DataContent {

         static XSSFRow row;  // XML SpreadSheet Format
         private static OrderMenu menu = OrderMenu.getInstace();


    private static LinkedList<Cuisines> list_L = new LinkedList<Cuisines>();
    private static LinkedList<Drinks> list_D = new LinkedList<Drinks>();

//===================================================================
//GET CONTENT FROM EXCEL DataBase
    public static void getContent(String path){

            FileInputStream excel_Data = null ; //data.xlsx
            XSSFWorkbook workbook = null;

            try {
                excel_Data = new FileInputStream(new File(path)); //Place for addres
                workbook = new XSSFWorkbook(excel_Data); //DataContent
                setLunchData(workbook);
                setDrinksData(workbook);
                System.out.println("***Application Start Succefully***");
            } catch (FileNotFoundException e) {
                     //TODO  System.err.println("Brak pliku");	e.printStackTrace();
            } // WriteSheet.xlsx
            catch (IOException e) {
                    //TODO   System.err.println("Blad w odczycie"); e.printStackTrace();

            }

        }


/*
 Lunch
 */
    private static void setLunchData(XSSFWorkbook workbook) { //setLunchData

        XSSFSheet spreadsheet = workbook.getSheetAt(0);			//Sheet(0)-Launch
        Iterator<Row> rowIterator = spreadsheet.iterator();

        while (rowIterator.hasNext()) {

            row =  (XSSFRow) rowIterator.next();
            Iterator <Cell> cellIterator = row.cellIterator();

            Cuisines cs = new Cuisines();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next(); // Cell from Excel

                if (cell.getColumnIndex()== 0){

                    cs.setName(cell.getStringCellValue()); // Name e.g. Polish

                }else if (cell.getColumnIndex()== 1){

                    cs.setNameMainCourse(cell.getStringCellValue()); // Main course e.g. Schabowy

                }else if (cell.getColumnIndex()== 2){

                    cs.setNameDessert(cell.getStringCellValue()); // Dessert e.g. Makowiec

                }else if (cell.getColumnIndex()== 3){

                    cs.setPrice(cell.getNumericCellValue()); // Price e.g. 24.99$

                }

            } // end of Cell iteration
            list_L.add(cs); // Add all parameters into list

        }// end of Row iteration
        menu.setArrayOfCuisine(list_L);
        showData_CuisinesList(list_L);

    }
/*
Drinks
 */
    private static  void setDrinksData(XSSFWorkbook workbook) {

        XSSFSheet spreadsheet = workbook.getSheetAt(1);			 //Sheet(1)-Drinks
        Iterator<Row> rowIterator = spreadsheet.iterator();

        while (rowIterator.hasNext()) {

            row =  (XSSFRow) rowIterator.next();
            Iterator <Cell> cellIterator = row.cellIterator();

            Drinks drink = new Drinks();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next(); // each Cell from Excel

                if (cell.getColumnIndex()== 0){

                    drink.setName(cell.getStringCellValue()); // Name e.g. Vodka

                }else if (cell.getColumnIndex()== 1){

                    drink.setPrice(cell.getNumericCellValue()); // Price e.g. 4.99$
                }

            } // end of Cell iteration
            list_D.add(drink); // Add all parameters into list

        }// end of Row iteration

        menu.setArrayOfDrinks(list_D); //TODO ...
        showData_DrinksList(list_D);
    }


//===================================================================
//Others method's

    private static void showData_CuisinesList(LinkedList<Cuisines> list){
        System.out.println("list.size() = " + list.size());
        list.forEach(System.out::println);
    }

    private static void showData_DrinksList(LinkedList<Drinks> list){
        System.out.println("list.size() = " + list.size());
        list.forEach(System.out::println);
    }


} //End of DataContent
