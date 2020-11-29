import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class ManejoFichero  extends AbstractaManejoFichero {
	
	public ManejoFichero(File fichero, String modo) throws Exception{
		fich=new RandomAccessFile(fichero,modo);
		
	}
	

	@Override
	protected int numRegistros() throws IOException {
	System.out.println(fich.length());	
		return (int) (fich.length()/Registro.TAMAGNO_REG);
		
	}

	@Override
	protected Registro leerRegistro(int nRegistro) throws IOException {
			
		fich.seek((nRegistro-1)*Registro.TAMAGNO_REG);
		
		String nombre="";
		int edad;
		float peso;
		char genero;
		boolean casado;
		
		//En las dos línea siguientes me da error
		for(int i=0;i<Registro.TAMGNO_NOMBRE;i++){
			nombre= nombre +fich.readChar();
		}
		
		edad=fich.readInt();
		peso=fich.readFloat();
		genero=fich.readChar();
		casado=fich.readBoolean();
		Registro reg=new Registro(nombre,edad,peso,genero,casado);
		return reg;
	}

	@Override
	protected void escribirRegistro(Registro reg, int nRegistro) throws IOException {
		fich.seek((nRegistro-1)*Registro.TAMAGNO_REG);
		
		StringBuffer buf= new StringBuffer();
		buf.append(reg.getNombre());
		buf.setLength(Registro.TAMGNO_NOMBRE);
		System.out.println(buf.toString());
		fich.writeChars(buf.toString());
		fich.writeInt(reg.getEdad());
		fich.writeFloat(reg.getPeso());
		fich.writeChar(reg.getGenero());
		fich.writeBoolean(reg.getCasado());
		
	}

	@Override
	protected void cierraFich() throws IOException {
		fich.close();
		
	}
	
	
	
	

}
