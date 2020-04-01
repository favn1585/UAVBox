package com.fr24.domain.rx

import io.reactivex.Scheduler

interface SchedulersProvider {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun ui(): Scheduler
}