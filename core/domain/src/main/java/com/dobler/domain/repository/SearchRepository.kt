package com.dobler.domain.repository

import com.dobler.domain.vo.MovieVO
import kotlinx.coroutines.flow.Flow

interface SearchRepository{

    fun search(query: String, currentPage: Int): Flow<List<MovieVO>>

}