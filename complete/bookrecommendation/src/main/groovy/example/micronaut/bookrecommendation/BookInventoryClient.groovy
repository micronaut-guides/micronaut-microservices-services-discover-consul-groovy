//tag::packageandimports[]
package example.micronaut.bookrecommendation

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Recoverable
import io.reactivex.Maybe

import javax.validation.constraints.NotBlank
//end::packageandimports[]

/*
//tag::harcoded[]
@Client("http://localhost:8082") // <1>
//end::harcoded[]
*/
//tag::consul[]
@Client(id = "bookinventory") // <1>
@Recoverable(api = BookInventoryOperations.class)
//end::consul[]
//tag::clazz[]
interface BookInventoryClient extends BookInventoryOperations {

    @Consumes(MediaType.TEXT_PLAIN)
    @Get("/books/stock/{isbn}")
    Maybe<Boolean> stock(@NotBlank String isbn)
}
//end::clazz[]
