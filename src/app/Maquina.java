package app;


public class Maquina {

	public static int cant_maquinas=0;
	private float recaudacion;
	private int id;
	private float precio;
	private int cant_boletos=0;
	private String tipo_boleto;
	private int stock_boletos;
	private float ultima_recaudacion;

	
	public Maquina(float precio, String tipo_boleto, int stock_boletos)
	{
	this.id=cant_maquinas+1;
	cant_maquinas++;
	
	this.precio=precio;
	this.stock_boletos=stock_boletos;
	this.tipo_boleto=tipo_boleto;
	this.cant_boletos=0;
	this.ultima_recaudacion=0;
	
	}
	 
	public float get_precio_boleto()
	{
		return precio;
	}
	public float set_precio_boleto(float nuevo)
	{
		return nuevo;
	}
	public int get_stock_boletos()
	{
		return stock_boletos;
	}
	public int set_stock_boletos(int nuevo)
	{
		return nuevo;
	}
	public Boolean validar_stock()
	{
		int stock=get_stock_boletos();
		Boolean hay_stock= false;
		
		if(stock>0)
		{
			hay_stock=true;
		}
	
	return hay_stock;
	}
	public String get_tipo_boleto()
	{
		return tipo_boleto;
	}
	public String set_tipo_boleto(String nuevo)
	{
		return nuevo;
	}

public Boleto generar_boleto()
{
	Boleto boleto=new Boleto(get_precio_boleto(),get_tipo_boleto());
	
	stock_boletos--;
	cant_boletos++;
	recaudacion=recaudacion+precio;
	get_recaudacion();
	
	return boleto;
}
public float get_recaudacion()
{
	return recaudacion;
}
public int get_id(){
    return id;
}
public int get_cant_boletos(){
    return cant_boletos;
}

public float vaciar_recaudacion()
{
	ultima_recaudacion=get_recaudacion();
	recaudacion=0;
	return ultima_recaudacion;
}
public void reinicio_maquina()
{
	   precio = 0;
       cant_boletos = 0;
       ultima_recaudacion = 0;
       recaudacion = 0;
       stock_boletos = 0;
       tipo_boleto = "";
}

}