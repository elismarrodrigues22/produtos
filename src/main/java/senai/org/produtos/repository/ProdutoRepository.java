package senai.org.produtos.repository;

import org.springframework.data.repository.CrudRepository;

import senai.org.produtos.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    
}
