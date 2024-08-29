package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;
import java.util.Random;

import java.util.ArrayList;

@Controller
public class HomeController {
    @RequestMapping(value = {"/juego"}, method = RequestMethod.GET)
    public String holaMundo (){
        return "juego";
    }


    /***@GetMapping("/persona")
    public String unaPersona(Model model){
        Persona persona = new Persona("Juan", "Perez", "12345678", 20);
        model.addAttribute("persona", persona);
        return "persona";
    }***/
    @PostMapping("jugando")
    public String jugando(@RequestParam("letra") char letra,
                          @RequestParam("actual") String actual,
                          @RequestParam("intentos") String intentos,
                          @RequestParam("correcta") String correcta, Model model){
        int inten = Integer.parseInt(intentos);
        inten--;
        String nuevo = new String();
        for(int i = 0; i < correcta.length(); i++){
            if(correcta.charAt(i) == letra){
                nuevo = nuevo + letra;
            } else {
                nuevo = nuevo + actual.charAt(i);
            }
        }

        PalabraJuego p = new PalabraJuego(correcta, nuevo, inten);
        model.addAttribute("palabrajuego", p);
        for(int i = 0; i < correcta.length(); i++){
            if(nuevo.charAt(i) == '_'){
                if(inten == 0) {
                    return "lose";
                }
                return "juego";

            }

        }

        return "win";

    }

    @GetMapping("/formulario")
    public String formularioPersona (Model model){
        return "formulario";
    }


    @PostMapping("/testing")
    public String guardarPersona( @RequestParam("nombre") String name,
                                  @RequestParam("tema") String tema,
                                  @RequestParam("intentos") String intento, Model model){
        ArrayList<Palabra> listaPalabras = new ArrayList<>();
        listaPalabras.add(new Palabra("leon", 4, "Animal"));
        listaPalabras.add(new Palabra("elefante", 8, "Animal"));
        listaPalabras.add(new Palabra("tigre", 5, "Animal"));
        listaPalabras.add(new Palabra("cebra", 5, "Animal"));
        listaPalabras.add(new Palabra("jirafa", 6, "Animal"));
        listaPalabras.add(new Palabra("delfin", 6, "Animal"));
        listaPalabras.add(new Palabra("ballena", 7, "Animal"));
        listaPalabras.add(new Palabra("gorila", 6, "Animal"));
        listaPalabras.add(new Palabra("panda", 5, "Animal"));
        listaPalabras.add(new Palabra("aguila", 6, "Animal"));
        listaPalabras.add(new Palabra("hipopotamo", 10, "Animal"));
        listaPalabras.add(new Palabra("koala", 5, "Animal"));
        listaPalabras.add(new Palabra("lobo", 4, "Animal"));
        listaPalabras.add(new Palabra("oso", 3, "Animal"));
        listaPalabras.add(new Palabra("canguro", 7, "Animal"));
        listaPalabras.add(new Palabra("manzana", 7, "Frutas"));
        listaPalabras.add(new Palabra("platano",7 , "Frutas"));
        listaPalabras.add(new Palabra("kiwi", 4, "Frutas"));
        listaPalabras.add(new Palabra("mango", 5, "Frutas"));
        listaPalabras.add(new Palabra("pera", 4, "Frutas"));
        listaPalabras.add(new Palabra("uva",3 , "Frutas"));
        listaPalabras.add(new Palabra("fresa",5 , "Frutas"));
        listaPalabras.add(new Palabra("naranja", 7, "Frutas"));
        listaPalabras.add(new Palabra("piña", 4, "Frutas"));
        listaPalabras.add(new Palabra("sandia",6 , "Frutas"));
        listaPalabras.add(new Palabra("cereza",6 , "Frutas"));
        listaPalabras.add(new Palabra("melon", 5, "Frutas"));
        listaPalabras.add(new Palabra("papaya", 6, "Frutas"));
        listaPalabras.add(new Palabra("limon", 5, "Frutas"));
        listaPalabras.add(new Palabra("higo", 4, "Frutas"));
        listaPalabras.add(new Palabra("mexico", 6, "Paises"));
        listaPalabras.add(new Palabra("canada", 6, "Paises"));
        listaPalabras.add(new Palabra("brasil",6 , "Paises"));
        listaPalabras.add(new Palabra("españa",6 , "Paises"));
        listaPalabras.add(new Palabra("francia",7 , "Paises"));
        listaPalabras.add(new Palabra("italia", 6, "Paises"));
        listaPalabras.add(new Palabra("alemania", 8, "Paises"));
        listaPalabras.add(new Palabra("japon", 5, "Paises"));
        listaPalabras.add(new Palabra("australia",9 , "Paises"));
        listaPalabras.add(new Palabra("argentina",9 , "Paises"));
        listaPalabras.add(new Palabra("chile", 5, "Paises"));
        listaPalabras.add(new Palabra("peru",4 , "Paises"));
        listaPalabras.add(new Palabra("estadosunidos",13 , "Paises"));
        listaPalabras.add(new Palabra("china",5 , "Paises"));
        listaPalabras.add(new Palabra("india",5 , "Paises"));

        Palabra palabra = new Palabra(name, Integer.parseInt(name), tema);

        ArrayList<Palabra> listaEncontrados = new ArrayList<>();
        for(int i = 0; i < listaPalabras.size(); i++){
            if(palabra.getTipo().equals(listaPalabras.get(i).getTipo()) && palabra.getLongitud() == listaPalabras.get(i).getLongitud()){
                listaEncontrados.add(listaPalabras.get(i));
            }
        }

        if(listaEncontrados.size() == 0){
            return "formulario";

        } else {
            Random aleatorio = new Random(System.currentTimeMillis());

            int intAletorio = aleatorio.nextInt(listaEncontrados.size());

            aleatorio.setSeed(System.currentTimeMillis());

            String ga = new String();
            for(int i = 0; i < palabra.getLongitud(); i++) {ga += '_';}
            PalabraJuego p = new PalabraJuego(listaEncontrados.get(intAletorio).getNombre(), ga, Integer.parseInt(intento));


            model.addAttribute("palabrajuego", p);
            return "juego";
        }

    }

}
