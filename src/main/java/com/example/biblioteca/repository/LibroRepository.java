package com.example.biblioteca.repository;

import com.example.biblioteca.model.Libro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
//Especializacion de la anotacion @Component
//Se usa para anotar clases que acceden a la base de datos, encapsulan el
//almacenamiento, recuperacion y búsqueda de objetos de dominio
public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    @PostConstruct
    public void init(){
        listaLibros.add(new Libro(1, "978-0134685991", "Effective Java", "Addison-Wesley", 2018, "Joshua Bloch"));
        listaLibros.add(new Libro(2, "978-1617294945", "Spring in Action", "Manning", 2020, "Craig Walls"));
        listaLibros.add(new Libro(3, "978-1491950357", "Designing Data-Intensive Applications", "O'Reilly Media", 2017, "Martin Kleppmann"));
        listaLibros.add(new Libro(4, "978-0132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }

    public List<Libro> getLibros(){
        return listaLibros;
    }

    public Libro getLibroPorId(int id){
        for(Libro libro : listaLibros){ // 
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro getLibroPorIsbn(String isbn){
        for(Libro libro : listaLibros){
            if(libro.getIsbn() == isbn){
                return libro;
            }
        }
        return null;
    }

    public Libro getLibroPorAutor(String autor){
        for(Libro libro : listaLibros){
            if(libro.getAutor() == autor){
                return libro;
            }
        }
        return null;
    }

    public Libro guardarLibro(Libro libro){
        listaLibros.add(libro);
        return libro;
    }

    public Libro actualizarLibro(Libro libro){

        int id = 0;
        int idPosicion = 0;

        for(int i=0;i < listaLibros.size();i++){
            if(listaLibros.get(i).getId() == libro.getId()){
                id = libro.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setIsbn(libro.getIsbn());
        libro1.setTitulo(libro.getTitulo());
        libro1.setEditorial(libro.getEditorial());
        libro1.setFechaPublicacion(libro.getFechaPublicacion());
        libro1.setAutor(libro.getAutor());

        listaLibros.set(idPosicion,libro1);

        return libro1;

    }

}
