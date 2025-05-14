package com.dobler.domain.vo

data class MovieVO(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String?
)