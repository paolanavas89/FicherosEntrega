import java.io.Serializable;
public class Registro implements Serializable {

	public static final byte TAMGNO_NOMBRE=20;
	public static final byte TAMAGNO_REG=51;
    
	private static final long serialVersionUID = 79640851033634709L;
	 private  String nombre;
     private int edad;
     private float peso;  
     private char genero;
     private boolean casado;
     

    public Registro(){
           nombre="";
           edad=0;
           peso=0;
           genero=' ';
           casado=false;
       }

    public Registro(String nombre,int edad,float peso,char genero,boolean casado) { 
              this.nombre=nombre;
              this.edad=edad;
              this.peso=peso;
              this.genero=genero;
              this.casado=casado;
     }
     public String getNombre(){
         return nombre;
     }
     public void setNombre(String nombre){
         this.nombre=nombre;
     } 
     public int getEdad() {
    	 return edad;
     }
     public void setEdad(int edad) {
    	 this.edad=edad;
     }
     public float getPeso() {
    	 return peso;
     }
     public void setPeso(float peso) {
    	 this.peso=peso;
     }
     public char getGenero(){
         return genero;
     }
     public void setGenero(char genero){
         this.genero=genero;
     } 
     public boolean getCasado(){
         return casado;
     }
     public void setCasado(boolean casado){
         this.casado=casado;
     }
     public String toString(){
    		return nombre+"-"+edad+"-"+peso+"-"+genero+"-"+casado;
    	}

     

}
