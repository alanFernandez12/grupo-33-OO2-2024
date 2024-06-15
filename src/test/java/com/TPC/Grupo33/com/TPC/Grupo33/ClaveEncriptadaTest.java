package com.TPC.Grupo33.com.TPC.Grupo33;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ClaveEncriptadaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();		
		String claveEncriptada = "39341588";
		System.out.println("Clave: " + claveEncriptada + " Encriptada = " + pe.encode(claveEncriptada));
		
	}

}
