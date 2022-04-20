package app;
import java.util.Date;

public class Boleto {
	private float precio;
	private Date fecha;
	private String tipo_boleto;

public Boleto(float precio, String tipo_boleto)
{
	this.fecha= new Date();
	this.precio=precio;
	this.tipo_boleto=tipo_boleto;
}
public float get_precio(){
    return precio;
}

public float set_precio(float nuevo){
    return precio=nuevo;
}

public Date get_fecha(){
    return fecha;
}

public String get_tipo(){
    return tipo_boleto;
}
}
