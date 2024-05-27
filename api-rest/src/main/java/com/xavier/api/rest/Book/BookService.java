package com.xavier.api.rest.Book;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository _bookRepository;
    
    public void CreateBook(Book book)
    {
        _bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return _bookRepository.findById(id).orElse(null);
    }

    public boolean deleteBookById(Long id) {
        try {
            _bookRepository.deleteById(id);
            return true; 
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = _bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            // Actualiza los campos relevantes del libro existente con los datos de updatedBook
            existingBook.setNombre(updatedBook.getNombre());
            // ... (otros campos)
            _bookRepository.save(existingBook);
            return existingBook;
        }
        return null; // Si no se encuentra el libro con el ID proporcionado
    }

    public List<Book> getAllBooks() {
        return _bookRepository.findAll();
    }
}
