package com.fr24.domain.mapper

interface Mapper<in F, out T> {

    fun map(from: F): T
}

fun <F, T> Mapper<F, T>.mapAll(from: List<F>): List<T> = from.map { map(it) }