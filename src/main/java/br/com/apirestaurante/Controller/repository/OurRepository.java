package br.com.apirestaurante.Controller.repository;

import java.io.IOException;
import java.util.List;


public interface OurRepository <T,U>{

    void salva(T t) throws IOException;
    List<T> busca() throws  IOException;
    T get(U id);
}
