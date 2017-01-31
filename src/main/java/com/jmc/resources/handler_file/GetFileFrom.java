package com.jmc.resources.handler_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class GetFileFrom {
	private static final String PATH_IN_TXT = "C://Users//josem//Desktop//file2.txt";
	private static final String PATH_IN_EXCEL = "C://Users//josem//Desktop//fichero_excel_entrada.xlsx";
	private static final String PATH_OUT_TXT = "C://Users//josem//Desktop//salida.txt";
	private static final String URL_IN = "https://www.google.es/";

	public static void main(String[] args) throws Exception {

//		getFileFromLocal(PATH_IN_TXT, PATH_OUT_TXT);

//		getFileFromUrl(URL_IN, PATH_OUT_TXT);
		
		proccessFile(PATH_IN_EXCEL);
	}

	public static FileOutputStream getFileFromLocal(String rutaOrigen, String rutaDestino) {

		FileInputStream fEntrada = null; // File("C://Users//josem//Desktop//file2.txt");
		FileOutputStream fSalida = null; // File("C://Users//josem//Desktop//salida.txt");

		try {
			fEntrada = new FileInputStream(rutaOrigen);
			fSalida = new FileOutputStream(rutaDestino);
			try {

				byte[] b = new byte[2048];
				int c;
				while ((c = fEntrada.read()) != -1) {
					fSalida.write(b, 0, c);
				}
			} catch (IOException e) {
				System.out.println("Exception IOException: Error escribiendo fichero... " + e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception FileNotFoundException " + e);
		} finally {
			// cerrar los flujos de datos
			if (fEntrada != null) {
				try {
					fEntrada.close();
				} catch (IOException ex) {
				}
			}
			if (fSalida != null) {
				try {
					fSalida.close();
				} catch (IOException ex) {
				}
			}
			System.out.println("el bloque finally siempre se ejecuta");
		}

		return fSalida;

	}

	public static void getFileFromUrl(String url, String ficheroDestino) throws Exception {

		URL ficheroUrl = new URL(url);
		InputStream inputStream = ficheroUrl.openStream();
		OutputStream outputStream = new FileOutputStream(ficheroDestino);

		byte[] b = new byte[2048];
		int longitud;

		while ((longitud = inputStream.read(b)) != -1) {
			outputStream.write(b, 0, longitud);
		}

		inputStream.close(); // Cerramos la conexión entrada
		outputStream.close(); // Cerramos la conexión salida
	}

	public static void proccessFile(String rutaOrigen) throws IOException {

		FileInputStream file = new FileInputStream(new File(rutaOrigen));
		// Crear el objeto que tendra el libro de Excel
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		/*
		 * LECTURA FICHEROS EXCEL (.XLSX) con XSSFWorkbook y XSSFSheet
		 * LECTURA FICHEROS EXCEL 97-2007 (.XLS) con HSSFWorkbook y HSSFSheet
		 * 
		 * Obtenemos la primera pestaña a la que se quiera procesar indicando el
		 * indice. Una vez obtenida la hoja excel con las filas que se quieren
		 * leer, obtenemos el iterator que nos permite recorrer cada una de las
		 * filas que contiene.
		 */
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		// Recorremos todas las filas para mostrar el contenido de cada celda
		while (rowIterator.hasNext()) {
			row = rowIterator.next();

			// Obtenemos el iterator que permite recorres todas las celdas de
			// una fila
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell celda;

			while (cellIterator.hasNext()) {
				celda = cellIterator.next();

				// Dependiendo del formato de la celda el valor se debe mostrar
				// como String, Fecha, boolean, entero...
				switch (celda.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (HSSFDateUtil.isCellDateFormatted(celda)) {
						System.out.println(celda.getDateCellValue());
					} else {
						System.out.println(celda.getNumericCellValue());
					}
					System.out.println(celda.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.println(celda.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.println(celda.getBooleanCellValue());
					break;
				}
			}
		}
		// cerramos el libro excel
		workbook.close();
	}

	
	
}

// BufferedInputStream in = new BufferedInputStream(new
// FileInputStream(archivoOrigen));
// BufferedOutputStream out = new BufferedOutputStream(new
// FileOutputStream(archivoDestino));
// byte buffer[] = new byte[1024];
// int leidos;
// while((leidos=in.read(buffer,0,1024))!=-1){
// out.write(buffer,0,leidos);
// }
// in.close();
// out.close();
//

// FileReader entrada = null;
// FileWriter salida = null;
//
// try {
// entrada = new FileReader("C://Users//josem//Desktop//file1.txt");
// salida = new FileWriter("C://Users//josem//Desktop//file2.txt");
// int c;
// while ((c = entrada.read()) != -1) {
// salida.write(c);
// }
// } catch (IOException ex) {
// System.out.println(ex);
//
// } finally {
// // cerrar los flujos de datos
// if (entrada != null) {
// try {
// entrada.close();
// } catch (IOException ex) {
// }
// }
// if (salida != null) {
// try {
// salida.close();
// } catch (IOException ex) {
// }
// }
// System.out.println("el bloque finally siempre se ejecuta");
// }

// **********************************

// try {
// App.descargar("File://C://Users//josem//Desktop//file1.txt",
// "C://Users//josem//Desktop//file2.txt");
// } catch (Exception e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }

// List lista = new ArrayList();

// C://Users//josem//Desktop//file1.txt

//// List int lista1 = new List(new int[] { 12, 15, 11, 4, 32 });
//
// try {
// ObjectOutputStream salida = new ObjectOutputStream(new
//// FileOutputStream("media.obj"));
// salida.writeObject("guardar este string y un objeto\n");
// salida.writeObject(lista1);
// salida.close();
//
// ObjectInputStream entrada = new ObjectInputStream(new
//// FileInputStream("media.obj"));
// String str = (String) entrada.readObject();
// List obj1 = (List) entrada.readObject();
//
// System.out.println("Valor medio " + obj1.valorMedio());
// System.out.println("-----------------------------");
// System.out.println(str + obj1);
// System.out.println("-----------------------------");
// entrada.close();
// // se puede fundir en una catch Exception
// } catch (IOException ex) {
// System.out.println(ex);
// } catch (ClassNotFoundException ex) {
// System.out.println(ex);
// }
//
// try {
// // espera la pulsación de una tecla y luego RETORNO
// System.in.read();
// } catch (Exception e) {
// }

// public static void descargar(String url, String ficheroDestino) throws
// Exception {
//
// URL ficheroUrl = new URL(url);
// InputStream inputStream = ficheroUrl.openStream();
// OutputStream outputStream = new FileOutputStream(ficheroDestino); // path
// y nombre del nuevo fichero creado
//
// byte[] b = new byte[2048];
// int longitud;
//
// while ((longitud = inputStream.read(b)) != -1) {
// outputStream.write(b, 0, longitud);
// }
//
// inputStream.close(); // Cerramos la conexión entrada
// outputStream.close(); // Cerramos la conexión salida
// }
