package com.Grupo33.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//HOME
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";
	
	//USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	
	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String ClientROUTE = "/indexCliente";
	
	//Producto
	public final static String AgregarProducto   = "/producto/agregarProducto";
	public final static String ListaProducto     = "/producto/listaProducto";
	public final static String ModificarProducto = "/producto/modificarProducto";
	public final static String verStockProducto = "/stock/stockProducto";
	
	//Stock
	public final static String verStock = "/stock/listaStock";
	
	//Lote
	public final static String AgregarLote = "/lote/agregarLote";
	public final static String ListaLote= "/lote/listaLote";
	
	//Pedido
	public final static String AgregarPedido = "/pedido/agregarPedido";
	public final static String PedidosRealizados = "/pedido/pedidosRealizados";
}
