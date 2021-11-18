package com.epam.demo.controller;

import com.epam.demo.controller.dto.AuthorDto;
import com.epam.demo.controller.dto.BookDto;
import com.epam.demo.service.LibraryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(tags = "API description for SWAGGER docuemntation")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public class LibraryController {

    private final LibraryService libraryService;

    @ApiOperation("Get author by id")
    @GetMapping(value = "/author/{authorId}")
    public AuthorDto getAuthorById(@PathVariable String authorId) {
        return libraryService.getAuthorInfo(authorId);
    }

    @ApiOperation("Create author")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/author")
    public AuthorDto createAuthor(@RequestBody @Valid AuthorDto authorDto) {
        return libraryService.createAuthor(authorDto);
    }

    @ApiOperation("Get author books")
    @GetMapping(value = "/author/{authorId}/book")
    public Set<BookDto> getAuthorBooks(@PathVariable String authorId) {
        return libraryService.getAuthorBooks(authorId);
    }

    @ApiOperation("Add author books")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/author/{authorId}/book")
    public BookDto addBook(@PathVariable String authorId, @Valid @RequestBody BookDto bookDto) {
        return libraryService.createBook(authorId, bookDto);
    }

}
