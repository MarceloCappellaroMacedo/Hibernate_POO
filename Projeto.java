package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToMany(mappedBy = "projetos")
    private List<Pessoa> pessoas = new ArrayList<>();
    
    public Projeto() {}
    
    public Projeto(String nome) {
        this.nome = nome;
    }
        
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Pessoa> getPessoas() {
        return pessoas;
    }
    
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    public void addPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        pessoa.getProjetos().add(this);
    }
    
    public void removePessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
        pessoa.getProjetos().remove(this);
    }
}