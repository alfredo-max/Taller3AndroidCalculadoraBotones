package com.example.calculadorabotones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_display;
    private double n1,n2,respuesta;
    private String Operador="";
    boolean setOperador=false,display_respuesta=false,error=false;
    private int tamnum1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_display=(TextView)findViewById(R.id.text_display);

    }

    public void setdisplay(String dato){

        if("0".equals(tv_display.getText().toString()) || display_respuesta==true || error==true){
            tv_display.setText(dato);
            display_respuesta=false;
            estainverso=false;
            error=false;
        }else{
            tv_display.setText(tv_display.getText()+dato);
        }
    }
    public void botoncero(View view){
        setdisplay("0");
    }
    public void botonuno(View view){
     setdisplay("1");
    }
    public void botondos(View view){
        setdisplay("2");

    }
    public void botontres(View view){
        setdisplay("3");
    }
    public void botoncuatro(View view){
        setdisplay("4");

    }
    public void botoncinco(View view){
        setdisplay("5");

    }
    public void botonseis(View view){
        setdisplay("6");

    }
    public void botonsiete(View view){
        setdisplay("7");

    }
    public void botonocho(View view){
        setdisplay("8");
    }
    public void botonnueve(View view){
        setdisplay("9");
    }

    public void OnClickOperacionCapturaNumero1(View view,String Operador){


        if((setOperador==false && "0".equals(tv_display.getText().toString())==false || display_respuesta==true) && estainverso==false && error==false ){
            String display=tv_display.getText().toString();
            n1=Double.parseDouble(display);
            tamnum1=display.length();
            tv_display.setText(display+Operador);
            setOperador=true;
            display_respuesta=false;
        }


    }
    public void Sumar(View view){
        Operador="+";
        OnClickOperacionCapturaNumero1(view,Operador);

    }
    public void Resta(View view){
        Operador="-";
        OnClickOperacionCapturaNumero1(view,Operador);
    }
    public void Multiplicacion(View view){
        Operador="*";
        OnClickOperacionCapturaNumero1(view,Operador);
    }
    public void Division(View view){
        Operador="/";
        OnClickOperacionCapturaNumero1(view,Operador);
    }

    public void Raiz(View view){
        if(setOperador==false && estainverso==false && error==false){
            n1=Double.parseDouble(tv_display.getText().toString());
                respuesta=Math.sqrt(n1);
                tv_display.setText(String.valueOf(respuesta));
                display_respuesta=true;


        }
    }
    private boolean estainverso=false;
    public void inverso(View view){
        if(setOperador==false && estainverso==false){
            n1=Double.parseDouble(tv_display.getText().toString());
            if(n1!=0){
                String res="1/"+String.valueOf(n1);
                tv_display.setText(String.valueOf(res));
                display_respuesta=true;
                estainverso=true;
            }else{
                tv_display.setText("Math ERROR");
                error=true;
            }

        }
    }

    public void bigual(View view){
        if(display_respuesta==false ){
            String display=tv_display.getText().toString();
            n2=Integer.parseInt(display.substring(tamnum1+1));
            display_respuesta=true;
            setOperador=false;

            switch (Operador){
                case "+":
                    respuesta=n1+n2;
                    tv_display.setText(String.valueOf(respuesta));

                    break;
                case "-":
                    respuesta=n1-n2;
                    tv_display.setText(String.valueOf(respuesta));
                    break;
                case "*":
                    respuesta=n1*n2;
                    tv_display.setText(String.valueOf(respuesta));
                    break;
                case "/":
                    if(n2!=0){
                        respuesta=n1/n2;
                        tv_display.setText(String.valueOf(respuesta));
                    }else{
                        tv_display.setText("Math ERROR");
                        error=true;
                    }

                    break;
            }
        }

    }

    public void borrar(View vie){
        tv_display.setText("0");
        setOperador=false;
        estainverso=false;
    }



}