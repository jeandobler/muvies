package com.dobler.search

import org.junit.Test

class SearchViewModelTest {

    @Test
    fun `loadNextPage initial state`() {
        // Verify that calling loadNextPage when in the Default state transitions to Loading, 
        // then Success, and appends movies.
        // TODO implement test
    }

    @Test
    fun `loadNextPage subsequent calls`() {
        // Verify that subsequent calls to loadNextPage after an initial search and load 
        // increment the page number and append new movies.
        // TODO implement test
    }

    @Test
    fun `loadNextPage repository success with empty list`() {
        // Test the behavior when the searchRepository.search returns an empty list of movies 
        // for the next page. The state should still become Success, and no movies should be added.
        // TODO implement test
    }

    @Test
    fun `loadNextPage repository error`() {
        // Test the behavior when the searchRepository.search throws an exception during loadNextPage. 
        // The state should transition to Error.
        // TODO implement test
    }

    @Test
    fun `loadNextPage concurrent calls`() {
        // Test the behavior when loadNextPage is called multiple times concurrently. 
        // Ensure that currentPage is incremented correctly and movies are appended in the expected order.
        // TODO implement test
    }

    @Test
    fun `search initial call`() {
        // Verify that calling search for the first time transitions to Loading, 
        // sets the query, resets currentPage, and appends movies from the first page.
        // TODO implement test
    }

    @Test
    fun `search with same query`() {
        // Test calling search with the same query again. Verify that currentPage is reset 
        // to 1 and the results are replaced with the first page of the search results for that query.
        // TODO implement test
    }

    @Test
    fun `search with different query`() {
        // Test calling search with a new query after a previous search. 
        // Verify that currentPage is reset to 1, the new query is set, and the movie list is cleared before appending the new search results.
        // TODO implement test
    }

    @Test
    fun `search repository success with empty list`() {
        // Test the behavior when the searchRepository.search returns an empty list of movies 
        // for a search query. The state should transition to Success, and the movie list should become empty.
        // TODO implement test
    }

    @Test
    fun `search repository error`() {
        // Test the behavior when the searchRepository.search throws an exception during search. 
        // The state should transition to Error, and the error should be captured.
        // TODO implement test
    }

    @Test
    fun `search with empty query`() {
        // Test calling search with an empty string as the query. 
        // Verify the behavior, likely should still attempt to search or handle gracefully.
        // TODO implement test
    }

    @Test
    fun `search and then loadNextPage`() {
        // Test the sequence of calling search followed by loadNextPage. 
        // Verify that loadNextPage uses the correct lastSearchedQuery and increments the page number.
        // TODO implement test
    }

    @Test
    fun `loadNextPage before search`() {
        // Test calling loadNextPage before any search has been performed. 
        // Verify the behavior, likely should search with an empty query and page 1, or handle this case specifically if it's not intended.
        // TODO implement test
    }

    @Test
    fun `search and loadNextPage with repository returning different number of movies per page`() {
        // Test that the appending logic works correctly when the searchRepository 
        // returns varying numbers of movies for different pages.
        // TODO implement test
    }

    @Test
    fun `Concurrent search calls`() {
        // Test the behavior when search is called multiple times concurrently with different queries. 
        // Verify that the latest search takes precedence and sets the correct query and state.
        // TODO implement test
    }

    @Test
    fun `Concurrent loadNextPage calls after search`() {
        // Test the behavior when loadNextPage is called multiple times concurrently after a search. 
        // Verify that currentPage is incremented correctly and movies are appended from the appropriate pages.
        // TODO implement test
    }

}