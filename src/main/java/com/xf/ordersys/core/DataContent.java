package com.xf.ordersys.core;


import com.xf.ordersys.content.Cuisines;
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



    private static LinkedList<Cuisines> list_C = new LinkedList<Cuisines>();




    public static void getContent(String path){

            FileInputStream excel_Data = null ; //data.xlsx
            XSSFWorkbook workbook = null;
            try {
                excel_Data = new FileInputStream(new File(path)); //Place for addres
                workbook = new XSSFWorkbook(excel_Data); //DataContent
            } catch (FileNotFoundException e) {
               //TODO  System.err.println("Brak pliku");	e.printStackTrace();
            } // WriteSheet.xlsx
            catch (IOException e) {
                //TODO   System.err.println("Blad w odczycie"); e.printStackTrace();

            }

            setLunchData(workbook);
            setDrinksData(workbook);
            System.out.println("Application Start Sucefull-y");
        }

    private static  void setLunchData(XSSFWorkbook workbook) {

//        if (workbook == null){
//            System.out.println("Nulek");
//        }

        XSSFSheet spreadsheet = workbook.getSheetAt(0);			//Numer Arkusza 0 zbiorowka
        Iterator<Row> rowIterator = spreadsheet.iterator();

        while (rowIterator.hasNext()) {

            row =  (XSSFRow) rowIterator.next();
            Iterator <Cell> cellIterator = row.cellIterator();

            Cuisines cs = new Cuisines();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next(); // Cell from Excel

                if (cell.getColumnIndex()== 0){

                    cs.setName(cell.getStringCellValue()); // Name e.g. Polish

                   // menu.setArrayOfCuisine();
                  //  System.out.println(cell.getStringCellValue() + "  " + cell.getColumnIndex());
                }else if (cell.getColumnIndex()== 1){

                    cs.setNameMainCourse(cell.getStringCellValue()); // Main course e.g. Schabowy

                }else if (cell.getColumnIndex()== 2){

                    cs.setNameDessert(cell.getStringCellValue()); // Dessert e.g. Makowiec

                }else if (cell.getColumnIndex()== 3){

                    cs.setPrice(cell.getNumericCellValue()); // price e.g. 24.99$

                }

//                list_C.add(cs); // Add all parameters into list

            } // end of Cell iter
            list_C.add(cs); // Add all parameters into list


        }// end of Row iter
        menu.setArrayOfCuisine(list_C);
        showData(list_C);
    }

    private static void setDrinksData(XSSFWorkbook workbook) {



    }

    private static void showData(LinkedList<Cuisines> list){
        System.out.println("list.size() = " + list.size());
        for (Cuisines s : list) System.out.println(s);
    }

}
