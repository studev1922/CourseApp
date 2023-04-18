package com.course.model;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.poi.EmptyFileException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {

    public static boolean writeExcel(String[] headName, Object[][] data, String path) throws Exception {
        if (path == null) {
            path = savePath();
        }

        File file = new File(path);
        FileOutputStream fileOut = null;
        Workbook workbook = new XSSFWorkbook();
        try {
            Sheet sheet = workbook.createSheet("File export");

            // set names
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headName.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headName[i]);
                cell.setCellStyle(rowStyle(workbook));
            }

            // set values
            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(String.valueOf(data[i][j]));
                    cell.setCellStyle(cellStyle(workbook));
                }
            }

            fileOut = new FileOutputStream(file.getPath());
            workbook.write(fileOut);
            return true;
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            fileOut.close();
            workbook.close();
        }
        return false;
    }

    public static boolean updateExcel(Object[][] data, String path, int sheetOfIndex) {
        if (path == null) {
            return false;
        }
        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet s = workbook.getSheetAt(sheetOfIndex);

            for (int i = 0; i < data.length; i++) {
                s.getRow(i + 1).getCell(2).setCellValue(String.valueOf(data[i][2])); // result
                s.getRow(i + 1).getCell(3).setCellValue(String.valueOf(data[i][3])); // acceptance date
            }

            FileOutputStream outFile = new FileOutputStream(new File(path));
            workbook.write(outFile);
            fis.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Object[][] readExcel(String path, int sheetOfIndex) throws IOException {
        if (path == null) {
            path = openPath();
        }
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis, path);
        Sheet s = workbook.getSheetAt(sheetOfIndex);
        Iterator<Row> iterator = s.iterator();

        // get rows
        List<Object[]> list1 = new LinkedList<Object[]>();
        List<Object> list2 = null;
        while (iterator.hasNext()) {
            list2 = new LinkedList<Object>();
            Row nextRow = iterator.next();
            // get cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                list2.add(getType(cell));
            }
            list1.add(list2.isEmpty() ? null : list2.toArray());
        }

        list1.remove(0); // remove headName
        fis.close();
        workbook.close();
        return list1.isEmpty() ? null : convertData(list1);
    }

    @SuppressWarnings({"deprecation"})
    private static Object getType(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            default:
                return cell.getStringCellValue();
        }
    }

    private static Object[][] convertData(List<Object[]> list) {
        Object[][] data = new Object[list.size()][list.get(0).length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                data[i][j] = list.get(i)[j];
            }
        }
        return data;
    }

    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    private static CellStyle rowStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 16);
        style.setFont(font);
        style.setFillBackgroundColor(IndexedColors.CORAL.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    private static CellStyle cellStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        return style;
    }

    // get path from open file
    private static String openPath() throws EmptyFileException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == 0) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            throw new EmptyFileException();
        }
    }

    // get path from save file
    private static String savePath() throws HeadlessException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(null) == 0) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            return (path.endsWith(".xls") || path.endsWith(".xlsx")) ? path : (path += ".xlsx");
        } else {
            throw new HeadlessException("path does not exist!");
        }
    }

}
