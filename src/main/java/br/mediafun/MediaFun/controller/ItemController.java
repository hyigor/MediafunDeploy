package br.mediafun.MediaFun.controller;

import br.mediafun.MediaFun.dto.RequisicaoNovaSerie;
import br.mediafun.MediaFun.dto.RequisicaoNovoFilme;
import br.mediafun.MediaFun.dto.RequisicaoNovoLivro;
import br.mediafun.MediaFun.model.Filme;
import br.mediafun.MediaFun.model.Livro;
import br.mediafun.MediaFun.model.Serie;
import br.mediafun.MediaFun.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("escolhaTipo")
//    @ResponseBody
    public String escolhaTipo(){
        return "escolhaTipo";
    }

    @GetMapping("formularioLivro")
//    @ResponseBody
    public String formularioLivro(RequisicaoNovoLivro requisicao){
        return "formularioLivro";
    }

    @GetMapping("formularioFilme")
//    @ResponseBody
    public String formularioFilme(RequisicaoNovoFilme requisicao){
        return "formularioFilme";
    }

    @GetMapping("formularioSerie")
//    @ResponseBody
    public String formularioSerie(RequisicaoNovaSerie requisicao){
        return "formularioSerie";
    }



    @PostMapping("novoLivro")
    public String novoLivro(@Valid RequisicaoNovoLivro requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioLivro";
        }
        Livro livro = requisicao.toLivro();
        itemRepository.save(livro);
        return "escolhaTipo";
    }

    @PostMapping("novoFilme")
    public String novoFilme(@Valid RequisicaoNovoFilme requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioFilme";
        }
        Filme filme = requisicao.toFilme();
        itemRepository.save(filme);
        return "escolhaTipo";
    }

    @PostMapping("novaSerie")
    public String novaSerie(@Valid RequisicaoNovaSerie requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioSerie";
        }
        Serie serie = requisicao.toSerie();
        itemRepository.save(serie);
        return "escolhaTipo";
    }
}
