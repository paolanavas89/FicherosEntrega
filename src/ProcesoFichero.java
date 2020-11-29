import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class ProcesoFichero {

	public static void main(String[] args) {

		final byte VECES = 5;

		// Primero definimos el fichero
		File fichero = new File("Datos.bin");

		ManejoFichero fich = null;

		try {

			fich = new ManejoFichero(fichero, "rw");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Añado "+VECES+" registros:");
		for(int i=0;i<VECES;i++) {
			
			Registro reg= getRegistro();
			int nRegistro=0;
			try {
				 nRegistro=fich.numRegistros()+1;
				 fich.escribirRegistro(reg, nRegistro);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		Registro reg2;
		try {
			reg2= fich.leerRegistro(4);
			System.out.println(reg2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Modificar
		try {
			fich.escribirRegistro(getRegistro(),2);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		//Leer todos los reg
		int numReg;
		try {
			numReg = fich.numRegistros();
			
			for(int i=1;i<=numReg;i++) {
				System.out.println(fich.leerRegistro(i));
				
			}
			fich.cierraFich();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static Registro getRegistro() {

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\r\n");
		String nombre;
		do {
			System.out.println("Introduzca su nombre: ");
			nombre = sc.next();
		} while (nombre.length() > Registro.TAMAGNO_REG);
		System.out.println("Introduzca su edad: ");
		int edad = sc.nextInt();
		System.out.println("Introduzca su peso: ");
		float peso = sc.nextFloat();
		System.out.println("Introduzca su genero: ");
		char genero = sc.next().charAt(0);
		System.out.println("Introduzca si está casado: ");
		String casadoTexto = sc.next();

		boolean casado = false;
		if (casadoTexto.equalsIgnoreCase("s")) {
			casado = true;
		}
		Registro registro = new Registro(nombre, edad, peso, genero, casado);
		return registro;

	}

}
