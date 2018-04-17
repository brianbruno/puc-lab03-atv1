package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Report {

    /*public void saveFile (int linha, int coluna, String valor) {
        try {
            // Criando o arquivo fisico
            FileOutputStream out = new FileOutputStream("workbook.xls");

            // Criando area de trabalho para o excel
            Workbook wb = new HSSFWorkbook();

            // criando uma nova sheet
            Sheet s = wb.createSheet();

            // Criando uma referencia para Linha
            Row r = null;

            // Referencia para Celula
            Cell c = null;

            //Criando a primeira linha na LINHA zero, que seria o número 1
            r = s.createRow(linha);

            //Criando a celula na posicao ZERO, que seria A, com referencia na linha ZERO criado acima ou seja, colocaremos
            //informacao na A1
            c = r.createCell(coluna);

            //Colocando um valor
            c.setCellValue("Testes");


            // Salvando o arquivo
            wb.write(out);
            out.close();

            FileOutputStream output_file =new FileOutputStream("workbook.xls");  //Open FileOutputStream to write updates

            wb.write(output_file); //write changes

            output_file.close();  //close the stream
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */

    public void saveFile (String valor, int linha, int coluna) {

        try {
            FileInputStream fsIP = new FileInputStream(new File("workbook.xls")); //Read the spreadsheet that needs to be updated

            HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook

            HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.

            Cell cell = null; // declare a Cell object

            cell = worksheet.getRow(0).getCell(0);   // Access the second cell in second row to update the value

            cell.setCellValue(valor);  // Get current cell value value and overwrite the value

            fsIP.close(); //Close the InputStream

            FileOutputStream output_file = new FileOutputStream(new File("workbook.xls"));  //Open FileOutputStream to write updates

            wb.write(output_file); //write changes

            output_file.close();  //close the stream
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
