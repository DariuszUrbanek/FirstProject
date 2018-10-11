package com.example.du.wazniak.zadanie2strumienieBinarne;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;

public class Strumienie {

	public static void main(String[] args) {
		File inputFile = new File("C:" + File.separator + "Wazniak" + File.separator + "plik.txt");

		try (InputStream fis = new FileInputStream(inputFile)) {
			unzipStreamAndSaveToFile(zipStream(fis));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void test() {
		//bazaDanych.zapisz(zipStream(webservice.getInputStream()));
	}
	
	public static void writeFileToSysout() {
		File file = new File("C:" + File.separator + "Wazniak" + File.separator + "plik.txt");
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void zipFile() {
		File inputFile = new File("C:" + File.separator + "Wazniak" + File.separator + "plik.txt");
		File outputFile = new File("C:" + File.separator + "Wazniak" + File.separator + "plik.zip");

		// ZipOutputStream pakuje, ZipInputStream rozpakowuje.

		// plik.txt -> [File] -> [FileInputStream] -> IOUtils.copy(..) ->
		// [ZipOutputStream] -> [BufferedOutputStream] -> [FileOutputStream] -> plik.zip

		try (FileInputStream fis = new FileInputStream(inputFile);
				ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)))) {
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}

			zos.putNextEntry(new ZipEntry(inputFile.getName()));

			IOUtils.copy(fis, zos);

			zos.closeEntry();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// plik.zip -> [File] -> [FileInputStream] -> IOUtils.copy(..) -> ->
	// [FileOutputStream] -> plik2.txt

	public static void unzipFile() {
		String directory = "C:" + File.separator + "Wazniak" + File.separator;
		File inputFile = new File(directory + "plik.zip");

		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(inputFile))) {

			ZipEntry entry = zis.getNextEntry();

			File outputFile = new File(directory + entry.getName());

			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}

			try (OutputStream os = new FileOutputStream(outputFile)) {
				IOUtils.copy(zis, os);

				zis.closeEntry();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Wskazówki
	// ZipOutputStream pakuje, ZipInputStream rozpakowuje.
	// [InputStream] -> IOUtils.copy(..) -> [OutputStream]
	// [InputStream] -> [BufferedInputStream]
	// [outputStream] -> [ZipOutputStream(pakuje)]
	// [outputStream] -> [ByteArrayOutputStream]
	// [ByteArrayOutputStream.toByteArray()] -> byte[]->
	// [ByteArrayInputStream(byte[])]
	// new AOuputStream(new BOutputStream) A -> B
	// new AInputSTream(new BInputSTream) B -> A
	// byte array streamow nie trzeba zamykac

	// Plan:
	// [InputStream(unzipped)] -> IOUtils.copy(..) -> [ZipOutputStream(pakuje)] ->
	// [ByteArrayOutputStream.toByteArray()] -> byte[]->
	// [ByteArrayInputStream(byte[])]

	/*
	 * Transforms input stream to zipped input stream.
	 * @return InputStream that doesn't need to be closed.
	 */
	public static InputStream zipStream(InputStream inputStream) throws IOException {		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try (ZipOutputStream output = new ZipOutputStream(byteArrayOutputStream)) {

			output.putNextEntry(new ZipEntry("janusz.txt"));

			IOUtils.copy(inputStream, output);

			output.closeEntry();
		}

		byte[] byteArray = byteArrayOutputStream.toByteArray();

		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		
		return bais;
	}

	private static void unzipStreamAndSaveToFile(InputStream inputStream) {
		try (ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {

			String directory = "C:" + File.separator + "Wazniak" + File.separator;

			ZipEntry entry = zipInputStream.getNextEntry();

			File outputFile = new File(directory + entry.getName());

			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}

			try (OutputStream os = new FileOutputStream(outputFile)) {
				IOUtils.copy(zipInputStream, os);

				zipInputStream.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
