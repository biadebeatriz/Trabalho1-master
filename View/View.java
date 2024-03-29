package View;

import pt.clubedohardware.userinterface.AnimationC;
import pt.clubedohardware.userinterface.IAnimationC;
import Interfaces.IView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class View implements IView{
    IAnimationC animation;
    String name;
    ArrayList<String> falas;
    ArrayList<String> personagens;

    public View(){
        animation = new AnimationC();
        this.name = this.generateString(new Random(), "qwertyialskdcn", 10);
        this.setView("Grupo 1", this.name + "da Silva", "Doctor");
        falas = new ArrayList<String>();
        personagens = new ArrayList<String>();
        falas.add("Hi");
        personagens.add("doctor");
        falas.add("HELloW I'm sICKKKKKK");
        personagens.add("pacient");
    }


    public void setView(String win, String pacient, String doctor){
        this.animation.setDocName(doctor);
        this.animation.setPacientName(pacient);
        this.animation.setWindowName(win);
    }

    private String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public void diagnostico(String doenca){
        falas.add("Your disease is " + doenca);
        personagens.add("doctor");
        falas.add("OMG VOU TE  COMER");
        personagens.add("pacient");
        String[] f = this.falas.toArray(new String[0]);
        String[] p = this.personagens.toArray(new String[0]);
        this.animation.story(f, p);
    }

    public void updateV(String[] atributos, int pergunta, String resp){
        String resposta;
        String ask = atributos[pergunta];
        if(resp.equals("t")){
            resposta = " Yes ):";
        }
        else{
            resposta = " No";
        }
        this.falas.add("Do you have " + ask+ "?");
        this.personagens.add("doctor");
        this.falas.add(resposta);
        this.personagens.add("pacient");
    }

}
