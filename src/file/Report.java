package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import response.Result;

public class Report {

    private static final String NOME_ARQUIVO = "relatorio.xlsx";

    public synchronized boolean atualizarRelatorio(ArrayList<Result> resultados) {
        boolean ok = false;
        try {

            // Pegando o arquivo
            File arquivo = new File(NOME_ARQUIVO);
            // Abrindo a leitura
            FileInputStream leitura = new FileInputStream(arquivo);
            // Pegando o workbook
            XSSFWorkbook workbook = new XSSFWorkbook(leitura);
            // Pegando a pasta dentro do xlsx
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow row;
            XSSFCell cell;

            for (Result resultado : resultados) {
                // Pegando a linha
                row = sheet.getRow(resultado.getRow());

                // Pegando a celula
                cell = row.getCell(resultado.getCell());

                // Cria a celula caso nao exista
                if (cell == null)
                    cell = row.createCell(resultado.getCell());

                // Altera o tipo da celula e o dado que sera inserido
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(resultado.getDado());

                // Pegando a linha
                row = sheet.getRow(resultado.getRow());

                // Pegando a celula
                cell = row.getCell(resultado.getCell()+2);

                // Cria a celula caso nao exista
                if (cell == null)
                    cell = row.createCell(resultado.getCell());

                // Altera o tipo da celula e o dado que sera inserido
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(resultado.getComparacoes());

            }

            // Salva a data no arquivo
            row = sheet.getRow(0);
            cell = row.getCell(1);
            cell.setCellType(CellType.STRING);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            cell.setCellValue(dateFormat.format(date));

            // Escreve no arquivo
            FileOutputStream fileOut = new FileOutputStream(NOME_ARQUIVO);
            workbook.write(fileOut);
            fileOut.close();

            // Fecha o workbook
            workbook.close();

            ok = true;
        } catch (FileNotFoundException e) {
            System.err.println("Nao foi possivel encontrar o arquivo solicitado.");
        } catch (Exception e) {
            System.err.println("Erro inesperado.");
            e.printStackTrace();
        }

        return ok;
    }
}
