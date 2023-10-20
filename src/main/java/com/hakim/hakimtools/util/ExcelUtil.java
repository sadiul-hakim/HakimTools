package com.hakim.hakimtools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public static List<List<Object>> reader(String filePath,String sheetName) {

        List<List<Object>> excelData = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath)) {
            try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {

                XSSFSheet sheet = workbook.getSheet(sheetName);
                for (Row row : sheet) {

                    List<Object> rowData = new ArrayList<>();

                    for (Cell cell : row) {

                        switch (cell.getCellType()) {
                            case NUMERIC -> {
                                rowData.add(cell.getNumericCellValue());
                            }
                            case FORMULA -> {
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
}
