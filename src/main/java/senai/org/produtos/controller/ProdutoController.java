package senai.org.produtos.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import senai.org.produtos.entity.Produto;
import senai.org.produtos.repository.ProdutoRepository;


@Controller
@RequestMapping(path = "/api/Produto")
@CrossOrigin
public class ProdutoController {
    @Autowired ProdutoRepository pRepository;

    @PostMapping("/")
    public @ResponseBody Integer addProduto(@RequestBody Produto objP){
        pRepository.save(objP);
        return objP.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Produto>buscarProdutos(){
        return pRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto>buscarProduto(@PathVariable Integer id){
        return pRepository.findById(id);
    }

    @PutMapping("/")
    public @ResponseBody Produto atualizar(@RequestBody Produto objP){
        pRepository.save(objP);
        return objP;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id){
        pRepository.deleteById(id);
        return " Produto Aapagado com sucesso! ";
    }
}
