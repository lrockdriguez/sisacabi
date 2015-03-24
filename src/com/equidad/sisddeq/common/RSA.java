package com.equidad.sisddeq.common;

import java.math.BigInteger;

public class RSA  {

    private BigInteger n, q, p;
    private BigInteger totient;
    private BigInteger e, d;

    /**
     * Los valores han sido calculados matem�ticamente.
     * p --> un n�mero  primo;
     * q --> numero primo menor que p;
     * e --> numero coPrimo de y menor que n
     */
    public RSA() {
        p = new BigInteger("786707");
        q = new BigInteger("069157");
        //n = p * q
        n = p.multiply(q);        
        e = new BigInteger("607211");        
        totient = p.subtract(BigInteger.valueOf(1));
        totient = totient.multiply(q.subtract(BigInteger.valueOf(1)));
        // d = e^1 mod totient
        d = e.modInverse(totient);
    }

    /**
     * Encripta el texto usando las claves declaradas en el constructor
     * 
     * @param   mensaje     Ristra que contiene el mensaje a encriptar
     * @return   El mensaje cifrado como un vector de BigIntegers
     */
    public String encriptar(String password)
    {       
        byte[] temp = new byte[1];
        byte[] digitos = password.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        
        for(int i=0; i<bigdigitos.length;i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }        
        BigInteger[] encriptado = new BigInteger[bigdigitos.length];
        for(int i=0; i<bigdigitos.length; i++)
            encriptado[i] = bigdigitos[i].modPow(e,n);        
        String devol = "";
        String cantNum = "";
        int i = 0;
        for(i=0; i<encriptado.length; i++){
            devol += encriptado[i].toString(16).toUpperCase();
            cantNum += encriptado[i].toString(16).length();
        }
        return (i + "G" + devol + cantNum);
    }
    
    
    
    /**
     * Desencripta el texto cifrado usando la clave privada
     *
     * @param   encriptado  String con la clave encriptada y
     *          en Hexadecimal
     * @return  Una cadena con el valor desencriptado
     */    
    public String desencriptar(String cadEncriptada) {
        
        int cantPart = Integer.parseInt(cadEncriptada.substring(0, cadEncriptada.indexOf("G")));
        
        Integer[] numCaractPart = new Integer[cantPart];
        
        for(int i=0; i<cantPart; i++){
            int inicio = (cadEncriptada.length()-(cantPart*2))+(i*2);
            numCaractPart[i] = Integer.parseInt(cadEncriptada.substring(inicio, inicio+2));
        }
        cadEncriptada = cadEncriptada.substring(cadEncriptada.indexOf("G")+1, cadEncriptada.length()-(cantPart*2));

        
        BigInteger[] encriptado = new BigInteger[cantPart];
        
        int iniNum = 0;
        
        for(int i=0; i<cantPart ; i++){
            encriptado[i] = new BigInteger(Hexadecimal(cadEncriptada.substring(iniNum,iniNum+numCaractPart[i])));
            iniNum += numCaractPart[i];
        }
        
        BigInteger[] desencriptado = new BigInteger[encriptado.length];
        
        for(int i=0; i<desencriptado.length; i++)
            desencriptado[i] = encriptado[i].modPow(d,n);
        
        char[] charArray = new char[desencriptado.length];
        
        for(int i=0; i<charArray.length; i++)
            charArray[i] = (char) (desencriptado[i].intValue());
        
        return(new String(charArray));
    }

    /**
     * Transforma toda una cadena de Hexadecimal 
     * a formato en base 10
     * @param cadena
     * @return un String coteniendo el numero decimal.
     */

    private String Hexadecimal(String cadena){
    
         BigInteger num = new BigInteger(extraerNum(0,cadena));
         
         for(int i=1; i<cadena.length(); i++){
             num = num.multiply(new BigInteger("8"));
             num = num.add(new BigInteger(extraerNum(i, cadena)));
         }
         return String.valueOf(num);
    }
     /**
      * Determina que caracter representa el digito Hexadecimal en 
      * sistema Decimal
      * @param index
      * @param numero
      * @return el numero en base 10
      */
     private String extraerNum(int index, String numero){
         char caracter = numero.charAt(index);
         switch(caracter){
             case 'A':
                 return "10";
             case 'B':
                 return "11";
             case 'C':
                 return "12";
             case 'D':
                 return "13";
             case 'E':
                 return "14";
             case 'F':
                 return "15";
             default:
                 return String.valueOf(caracter);
         }
     }
}
