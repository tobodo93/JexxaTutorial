package io.jexxa.tutorials.bookstorej.domainservice;

package io.jexxa.tutorials.bookstorej.domainservice;

import java.util.stream.Stream;

import io.jexxa.addend.applicationcore.DomainService;
import io.jexxa.tutorials.bookstorej.domain.valueobject.ISBN13;
import io.jexxa.tutorials.bookstorej.domain.aggregate.Book;
import org.apache.commons.lang3.Validate;

@DomainService
public class ReferenceLibrary
{
    private final IBookRepository bookRepository;

    public ReferenceLibrary(IBookRepository bookRepository)
    {
        Validate.notNull(bookRepository);
        this.bookRepository = bookRepository;
    }

    public void addLatestBooks()
    {
        getLatestBooks()
                .filter(book -> ! bookRepository.isRegistered(book))
                .forEach(isbn13 -> bookRepository.add(Book.newBook(isbn13)));
    }

    /** Some Random books found in internet */
    private Stream<ISBN13> getLatestBooks()
    {
        return Stream.of(
                new ISBN13("978-1-60309-025-4" ),
                new ISBN13("978-1-60309-025-4" ),
                new ISBN13("978-1-60309-047-6" ),
                new ISBN13("978-1-60309-322-4" ),
                new ISBN13("978-1-891830-85-3" ),
                new ISBN13("978-1-60309-016-2" ),
                new ISBN13("978-1-60309-265-4" )
        );
    }
}
