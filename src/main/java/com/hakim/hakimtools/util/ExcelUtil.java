package com.hakim.hakimtools.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.BLANK;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hakim
 */
public class ExcelUtil {

    public static List<List<Object>> readExcel(String filePath, String sheetName) {

        List<List<Object>> excelData = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath)) {
            try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {

                XSSFSheet sheet = workbook.getSheet(sheetName);
                for (int r = 0; r <= sheet.getLastRowNum(); r++) {

                    List<Object> rowData = new ArrayList<>();

                    Row row = sheet.getRow(r);
                    if (row == null) {
                        continue;
                    }

                    for (int i = 0; i < row.getLastCellNum(); i++) {

                        Cell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

                        if (cell == null) {
                            rowData.add("");
                            continue;
                        }

                        if (r == 0 && cell.getCellType().equals(NUMERIC)) {
                            rowData.add(cell.getDateCellValue());
                            continue;
                        }

                        switch (cell.getCellType()) {
                            case NUMERIC,FORMULA -> {
                                rowData.add(cell.getNumericCellValue());
                            }
                            case BLANK -> {
                                rowData.add("");
                            }
                            case BOOLEAN -> {
                                rowData.add(cell.getBooleanCellValue());
                            }
                            default -> {
                                rowData.add(cell.getStringCellValue());
                            }
                        }
                    }
                    excelData.add(rowData);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return excelData;
    }

    public static void writeToCsv(List<List<Object>> data, String csvPath) {

        if (!createFile(csvPath)) {
            JOptionPane.showConfirmDialog(null, "Could not create File.");
        }

        try (FileWriter writer = new FileWriter(csvPath, true)) {

            StringBuilder stringBuilder;
            for (List<Object> row : data) {

                stringBuilder = new StringBuilder();
                for (int i = 0; i < row.size(); i++) {

                    stringBuilder.append(row.get(i));
                    if (i != row.size() - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("\n");
                writer.write(stringBuilder.toString());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean createFile(String filePath) {

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return file.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public static List<List<Object>> readCsv(String filePath) {

        List<List<Object>> data = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
                List<String> lines = reader.lines().toList();
                for (String line : lines) {
                    String[] split = line.split("\\,");
                    data.add(Arrays.asList(split));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return data;
    }
}
