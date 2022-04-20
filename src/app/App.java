package app;
import java.util.Scanner;



public class App {
	
	    static Scanner teclado;
	public static void main(String[] args) {
		
		
		 teclado = new Scanner(System.in);
		 
	       	Maquina maquina = new Maquina(60,"Colectivo 221",500);
	        int key = -1;
	        
	        while (key!=0){
	            menu_user();
	            key = teclado.nextInt();
switch (key) {
case 1: {
	System.out.println("El precio del boleto es: " + maquina.get_precio_boleto());
	break;
	
}

case 2:

if(maquina.validar_stock()==true)
{
	Boleto boleto=	maquina.generar_boleto();
	System.out.println("Boleto adquirido ");
	imprimir_boleto(boleto);
	
}
break;
case 3:
	Boolean llave=ingreso_modo_tecnico();
	if(llave==true)
	{
		System.out.println("Stock disponible: "+maquina.get_stock_boletos());
		System.out.println("Boletos vendidos: "+maquina.get_cant_boletos());
		System.out.println("Recaudacion: "+maquina.get_recaudacion());
	
		modo_tecnico(maquina,llave);
		
	}
	
	 System.out.println("Cambiar precio");
	break;
case 0:
    System.out.println("Saliendo...");
    break;
}
	}
	
	        
teclado.close();
	
}

public static void imprimir_boleto(Boleto boleto){
	 
    System.out.println("================");
    System.out.println("Precio: "+ boleto.get_precio());
    System.out.println("Fecha: "+ boleto.get_fecha());
    System.out.println("Tipo: "+ boleto.get_tipo());
    System.out.println("================");
    
}
public static void menu_user(){
    System.out.println("[1] Precio del boleto.");
    System.out.println("[2] Comprar boleto.");
    System.out.println("[3] Entrar modo tecnico");
   
    System.out.println("[0] Salir.");

}
public static boolean ingreso_modo_tecnico()
{
	String contraseña="hola";
	String input="";
	Boolean acceso=false;
	int i=2;
	do {
		System.out.println("Ingrese la contraseña a continuacion ");
		teclado.nextLine();
		input=teclado.nextLine();
		if(contraseña.equals(input))
		{
			acceso=true;
			i=5;
			System.out.println("Acceso permitido");
		}else
		{
			System.out.println("Error,contraseña incorrecta.Le quedan: " +i );
			i--;
			
		}
	}while(i!=5);
	return acceso;
	
}
public static void menu_tecnico(){
    System.out.println("[1] Editar precio del boleto.");
    System.out.println("[2] Editar tipo del boleto.");
    System.out.println("[3] Renovar stock.");
    System.out.println("[4] Vaciar recaudación.");
    System.out.println("[5] Reiniciar la máquina.");
    System.out.println("[0] Salir.");

}
public static void modo_tecnico(Maquina maquina,Boolean llave) {
	if(llave==true)
	{
		int nro=-1;
		
		while(nro!=0)
		{
		menu_tecnico();
		nro=teclado.nextInt();
		switch(nro)
		{
		case 1:
			System.out.println("Ingrese a continuacion el nuevo precio del boleto");
			float n_precio=teclado.nextFloat();
			maquina.set_precio_boleto(n_precio);
			break;
		case 2:
			System.out.println("Cambie el tipo de boleto");
			teclado.nextLine();
			String n_boleto=teclado.nextLine();
			maquina.set_tipo_boleto(n_boleto);
			break;
			
		case 3:
			System.out.println("Cambie el stock disponible");
			int opcion=-1;
			int n_stock;
			do {
			System.out.println("1- Reinicie el stock a 500 ");
			System.out.println("2- Elegir stock disponible ");
			opcion=teclado.nextInt();
			
			if(opcion==1)
			{
				n_stock=500;
				maquina.set_stock_boletos(n_stock);
			}
			else if(opcion==2)
			{
				n_stock=teclado.nextInt();
				maquina.set_stock_boletos(n_stock);
			}
			else {
				System.out.println("Error,opcion incorrecta.Vuelva a elegir");
				opcion=-1;
			}
			
		}while(opcion==-1);
			break;
		 case 4:
             System.out.println("Recolectando recaudación...");
             System.out.println("Fueron recaudados: $" + maquina.vaciar_recaudacion());    
             System.out.println("Actualmente la maquina tiene: $"+maquina.get_recaudacion());
             break;
             
		 case 5:
             System.out.println("Reiniciando la maquina...");
             maquina.reinicio_maquina();
             break;
			
		case 0:
			System.out.println("Saliendo....");
			break;
		
		
	}
		}
	}
}
}
	

		



