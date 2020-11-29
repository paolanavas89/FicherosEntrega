
import java.io.RandomAccessFile;
import java.io.IOException;

public abstract class AbstractaManejoFichero {
	
    protected RandomAccessFile fich=null;  

    protected abstract int numRegistros()throws IOException;

    protected abstract Registro leerRegistro(int nRegistro) throws IOException;
      
    protected abstract void escribirRegistro(Registro reg, int nRegistro)  throws IOException;
    
    protected abstract void cierraFich()throws IOException;
    
}