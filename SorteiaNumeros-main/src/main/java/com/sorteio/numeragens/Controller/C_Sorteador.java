package com.sorteio.numeragens.Controller;

import com.sorteio.numeragens.Service.S_Sorteador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class C_Sorteador {

    @GetMapping("/")
    public String pagInicial() {
        return "inicPage/firstPage";
    }

    @GetMapping("/inicio")
    public String getFirstPage() {
        return "inicPage/firstPage";
    }

    @GetMapping("/paginaResultado")
    public String getResultPage(){
        return "resultPage/resultpage";
    }

    @PostMapping("/paginaResultado")
    public String drawNumbers(@RequestParam("quantityNumbers") int quantidade,
                              @RequestParam("minNumber") int min,
                              @RequestParam("maxNumber") int max,
                              @RequestParam("checkBox") boolean checkedOrdenarN,
                              @RequestParam("checkBox2") boolean checkedRepetirN,
                              Model model){


        model.addAttribute("qtdSorteada", quantidade);
        model.addAttribute("numerosSorteados", S_Sorteador.geraNumeros(min, max, quantidade, checkedOrdenarN, checkedRepetirN));
        model.addAttribute("numeroMinimo", min);
        model.addAttribute("numeroMaximo", max);

        return "resultPage/resultpage";
    }
}
